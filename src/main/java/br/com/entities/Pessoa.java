package br.com.entities;

import br.com.enums.GrauParentesco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

