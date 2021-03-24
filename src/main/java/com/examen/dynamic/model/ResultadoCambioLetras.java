package com.examen.dynamic.model;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@ApiModel(value = "ResultadoCambioLetras", description = "Muestra la palabra ingresada y la palabra que resulta luego del intercambio de caracteres")
@Builder
public class ResultadoCambioLetras {
    @Getter
    @Setter
    private String palabraIngresada;

    @Getter
    @Setter
    private String palabraConvertida;
}
