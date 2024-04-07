package org.integrador.apadrinhacao.services.padrinhoService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.integrador.apadrinhacao.repositories.PadrinhoRepository;
import org.integrador.apadrinhacao.services.padrinhoService.CadastraPadrinhoService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastraPadrinhoServiceImpl implements CadastraPadrinhoService {

    private final PadrinhoRepository padrinhoRepository;
    @Override
    public PadrinhoModel savePadrinho(PadrinhoModel padrinhoModel) {
        return padrinhoRepository.save(padrinhoModel);
    }
}
