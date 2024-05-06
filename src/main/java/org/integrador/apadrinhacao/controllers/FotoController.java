package org.integrador.apadrinhacao.controllers;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.FotoModel;
import org.integrador.apadrinhacao.services.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/foto")
public class FotoController {

    @Autowired
    private FotoService fotoService;

    @PostMapping
    public ResponseEntity<FotoModel> cadastrarFoto(@RequestBody FotoModel fotoModel){
        try {
            FotoModel foto = fotoService.saveFoto(fotoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(foto);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagaFotoById(@PathVariable Integer id)
    {
        try {
            fotoService.deleteFotoById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
