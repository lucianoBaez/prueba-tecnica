package com.examen.dynamic.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/examen")
public class ExamenController {

    @GetMapping("/ordenarYRellenar")
    @ApiOperation(value = "Ordena y rellena con los numeros que faltan", response = String.class)
    public String OrdenarRellenar() {

	List<Integer> listaEnteros = new ArrayList();
	listaEnteros.add(100);
	listaEnteros.add(5);
	listaEnteros.add(6);
	listaEnteros.add(2);

	Integer max = listaEnteros
			.stream()
			.mapToInt(v -> v)
			.max().orElseThrow(NoSuchElementException::new);

	Integer[] listaOrdenadaYCompleta = new Integer[max];
	for(int i = 0; i < listaOrdenadaYCompleta.length; i++) {
		listaOrdenadaYCompleta[i] = i + 1;
	}

	System.out.println(listaOrdenadaYCompleta);
        return "pong: ";
    }

    @GetMapping("/cambiarLetras")
    @ApiOperation(value = "Reemplaza cada letra por la siguiente letra del abecedario, si es una Z, coloca una A", response = String.class)
    public String cambiarLetras() {

	String palabra = "pepe Z alfa z pepito125";
	StringBuilder palabraResultado = new StringBuilder();

	for (char caracter: palabra.toCharArray()) {
	    if (Character.isLetter(caracter)) {
	        int ascii = caracter;
		String caracterReemplazado = "";

		if (ascii != 122 && ascii != 90) { //122 = z, 90 = Z
		    caracterReemplazado = Character.toString((char) (ascii + 1));
		} else {
		    caracterReemplazado = Character.toString((char) (ascii - 25));
		}
		palabraResultado.append(caracterReemplazado);
	    } else {
	        palabraResultado.append(caracter);
	    }
	}
	return palabraResultado.toString();
    }

    @GetMapping("/combinarBilletes")
    @ApiOperation(value = "Retorna las combinaciones posibles de billetes", response = String.class)
    public String obtenerCombinacionesBilletes() {

	Double[] denominaciones = {0.20, 0.50, 1D, 2D, 5D, 10D, 20D, 50D, 100D, 200D};
	List<Double> denominacionesList = Arrays.asList(denominaciones);
	Double importe = 1.5D;
	List billetes = new ArrayList();
	Map<String, List<Double>> combinacionesSinRepetirse  = new HashMap<>();

	combinarBilletes(importe, denominacionesList, billetes, 0D, combinacionesSinRepetirse);
	combinacionesSinRepetirse.forEach((k,v) -> System.out.println("key" + k + ": value: " + v));
	return "pong";
    }

    private void combinarBilletes(Double importe, List<Double> denominaciones, List<Double> billetes, Double suma, Map<String, List<Double>> combinacionesSinRepetirse) {
        if(Double.compare(importe, suma) == 0 ) {
            billetes.sort((b1,b2) -> b1.compareTo(b2));
            if(!combinacionesSinRepetirse.containsKey(billetes.toString())) {
		combinacionesSinRepetirse.put(billetes.toString(), billetes.stream().collect(Collectors.toList()));
	    }
            System.out.println(billetes);
	} else {
            for (int i = 0; i < denominaciones.size(); i++) {
                suma += denominaciones.get(i);
                if (Double.compare(suma, importe) <= 0) {
                    billetes.add(denominaciones.get(i));
                    combinarBilletes(importe, denominaciones, billetes, suma, combinacionesSinRepetirse);
                    billetes.remove(billetes.indexOf(denominaciones.get(i)));
		}
		suma -= denominaciones.get(i);
	    }
	}
    }
}
