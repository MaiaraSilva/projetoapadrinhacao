package org.integrador.apadrinhacao.controllers.animaisController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.AnimaisModel;
import org.integrador.apadrinhacao.services.AnimaisGetByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/animais")
public class AnimaisGetByIdController {

    private final AnimaisGetByIdService animaisGetByIdService;

    @GetMapping("/{id}")
    public ResponseEntity<AnimaisModel> buscaAnimaisbyId(@PathVariable Integer id){
        try {
            AnimaisModel animais = animaisGetByIdService.findAnimaisById(id);
            return ResponseEntity.ok(animais);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
