package org.integrador.apadrinhacao.controllers;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.DTO.AnimalDTO;
import org.integrador.apadrinhacao.models.AnimalModel;
import org.integrador.apadrinhacao.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<AnimalModel> buscaAnimal() {
        return animalService.getAllAnimal();
    }

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAllAnimals() {
        List<AnimalDTO> animalDTOs = animalService.getAllAnimals();
        return ResponseEntity.ok(animalDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalModel> buscaAnimalbyId(@PathVariable Integer id){
        try {
            AnimalModel animal = animalService.findAnimalById(id);
            return ResponseEntity.ok(animal);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<AnimalModel> alteraAnimal(@RequestBody AnimalModel animalModel){
        try {
            AnimalModel animal = animalService.updateAnimal(animalModel);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(animal);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagaAnimalById(@PathVariable Integer id)
    {
        try {
            animalService.deleteAnimalById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
