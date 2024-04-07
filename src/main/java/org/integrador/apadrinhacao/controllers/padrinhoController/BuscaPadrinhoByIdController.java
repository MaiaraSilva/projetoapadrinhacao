package org.integrador.apadrinhacao.controllers.padrinhoController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.integrador.apadrinhacao.services.padrinhoService.BuscaPadrinhoByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/padrinho")
public class BuscaPadrinhoByIdController {

    private final BuscaPadrinhoByIdService buscaPadrinhoByIdService;

    @GetMapping("/{id}")
    public ResponseEntity<PadrinhoModel> buscaPadrinhoById(@PathVariable Integer id){
        try {
            PadrinhoModel padrinho = buscaPadrinhoByIdService.findPadrinhoById(id);
            return ResponseEntity.ok(padrinho);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
