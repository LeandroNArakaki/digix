package com.br.service.impl;

import com.br.entities.Candidato;
import com.br.repositories.CandidatoRepository;
import com.br.service.CandidatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidatoServiceImpl implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Override
    public List<Candidato> listarCandidatos() {
        return candidatoRepository.findAll();
    }

    @Override
    public Optional<Candidato> buscarPorId(Long id) {
        return candidatoRepository.findById(id);
    }

    @Override
    public Optional<Candidato> salvarCandidato(Candidato candidato) {
        return Optional.of(candidatoRepository.save(candidato));
    }


    @Override
    public void deletarCandidato(Long id) {
        candidatoRepository.deleteById(id);
    }
}
