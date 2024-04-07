package org.integrador.apadrinhacao.services.padrinhoService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.integrador.apadrinhacao.repositories.PadrinhoRepository;
import org.integrador.apadrinhacao.services.padrinhoService.DeletaPadrinhoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeletaPadrinhoServiceImpl implements DeletaPadrinhoService {

    private final PadrinhoRepository padrinhoRepository;

    @Override
    public void deletePadrinhoById(Integer id)
    {
        Optional<PadrinhoModel> model = padrinhoRepository.findById(id);
        PadrinhoModel padrinhoModel = validarAnimalModel(model);
        padrinhoRepository.delete(padrinhoModel);
    }

    private PadrinhoModel validarAnimalModel(Optional<PadrinhoModel> model) {
        if (model.isEmpty()){
            throw new NotFoundException("Animal não encontrado.");
        }
        return model.get();
    }
}
