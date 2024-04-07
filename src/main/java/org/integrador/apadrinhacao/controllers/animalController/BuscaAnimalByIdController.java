package org.integrador.apadrinhacao.controllers.animalController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.AnimalModel;
import org.integrador.apadrinhacao.services.animalService.BuscaAnimalByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/animal")
public class BuscaAnimalByIdController {

    private final BuscaAnimalByIdService buscaAnimalByIdService;

    @GetMapping("/{id}")
    public ResponseEntity<AnimalModel> buscaAnimalbyId(@PathVariable Integer id){
        try {
            AnimalModel animal = buscaAnimalByIdService.findAnimalById(id);
            return ResponseEntity.ok(animal);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
