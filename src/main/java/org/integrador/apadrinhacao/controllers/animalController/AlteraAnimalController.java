package org.integrador.apadrinhacao.controllers.animalController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.AnimalModel;
import org.integrador.apadrinhacao.services.animalService.AlteraAnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/animal")
public class AlteraAnimalController {

    private final AlteraAnimalService alteraAnimalService;

    @PutMapping
    public ResponseEntity<AnimalModel> alteraAnimal(@RequestBody AnimalModel animalModel){
        try {
            AnimalModel animal = alteraAnimalService.updateAnimal(animalModel);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(animal);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
