package com.br.service;

import com.br.entities.Dependente;

import java.util.List;
import java.util.Optional;

public interface DependenteService {

    List<Dependente> listarDependentesPorCandidato(Long idCandidato);

    Optional<Dependente> buscarPorId(Long id);

    Optional<Dependente> salvarDependente(Dependente dependente);

    void deletarDependente(Long id);

}
