package org.integrador.apadrinhacao.services.fotoService.impl;

import lombok.RequiredArgsConstructor;
import org.integrador.apadrinhacao.exceptions.NotFoundException;
import org.integrador.apadrinhacao.models.FotoModel;
import org.integrador.apadrinhacao.repositories.FotoRepository;
import org.integrador.apadrinhacao.services.fotoService.DeletaFotoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeletaFotoServiceImpl implements DeletaFotoService {

    private final FotoRepository fotoRepository;

    @Override
    public void deleteFotoById(Integer id)
    {
        Optional<FotoModel> model = fotoRepository.findById(id);
        FotoModel fotoModel = validarFotoModel(model);
        fotoRepository.delete(fotoModel);
    }

    private FotoModel validarFotoModel(Optional<FotoModel> model) {
        if (model.isEmpty()){
            throw new NotFoundException("Foto não encontrada.");
        }
        return model.get();
    }
}
