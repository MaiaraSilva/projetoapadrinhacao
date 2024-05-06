package org.integrador.apadrinhacao.controllers;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.ApadrinhamentoModel;
import org.integrador.apadrinhacao.services.ApadrinhamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/apadrinhamento")
public class ApadrinhamentoController {

    @Autowired
    private ApadrinhamentoService apadrinhamentoService;

    @GetMapping
    public List<ApadrinhamentoModel> getAll(){
        List<ApadrinhamentoModel> apadrinhamento = apadrinhamentoService.getAllApadrinhamento();
        return apadrinhamento;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApadrinhamentoModel> buscaApadrinhamentobyId(@PathVariable Integer id){
        try {
            ApadrinhamentoModel apadrinhamento = apadrinhamentoService.findApadrinhamentoById(id);
            return ResponseEntity.ok(apadrinhamento);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<ApadrinhamentoModel> cadastrarApadrinhamento(@RequestBody ApadrinhamentoModel apadrinhamentoModel){
        try {
            ApadrinhamentoModel apadrinhamento = apadrinhamentoService.saveApadrinhamento(apadrinhamentoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(apadrinhamento);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getMessage());
        }
    }
}
