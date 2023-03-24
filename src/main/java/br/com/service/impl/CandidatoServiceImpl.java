package br.com.service.impl;

import br.com.entities.Candidato;
import br.com.entities.Dependente;
import br.com.repositories.CandidatoRepository;
import br.com.service.CandidatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Override
    public Integer checarPontosPorRendaFamiliar(BigDecimal rendaFamiliar) {
        Integer pontuacao = 0;

        if (rendaFamiliar.compareTo(new BigDecimal(900)) <= 0) {
            pontuacao = +5;
        } else if (rendaFamiliar.compareTo(new BigDecimal(901)) >= 0) {
            pontuacao = +3;
        }

        return pontuacao;
    }

    @Override
    public Integer checarPontosPorDependente(List<Dependente> dependentes) {
        Integer pontuacao = 0;
        Long dependenteAptos = dependentes.stream().filter(dependente -> dependente.getIdade() > 18).count();

        if (dependenteAptos <= 2) {
            pontuacao = +2;
        } else if (dependenteAptos >= 3) {
            pontuacao = +3;
        }


        return pontuacao;
    }


}
