package com.examen.dynamic.model;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "ResultadoOrdenarYCompletar", description = "Contiene la lista con los valores originales y con los valores ordenados")
@Builder
public class ResultadoOrdenarYCompletar {
    @Getter
    @Setter
    private List<Integer> valoresOriginales = new ArrayList<>();

    @Getter
    @Setter
    private List<Integer> valoresCompletosYOrdenados = new ArrayList<>();

}
