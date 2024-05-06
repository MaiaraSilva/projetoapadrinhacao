package org.integrador.apadrinhacao.validates;

import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.AnimalModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AnimalValidate {
    public AnimalModel validarAnimalModel(Optional<AnimalModel> model) {
        if (model.isEmpty()){
            throw new NotFoundException("Animal não encontrado.");
        }
            return model.get();
    }
}
