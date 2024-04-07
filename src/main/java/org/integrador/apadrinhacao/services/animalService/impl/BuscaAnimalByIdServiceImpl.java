package org.integrador.apadrinhacao.services.animalService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.AnimalModel;
import org.integrador.apadrinhacao.repositories.AnimalRepository;
import org.integrador.apadrinhacao.services.animalService.BuscaAnimalByIdService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscaAnimalByIdServiceImpl implements BuscaAnimalByIdService {
    private final AnimalRepository animalRepository;

    @Override
    public AnimalModel findAnimalById(Integer id) {
        Optional<AnimalModel> model = animalRepository.findById(id);
        AnimalModel animalModel = validarAnimalModel(model);
        return animalModel;
    }

    private AnimalModel validarAnimalModel(Optional<AnimalModel> model) {
        if (model.isEmpty()){
            throw new NotFoundException("Animal não encontrado.");
        }
        return model.get();
    }
}
