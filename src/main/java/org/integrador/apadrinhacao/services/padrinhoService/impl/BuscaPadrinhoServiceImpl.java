package org.integrador.apadrinhacao.services.padrinhoService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.integrador.apadrinhacao.repositories.PadrinhoRepository;
import org.integrador.apadrinhacao.services.padrinhoService.BuscaPadrinhoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuscaPadrinhoServiceImpl implements BuscaPadrinhoService {

    private final PadrinhoRepository padrinhoRepository;

    @Override
    public List<PadrinhoModel> getAllPadrinho() {
        return padrinhoRepository.findAll();
    }
}
