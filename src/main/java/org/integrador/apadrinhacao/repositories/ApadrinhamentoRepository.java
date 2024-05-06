package org.integrador.apadrinhacao.repositories;

import org.integrador.apadrinhacao.models.ApadrinhamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApadrinhamentoRepository extends JpaRepository<ApadrinhamentoModel, Integer> {
}
