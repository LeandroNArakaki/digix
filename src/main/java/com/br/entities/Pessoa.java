package com.br.entities;

import com.br.enums.GrauParentesco;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class Pessoa {
    @Column(name = "NOME")
    private String nome;
    @Column(name = "IDADE")
    private Integer idade;
    @Column(name = "GRAU_PARENTESCO")
    @Enumerated(EnumType.STRING)
    private GrauParentesco grauParentesco;
    @Column(name = "DATA_NASCIMENTO")
    private LocalDateTime dataNascimento;

}

