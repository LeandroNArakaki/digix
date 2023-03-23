package com.br.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "DEPENDENTES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dependente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dependente")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_candidato", nullable = false)
    private Candidato candidato;


    public Dependente construirDependente(Dependente dependente) {
        return Dependente.builder()
                .id(dependente.getId())
                .candidato(dependente.getCandidato())
                .build();
    }

}
