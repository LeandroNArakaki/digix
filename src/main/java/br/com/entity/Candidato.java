package br.com.entity;

import br.com.enums.EstadoCivil;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "CANDIDATOS")
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidato extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidato")
    private Long id;
    @Column(name = "nomeMae" )
    private String nomeMae;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rendaFamiliar", precision = 12, scale = 2)
    private BigDecimal rendaFamiliar;
    @Column(name = "estadoCivil")
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @OneToMany(mappedBy = "candidato")
    private List<Dependente> dependentes;

    @Column(name = "pontuacao")
    private Integer pontuacao;


    public Candidato construirCandidato(Candidato candidato) {
        return Candidato.builder()
                .id(candidato.getId())
                .nomeMae(candidato.getNomeMae())
                .cpf(candidato.getCpf())
                .rendaFamiliar(candidato.getRendaFamiliar())
                .estadoCivil(candidato.estadoCivil)
                .dependentes(candidato.getDependentes())
                .pontuacao(candidato.getPontuacao())
                .build();
    }

    public void setarPontuacao (Integer pontuacao){
        this.setPontuacao(pontuacao);
    }


}
