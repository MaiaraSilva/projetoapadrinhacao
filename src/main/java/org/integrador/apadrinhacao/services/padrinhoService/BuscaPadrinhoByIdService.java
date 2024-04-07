package org.integrador.apadrinhacao.services.padrinhoService;

import org.integrador.apadrinhacao.models.PadrinhoModel;

public interface BuscaPadrinhoByIdService {
    PadrinhoModel findPadrinhoById(Integer id);
}
