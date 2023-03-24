package br.com.service;

import br.com.entities.Candidato;
import br.com.entities.Dependente;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CandidatoService {
    List<Candidato> listarCandidatos();

    Optional<Candidato> buscarPorId(Long id);

    Optional<Candidato> salvarCandidato(Candidato candidato);

    void deletarCandidato(Long id);

    Integer checarPontosPorRendaFamiliar(BigDecimal rendaFamiliar);

    Integer checarPontosPorDependente(List<Dependente> dependetes);
}
