package org.integrador.apadrinhacao.services.animalService;

import org.integrador.apadrinhacao.models.AnimalModel;

public interface BuscaAnimalByIdService {
    AnimalModel findAnimalById(Integer id);
}
