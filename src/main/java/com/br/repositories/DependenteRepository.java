package com.br.repositories;


import com.br.entities.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente,Long> {

    List<Dependente> listarDependentesPorCandidato(Long idCandidato);
}
