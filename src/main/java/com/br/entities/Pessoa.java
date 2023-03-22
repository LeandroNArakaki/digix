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
    @Column(name = "nome")
    private String nome;
    @Column(name = "idade")
    private Integer idade;
    @Column(name = "grauParentesco")
    @Enumerated(EnumType.STRING)
    private GrauParentesco grauParentesco;
    @Column(name = "dataNascimento")
    private LocalDateTime dataNascimento;

}

