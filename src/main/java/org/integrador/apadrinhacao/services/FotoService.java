package org.integrador.apadrinhacao.services;

import org.integrador.apadrinhacao.models.FotoModel;
import org.integrador.apadrinhacao.repositories.FotoRepository;
import org.integrador.apadrinhacao.validates.FotoValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FotoService {

    @Autowired
    private FotoRepository fotoRepository;

    @Autowired
    private FotoValidate fotoValidate;

    public FotoModel saveFoto(FotoModel fotoModel) {
        return fotoRepository.save(fotoModel);
    }

    public void deleteFotoById(Integer id)
    {
        Optional<FotoModel> model = fotoRepository.findById(id);
        FotoModel fotoModel = fotoValidate.validarFotoModel(model);
        fotoRepository.delete(fotoModel);
    }
}
