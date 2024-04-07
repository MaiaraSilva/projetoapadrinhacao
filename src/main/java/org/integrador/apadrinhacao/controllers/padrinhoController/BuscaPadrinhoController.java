package org.integrador.apadrinhacao.controllers.padrinhoController;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.integrador.apadrinhacao.services.padrinhoService.BuscaPadrinhoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/padrinho")
public class BuscaPadrinhoController {

    private final BuscaPadrinhoService buscaPadrinhoService;

    @GetMapping
    public List<PadrinhoModel> buscaPadrinho() {
        return buscaPadrinhoService.getAllPadrinho();
    }
}

