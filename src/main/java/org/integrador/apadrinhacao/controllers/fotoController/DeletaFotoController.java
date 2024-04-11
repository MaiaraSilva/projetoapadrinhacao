package org.integrador.apadrinhacao.controllers.fotoController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.services.fotoService.DeletaFotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/foto")
public class DeletaFotoController {

    private final DeletaFotoService deletaFotoService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagaFotoById(@PathVariable Integer id)
    {
        try {
            deletaFotoService.deleteFotoById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
