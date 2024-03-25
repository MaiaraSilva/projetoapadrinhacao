package org.integrador.apadrinhacao.services.animaisService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.AnimaisModel;
import org.integrador.apadrinhacao.repositories.AnimaisRepository;
import org.integrador.apadrinhacao.services.AnimaisGetByIdService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimaisGetByIdServiceImpl implements AnimaisGetByIdService {

    private final AnimaisRepository animaisRepository;
    @Override
    public AnimaisModel findAnimaisById(Integer id) {
        return animaisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }
}
