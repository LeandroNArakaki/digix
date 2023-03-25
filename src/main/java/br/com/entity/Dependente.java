package br.com.entity;

import br.com.enums.GrauParentesco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "DEPENDENTES")
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dependente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dependente")
    private Long id;

    @Column(name = "grauParentesco")
    @Enumerated(EnumType.STRING)
    private GrauParentesco grauParentesco;

    @ManyToOne
    @JoinColumn(name = "id_candidato", nullable = false)
    private Candidato candidato;


    public Dependente construirDependente(Dependente dependente) {
        return Dependente.builder()
                .id(dependente.getId())
                .grauParentesco(dependente.getGrauParentesco())
                .candidato(dependente.getCandidato())
                .build();
    }

}
