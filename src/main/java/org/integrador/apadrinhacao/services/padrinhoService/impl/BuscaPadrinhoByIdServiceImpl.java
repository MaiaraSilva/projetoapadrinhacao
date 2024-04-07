package org.integrador.apadrinhacao.services.padrinhoService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.integrador.apadrinhacao.repositories.PadrinhoRepository;
import org.integrador.apadrinhacao.services.padrinhoService.BuscaPadrinhoByIdService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuscaPadrinhoByIdServiceImpl implements BuscaPadrinhoByIdService {

    private final PadrinhoRepository padrinhoRepository;

    @Override
    public PadrinhoModel findPadrinhoById(Integer id) {
        Optional<PadrinhoModel> model = padrinhoRepository.findById(id);
        PadrinhoModel padrinhoModel = validarPadrinhoModel(model);
        return padrinhoModel;
    }

    private PadrinhoModel validarPadrinhoModel(Optional<PadrinhoModel> model) {
        if (model.isEmpty()){
            throw new NotFoundException("Padrinho não encontrado.");
        }
        return model.get();
    }
}
