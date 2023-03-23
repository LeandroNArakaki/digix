package com.br.service;

import com.br.entities.Candidato;

import java.util.List;
import java.util.Optional;

public interface CandidatoService {
    List<Candidato> listarCandidatos();

    Optional<Candidato> buscarPorId(Long id);

    Optional<Candidato> salvarCandidato(Candidato candidato);

    void deletarCandidato(Long id);
}
