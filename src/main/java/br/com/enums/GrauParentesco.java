package br.com.enums;

import lombok.Getter;

@Getter
public enum GrauParentesco {

    AVÓ("avó"),
    AVÔ("avô"),
    FILHO("filho"),
    FILHA("filha"),
    IRMÃO("irmão"),
    IRMÃ("irmã"),
    ENTEADO("enteado"),
    SOBRINHO("sobrinho"),
    NETO("neto"),
    PAI("pai"),
    MÃE("mãe"),
    TIO("tio"),
    TIA("tia");


    private String grauParentesco;

    GrauParentesco(String grauParentesco) {
        this.grauParentesco = grauParentesco;
    }
}
