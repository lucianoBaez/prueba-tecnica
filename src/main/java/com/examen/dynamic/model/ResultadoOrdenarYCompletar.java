package com.examen.dynamic.model;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Contiene lista de objetos a ordenar", description = "Muestra la palabra ingresada y la palabra que resulta luego del intercambio de caracteres")
@Builder
public class ResultadoOrdenarYCompletar {
    @Getter
    @Setter
    private List<Integer> valoresOriginales = new ArrayList<>();

    @Getter
    @Setter
    private List<Integer> valoresCompletosYOrdenados = new ArrayList<>();

}
