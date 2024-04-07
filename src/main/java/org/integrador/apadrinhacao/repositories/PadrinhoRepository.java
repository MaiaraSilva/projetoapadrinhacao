package org.integrador.apadrinhacao.repositories;

import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PadrinhoRepository extends JpaRepository<PadrinhoModel, Integer> {
}
