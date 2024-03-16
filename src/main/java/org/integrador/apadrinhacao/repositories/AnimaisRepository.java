package org.integrador.apadrinhacao.repositories;

import org.integrador.apadrinhacao.models.AnimaisModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimaisRepository extends JpaRepository<AnimaisModel, Integer> {
}
