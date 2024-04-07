package org.integrador.apadrinhacao.services.animaisService;

import org.integrador.apadrinhacao.models.AnimaisModel;
import org.springframework.stereotype.Service;

@Service
public interface AnimaisPutService {
    AnimaisModel updateAnimais(AnimaisModel animaisModel);
}
