package org.integrador.apadrinhacao.services.animalService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.AnimalModel;
import org.integrador.apadrinhacao.repositories.AnimalRepository;
import org.integrador.apadrinhacao.services.animalService.DeletaAnimalService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeletaAnimalServiceImpl implements DeletaAnimalService {

    private final AnimalRepository animalRepository;

    @Override
    public void deleteAnimalById(Integer id)
    {
        Optional<AnimalModel> model = animalRepository.findById(id);
        AnimalModel animalModel = validarAnimalModel(model);
        animalRepository.delete(animalModel);
    }

    private AnimalModel validarAnimalModel(Optional<AnimalModel> model) {
        if (model.isEmpty()){
            throw new NotFoundException("Animal não encontrado.");
        }
        return model.get();
    }
}
