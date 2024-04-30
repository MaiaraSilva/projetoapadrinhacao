package org.integrador.apadrinhacao.repositories;

import org.integrador.apadrinhacao.models.FotoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<FotoModel, Integer> {
}
