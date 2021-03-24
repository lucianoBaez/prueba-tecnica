package com.examen.dynamic.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "EntradaOrdenarYCompletar", description = "Lista de valores a ordenar")
public class EntradaOrdenarYCompletar {
    @Getter
    @Setter
    private List<Integer> valores = new ArrayList<>();

}
