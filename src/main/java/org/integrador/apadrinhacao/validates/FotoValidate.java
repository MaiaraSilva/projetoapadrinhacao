package org.integrador.apadrinhacao.validates;

import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.FotoModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FotoValidate {
    public FotoModel validarFotoModel(Optional<FotoModel> model) {
        if (model.isEmpty()){
            throw new NotFoundException("Foto não encontrada.");
        }
        return model.get();
    }
}
