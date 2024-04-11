package org.integrador.apadrinhacao.controllers.fotoController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.FotoModel;
import org.integrador.apadrinhacao.services.fotoService.CadastraFotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/foto")
public class CadastraFotoController {

    private final CadastraFotoService cadastraFotoService;

    @PostMapping
    public ResponseEntity<FotoModel> cadastrarFoto(@RequestBody FotoModel fotoModel){
        try {
            FotoModel foto = cadastraFotoService.saveFoto(fotoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(foto);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
