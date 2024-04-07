package org.integrador.apadrinhacao.services.animalService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.AnimalModel;
import org.integrador.apadrinhacao.repositories.AnimalRepository;
import org.integrador.apadrinhacao.services.animalService.BuscaAnimalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscaAnimalServiceImpl implements BuscaAnimalService {

    private final AnimalRepository animalRepository;

    @Override
    public List<AnimalModel> getAllAnimal() {
        return animalRepository.findAll();
    }
}
