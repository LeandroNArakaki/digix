package br.com.service.impl;

import br.com.entity.Candidato;
import br.com.entity.Dependente;
import br.com.repository.CandidatoRepository;
import br.com.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
            pontuacao += 5;
        } else if (rendaFamiliar.compareTo(new BigDecimal(901)) >= 0) {
            pontuacao += 3;
        }

        return pontuacao;
    }

    @Override
    public Integer checarPontosPorDependente(List<Dependente> dependentes) {
        Integer pontuacao = 0;
        Long dependenteAptos = dependentes.stream().filter(dependente -> dependente.getIdade() > 18).count();

        if (dependenteAptos <= 2) {
            pontuacao += 2;
        } else if (dependenteAptos >= 3) {
            pontuacao += 3;
        }


        return pontuacao;
    }

    @Override
    public List<Candidato> exibirCandidatosSorteadosPorPontuacao() {
        List<Candidato> candidatos = incluirPontuacaoCandidatos();


        List<Candidato> candidatosOrdenados = candidatos.stream()
                .sorted(Comparator.comparingInt(Candidato::getPontuacao).reversed())
                .collect(Collectors.toList());


        return candidatosOrdenados;
    }

    private List<Candidato> incluirPontuacaoCandidatos() {
        List<Candidato> candidatos = candidatoRepository.findAll();
        Integer pontuacao = 0;

        if (Objects.nonNull(candidatos)) {

            for (Candidato candidato : candidatos) {
                pontuacao += checarPontosPorRendaFamiliar(candidato.getRendaFamiliar());
                pontuacao += checarPontosPorDependente(candidato.getDependentes());

                candidato.setarPontuacao(pontuacao);
            }
        }

        return candidatos;
    }


}
