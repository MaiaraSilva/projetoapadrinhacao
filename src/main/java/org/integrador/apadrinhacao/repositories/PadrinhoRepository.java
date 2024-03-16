package org.integrador.apadrinhacao.repositories;

import org.integrador.apadrinhacao.models.PadrinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PadrinhoRepository extends JpaRepository<PadrinhoModel, Integer> {
}
