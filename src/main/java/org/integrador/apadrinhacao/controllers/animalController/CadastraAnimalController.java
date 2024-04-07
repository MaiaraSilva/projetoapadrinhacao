package org.integrador.apadrinhacao.controllers.animaisController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.AnimaisModel;
import org.integrador.apadrinhacao.services.animaisService.AnimaisPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/animais")
public class AnimaisPostController {

    private final AnimaisPostService animaisPostService;
    @PostMapping
    public ResponseEntity<AnimaisModel> cadastraAnimais(@RequestBody AnimaisModel animaisModel){
        try {
            AnimaisModel animais = animaisPostService.saveAnimais(animaisModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(animais);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
