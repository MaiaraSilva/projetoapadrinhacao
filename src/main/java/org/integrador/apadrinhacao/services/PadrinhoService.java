package org.integrador.apadrinhacao.services;

import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.integrador.apadrinhacao.repositories.PadrinhoRepository;
import org.integrador.apadrinhacao.validates.PadrinhoValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PadrinhoService {

    @Autowired
    private PadrinhoRepository padrinhoRepository;

    @Autowired
    private PadrinhoValidate padrinhoValidate;

    public List<PadrinhoModel> getAllPadrinho() {
        return padrinhoRepository.findAll();
    }

    public PadrinhoModel findPadrinhoById(Integer id) {
        Optional<PadrinhoModel> model = padrinhoRepository.findById(id);
        PadrinhoModel padrinhoModel = padrinhoValidate.validarPadrinhoModel(model);
        return padrinhoModel;
    }

    public PadrinhoModel savePadrinho(PadrinhoModel padrinhoModel) {
        return padrinhoRepository.save(padrinhoModel);
    }

    public PadrinhoModel updatePadrinho(PadrinhoModel padrinhoModel) {
        Optional<PadrinhoModel> model= padrinhoRepository.findById(padrinhoModel.getId());

        if (model.isEmpty()) {
            throw new NotFoundException("Padrinho informado não encontrado.");
        }
        return padrinhoRepository.save(padrinhoModel);
    }

    public void deletePadrinhoById(Integer id)
    {
        Optional<PadrinhoModel> model = padrinhoRepository.findById(id);
        PadrinhoModel padrinhoModel = padrinhoValidate.validarPadrinhoModel(model);
        padrinhoRepository.delete(padrinhoModel);
    }
}
