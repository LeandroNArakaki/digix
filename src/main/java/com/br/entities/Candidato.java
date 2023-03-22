package com.br.entities;

import com.br.enums.EstadoCivil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "CANDIDATOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidato extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CANDIDATO")
    private Long id;
    @Column(name = "NOME_MAE" )
    private String nomeMae;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "RENDA_FAMILIAR", precision = 12, scale = 2)
    private BigDecimal rendaFamiliar;
    @Column(name = "ESTADO_CIVIL")
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @OneToMany(mappedBy = "CANDIDATO")
    private List<Dependente> dependentes;




}
