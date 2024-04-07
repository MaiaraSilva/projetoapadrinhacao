package org.integrador.apadrinhacao.services.animaisService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.models.AnimaisModel;
import org.integrador.apadrinhacao.repositories.AnimaisRepository;
import org.integrador.apadrinhacao.services.animaisService.AnimaisPostService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimaisPostServiceImpl implements AnimaisPostService {

    private final AnimaisRepository animaisRepository;
    @Override
    public AnimaisModel saveAnimais(AnimaisModel animais) {
        return animaisRepository.save(animais);
    }
}
