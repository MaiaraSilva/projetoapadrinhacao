package org.integrador.apadrinhacao.controllers.animalController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.AnimalModel;
import org.integrador.apadrinhacao.services.animalService.CadastraAnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/animal")
public class CadastraAnimalController {

    private final CadastraAnimalService cadastraAnimalService;

    @PostMapping
    public ResponseEntity<AnimalModel> cadastrarAnimal(@RequestBody AnimalModel animalModel){
        try {
            AnimalModel animal = cadastraAnimalService.saveAnimal(animalModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(animal);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
