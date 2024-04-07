package org.integrador.apadrinhacao.services.animalService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.AnimalModel;
import org.integrador.apadrinhacao.repositories.AnimalRepository;
import org.integrador.apadrinhacao.services.animalService.CadastraAnimalService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastraAnimalServiceImpl implements CadastraAnimalService {

    private final AnimalRepository animalRepository;
    @Override
    public AnimalModel saveAnimal(AnimalModel animalModel) {
        return animalRepository.save(animalModel);
    }
}
