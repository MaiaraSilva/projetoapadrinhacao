package org.integrador.apadrinhacao.services.animaisService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.AnimaisModel;
import org.integrador.apadrinhacao.repositories.AnimaisRepository;
import org.integrador.apadrinhacao.services.AnimaisPutService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimaisPutServiceImpl implements AnimaisPutService {
    private final AnimaisRepository animaisRepository;

    @Override
    public AnimaisModel updateAnimais(AnimaisModel animaisModel) {
        Optional<AnimaisModel> model= animaisRepository.findById(animaisModel.getId());

        if (model.isEmpty()) {
            throw new NotFoundException("Animal informado não encontrado");
        }
        return animaisRepository.save(animaisModel);
    }
}
