package org.integrador.apadrinhacao.controllers.animaisController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.services.AnimaisDeleteByIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/animais")
public class AnimaisDeleteByIdController {

    private final AnimaisDeleteByIdService animaisDeleteByIdService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagaAnimaisById(@PathVariable Integer id)
    {
        try {
            animaisDeleteByIdService.deleteAnimaisById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
