package org.integrador.apadrinhacao.controllers;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.integrador.apadrinhacao.services.PadrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/padrinho")
public class PadrinhoController {

    @Autowired
    private PadrinhoService padrinhoService;

    @GetMapping
    public List<PadrinhoModel> buscaPadrinho() {
        return padrinhoService.getAllPadrinho();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PadrinhoModel> buscaPadrinhoById(@PathVariable Integer id){
        try {
            PadrinhoModel padrinho = padrinhoService.findPadrinhoById(id);
            return ResponseEntity.ok(padrinho);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<PadrinhoModel> cadastrarPadrinho(@RequestBody PadrinhoModel padrinhoModel){
        try {
            PadrinhoModel padrinho = padrinhoService.savePadrinho(padrinhoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(padrinho);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<PadrinhoModel> alteraAnimal(@RequestBody PadrinhoModel padrinhoModel){
        try {
            PadrinhoModel padrinho = padrinhoService.updatePadrinho(padrinhoModel);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(padrinho);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagaPadrinhoById(@PathVariable Integer id)
    {
        try {
            padrinhoService.deletePadrinhoById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
