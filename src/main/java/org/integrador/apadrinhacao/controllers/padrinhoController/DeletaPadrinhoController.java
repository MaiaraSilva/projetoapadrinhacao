package org.integrador.apadrinhacao.controllers.padrinhoController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.services.padrinhoService.DeletaPadrinhoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/padrinho")
public class DeletaPadrinhoController {

    private final DeletaPadrinhoService deletaPadrinhoService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagaPadrinhoById(@PathVariable Integer id)
    {
        try {
            deletaPadrinhoService.deletePadrinhoById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
