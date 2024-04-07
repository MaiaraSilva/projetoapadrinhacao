package org.integrador.apadrinhacao.services.animaisService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.AnimaisModel;
import org.integrador.apadrinhacao.repositories.AnimaisRepository;
import org.integrador.apadrinhacao.services.animaisService.AnimaisDeleteByIdService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimaisDeleteByIdServiceImpl implements AnimaisDeleteByIdService {
    private final AnimaisRepository animaisRepository;

    @Override
    public void deleteAnimaisById(Integer id)
    {
        Optional<AnimaisModel> model = animaisRepository.findById(id);
        AnimaisModel animaisModel = validarAnimaisModel(model);
        animaisRepository.delete(animaisModel);
    }

    private AnimaisModel validarAnimaisModel(Optional<AnimaisModel> model) {
        if (model.isEmpty()){
            throw new NotFoundException("Animal não encontrado.");
        }
        return model.get();
    }
}
