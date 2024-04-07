package org.integrador.apadrinhacao.services.padrinhoService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.integrador.apadrinhacao.repositories.PadrinhoRepository;
import org.integrador.apadrinhacao.services.padrinhoService.AlteraPadrinhoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlteraPadrinhoServiceImpl implements AlteraPadrinhoService {

    private final PadrinhoRepository padrinhoRepository;

    @Override
    public PadrinhoModel updatePadrinho(PadrinhoModel padrinhoModel) {
        Optional<PadrinhoModel> model= padrinhoRepository.findById(padrinhoModel.getId());

        if (model.isEmpty()) {
            throw new NotFoundException("Padrinho informado não encontrado.");
        }
        return padrinhoRepository.save(padrinhoModel);
    }
}
