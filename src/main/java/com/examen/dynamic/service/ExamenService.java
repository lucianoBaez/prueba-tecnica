package com.examen.dynamic.service;

import java.util.List;

public interface ExamenService {

    /**
     * Recibe lista de valores enteros y devuelve una lista con valores que van desde el 1 al valor maximo recibido
     * @param valores
     * @return
     */
    List ordenarRellenar(List<Integer> valores);

    /**
     * Cambia cada una de las letas por la siguiente en el abecedario, si es una Z o z , se cambiaran por A y a correspondientemente
     * @param palabra
     * @return
     */
    String cambiarLetras(String palabra);

    /**
     * Recibe un importe, y devuelve una lista con las posibles combinaciones de denominaciones de dinero para obtener dicho importe
     * @param importe
     * @return
     */
    List<List<Double>> obtenerCombinacionesBilletes(Double importe);
}
