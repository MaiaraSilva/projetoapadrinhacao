package org.integrador.apadrinhacao.controllers.animaisController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.AnimaisModel;
import org.integrador.apadrinhacao.services.AnimaisPutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/animais")
public class AnimaisPutController {

    private final AnimaisPutService animaisPutService;

    @PutMapping
    public ResponseEntity<AnimaisModel> alteraAtleta(@RequestBody AnimaisModel animaisModel){
        try {
            AnimaisModel animais = animaisPutService.updateAnimais(animaisModel);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(animais);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
