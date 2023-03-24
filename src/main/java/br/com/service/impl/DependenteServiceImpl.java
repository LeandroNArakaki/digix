package br.com.service.impl;

import br.com.entities.Dependente;
import br.com.repositories.DependenteRepository;
import br.com.service.DependenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DependenteServiceImpl implements DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    @Override
    public List<Dependente> listarDependentesPorCandidato(Long idCandidato) {
        return dependenteRepository.listarDependentesPorCandidato(idCandidato);
    }

    @Override
    public Optional<Dependente> buscarPorId(Long id) {
        return dependenteRepository.findById(id);
    }

    @Override
    public Optional<Dependente> salvarDependente(Dependente dependente) {
        return Optional.of(dependenteRepository.save(dependente));
    }

    @Override
    public void deletarDependente(Long id) {
        dependenteRepository.deleteById(id);
    }
}
