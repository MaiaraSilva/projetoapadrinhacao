package org.integrador.apadrinhacao.repositories;

import org.integrador.apadrinhacao.models.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalModel, Integer> {
}
