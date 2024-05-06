package org.integrador.apadrinhacao.services;

import org.integrador.apadrinhacao.DTO.AnimalDTO;
import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.AnimalModel;
import org.integrador.apadrinhacao.repositories.AnimalRepository;
import org.integrador.apadrinhacao.validates.AnimalValidate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AnimalValidate animalValidate;

    @Autowired
    private ModelMapper modelMapper;

    public AnimalModel updateAnimal(AnimalModel animalModel) {
        Optional<AnimalModel> model= animalRepository.findById(animalModel.getId());

        if (model.isEmpty()) {
            throw new NotFoundException("Animal informado não encontrado.");
        }
        return animalRepository.save(animalModel);
    }

    public AnimalModel findAnimalById(Integer id) {
        Optional<AnimalModel> model = animalRepository.findById(id);
        AnimalModel animalModel = animalValidate.validarAnimalModel(model);
        return animalModel;
    }

    public List<AnimalModel> getAllAnimal() {
        return animalRepository.findAll();
    }

    public AnimalModel saveAnimal(AnimalModel animalModel) {
        return animalRepository.save(animalModel);
    }

    public void deleteAnimalById(Integer id)
    {
        Optional<AnimalModel> model = animalRepository.findById(id);
        AnimalModel animalModel = animalValidate.validarAnimalModel(model);
        animalRepository.delete(animalModel);
    }

    public List<AnimalDTO> getAllAnimals() {
        List<AnimalModel> animalModels = animalRepository.findAll();

        List<AnimalDTO> animalDTOs = animalModels.stream()
                .map(animalModel -> modelMapper.map(animalModel, AnimalDTO.class))
                .collect(Collectors.toList());
        return animalDTOs;
    }
}
