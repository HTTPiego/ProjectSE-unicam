package it.unicam.cs.diciottoPolitico.casotto.repository;

import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleAttivita;
import it.unicam.cs.diciottoPolitico.casotto.entity.implementation.SimpleRigaCatologoAttivita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RigaCatalogoAttivitaRepository extends JpaRepository<SimpleRigaCatologoAttivita, UUID> {
}