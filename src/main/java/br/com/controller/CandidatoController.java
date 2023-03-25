package br.com.controller;

import br.com.entity.Candidato;
import br.com.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping("/candidato/listarCandidatos")
    public List<Candidato> listarCandidatos() {
        return candidatoService.listarCandidatos();
    }

    @PostMapping("/candidato/salvarCandidato")
    public ResponseEntity<?> salvarCandidato(@RequestBody Candidato candidato) {
        return new ResponseEntity<>(candidatoService.salvarCandidato(candidato), HttpStatus.OK);
    }

    @PutMapping("/candidato/alterarCandidato/{id}")
    public ResponseEntity<?> alterarCandidato(@PathVariable Long id, @RequestBody Candidato candidatoAlterado) {
        Optional<Candidato> candidato = candidatoService.buscarPorId(id);
        if (candidato.isPresent()) {
            candidatoService.salvarCandidato(candidato.get().construirCandidato(candidatoAlterado));
            return new ResponseEntity<>(candidatoAlterado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/candidato/deletarCandidato/{id}")
    public ResponseEntity<?> deletarCandidato(@PathVariable Long id) {
        candidatoService.deletarCandidato(id);
        return new ResponseEntity<>("Candidato deletado com sucessso!", HttpStatus.OK);
    }

    @GetMapping("/candidato/exibirCandidatosSorteados")
    public List<Candidato> exibirCandidatosSorteadosPorPontuacao(){
        return candidatoService.exibirCandidatosSorteadosPorPontuacao();
    }


}
