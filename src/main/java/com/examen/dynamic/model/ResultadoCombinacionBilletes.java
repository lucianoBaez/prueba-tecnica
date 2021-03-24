package com.examen.dynamic.model;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@ApiModel(value = "ResultadoCambioLetras", description = "Muestra la palabra ingresada y la palabra que resulta luego del intercambio de caracteres")
@Builder
public class ResultadoCombinacionBilletes {
    @Getter
    @Setter
    private Double montoIngresado;

    @Getter
    @Setter
    private List<List<Double>> combinacionBilletes ;
}
