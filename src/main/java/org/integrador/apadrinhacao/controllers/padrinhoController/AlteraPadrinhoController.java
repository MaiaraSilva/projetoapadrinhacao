package org.integrador.apadrinhacao.controllers.padrinhoController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.integrador.apadrinhacao.services.padrinhoService.AlteraPadrinhoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/padrinho")
public class AlteraPadrinhoController {

    private final AlteraPadrinhoService alteraPadrinhoService;

    @PutMapping
    public ResponseEntity<PadrinhoModel> alteraAnimal(@RequestBody PadrinhoModel padrinhoModel){
        try {
            PadrinhoModel padrinho = alteraPadrinhoService.updatePadrinho(padrinhoModel);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(padrinho);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
