package org.integrador.apadrinhacao.validates;

import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.ApadrinhamentoModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ApadrinhamentoValidate {

    public ApadrinhamentoModel validarApadrinhamentoModel(Optional<ApadrinhamentoModel> model) {
        if (model.isEmpty()){
            throw new NotFoundException("Relação de apadrinhamento não encontrada.");
        }
        return model.get();
    }
}
