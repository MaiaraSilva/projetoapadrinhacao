package org.integrador.apadrinhacao.services;

import org.integrador.apadrinhacao.models.AnimaisModel;
import org.springframework.stereotype.Service;

@Service
public interface AnimaisPostService {
    AnimaisModel saveAnimais(AnimaisModel animais);
}
