package org.integrador.apadrinhacao.services;

import org.integrador.apadrinhacao.models.ApadrinhamentoModel;
import org.integrador.apadrinhacao.repositories.ApadrinhamentoRepository;
import org.integrador.apadrinhacao.validates.ApadrinhamentoValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApadrinhamentoService {

    @Autowired
    private ApadrinhamentoRepository apadrinhamentoRepository;

    @Autowired
    private ApadrinhamentoValidate apadrinhamentoValidate;

    public List<ApadrinhamentoModel> getAllApadrinhamento() {
        return apadrinhamentoRepository.findAll();
    }

    public ApadrinhamentoModel findApadrinhamentoById(Integer id) {
        Optional<ApadrinhamentoModel> model = apadrinhamentoRepository.findById(id);
        ApadrinhamentoModel apadrinhamentoModel = apadrinhamentoValidate.validarApadrinhamentoModel(model);
        return apadrinhamentoModel;
    }
    public ApadrinhamentoModel saveApadrinhamento(ApadrinhamentoModel apadrinhamentoModel) {
        ApadrinhamentoModel model= apadrinhamentoRepository.save(apadrinhamentoModel);
        return model;
    }
}
