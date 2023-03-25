package br.com.controller;

import br.com.entity.Dependente;
import br.com.service.CandidatoService;
import br.com.service.DependenteService;
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
@RequestMapping("/api/dependente")
public class DependenteController {
    @Autowired
    private DependenteService dependenteService;
    @Autowired
    private CandidatoService candidatoService;


    @GetMapping("/listaDependentesPorCandidato/{id}")
    public List<Dependente> listarDependentesPorCandidato(@PathVariable Long idCandidato) {
        return dependenteService.listarDependentesPorCandidato(idCandidato);
    }

    @PostMapping("/salvarDependente")
    public ResponseEntity<?> salvarDependente(@RequestBody Dependente dependente) {
        return new ResponseEntity<>(Optional.of(dependenteService.salvarDependente(dependente)), HttpStatus.OK);
    }

    @PutMapping("/alterarDependente/{id}")
    public ResponseEntity<?> alterarDependente(@PathVariable Long id, @RequestBody Dependente dependenteAlterado) {
        Optional<Dependente> dependente = dependenteService.buscarPorId(id);
        if (dependente.isPresent()) {
            dependenteService.salvarDependente(dependente.get().construirDependente(dependenteAlterado));
            return new ResponseEntity<>(dependenteAlterado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/deletarDependente/{id}")
    public ResponseEntity<?> deletarDependente(@PathVariable Long id) {
        dependenteService.deletarDependente(id);
        return new ResponseEntity<>("Dependente deletado com sucessso!", HttpStatus.OK);
    }

}
