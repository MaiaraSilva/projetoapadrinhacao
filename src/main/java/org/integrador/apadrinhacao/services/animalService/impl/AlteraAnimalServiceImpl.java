package org.integrador.apadrinhacao.services.animalService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.AnimalModel;
import org.integrador.apadrinhacao.repositories.AnimalRepository;
import org.integrador.apadrinhacao.services.animalService.AlteraAnimalService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlteraAnimalServiceImpl implements AlteraAnimalService {

    private final AnimalRepository animalRepository;

    @Override
    public AnimalModel updateAnimal(AnimalModel animalModel) {
        Optional<AnimalModel> model= animalRepository.findById(animalModel.getId());

        if (model.isEmpty()) {
            throw new NotFoundException("Animal informado não encontrado.");
        }
        return animalRepository.save(animalModel);
    }
}
