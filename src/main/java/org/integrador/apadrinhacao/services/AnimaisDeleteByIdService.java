package org.integrador.apadrinhacao.services;

import org.springframework.stereotype.Service;

@Service
public interface AnimaisDeleteByIdService {

    void deleteAnimaisById(Integer id);
}
