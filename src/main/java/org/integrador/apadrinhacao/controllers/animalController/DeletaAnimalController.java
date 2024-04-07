package org.integrador.apadrinhacao.controllers.animalController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.services.animalService.DeletaAnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/animal")
public class DeletaAnimalController {

    private final DeletaAnimalService deletaAnimalService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagaAnimalById(@PathVariable Integer id)
    {
        try {
            deletaAnimalService.deleteAnimalById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
