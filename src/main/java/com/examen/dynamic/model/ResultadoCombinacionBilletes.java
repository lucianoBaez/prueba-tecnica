package com.examen.dynamic.model;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@ApiModel(value = "ResultadoCombinacionBilletes", description = "Muestra lista de combinaciones de billetes para el importe ingresado")
@Builder
public class ResultadoCombinacionBilletes {
    @Getter
    @Setter
    private Double montoIngresado;

    @Getter
    @Setter
    private List<List<Double>> combinacionBilletes ;
}
