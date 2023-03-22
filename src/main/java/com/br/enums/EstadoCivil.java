package com.br.enums;

import lombok.Getter;

@Getter
public enum EstadoCivil {

    SOLTEIRO("solteiro"),
    CASADO("casado"),
    VIUVO("viuvo"),
    DIVORCIADO("divorciado"),
    SEPARADO("separado");


    private String estadoCivil;

    EstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

}
