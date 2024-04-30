package org.integrador.apadrinhacao.validates;

import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PadrinhoValidate {

    public PadrinhoModel validarPadrinhoModel(Optional<PadrinhoModel> model) {
        if (model.isEmpty()){
            throw new NotFoundException("Animal não encontrado.");
        }
        return model.get();
    }
}
