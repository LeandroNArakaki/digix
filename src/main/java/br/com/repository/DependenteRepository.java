package br.com.repository;


import br.com.entity.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente,Long> {

    //List<Dependente> listarDependentesPorCandidato(Long idCandidato);
}
