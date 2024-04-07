package org.integrador.apadrinhacao.controllers.padrinhoController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.integrador.apadrinhacao.services.padrinhoService.CadastraPadrinhoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/padrinho")
public class CadastraPadrinhoController {

    private final CadastraPadrinhoService cadastraPadrinhoService;

    @PostMapping
    public ResponseEntity<PadrinhoModel> cadastrarPadrinho(@RequestBody PadrinhoModel padrinhoModel){
        try {
            PadrinhoModel padrinho = cadastraPadrinhoService.savePadrinho(padrinhoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(padrinho);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
