package com.examen.dynamic.service.impl;

import com.examen.dynamic.service.ExamenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExamenServiceImpl implements ExamenService {

    private final List<Double> DENOMINACIONES = Arrays.asList(0.20, 0.50, 1D, 2D, 5D, 10D, 20D, 50D, 100D, 200D);

    @Override
    public List ordenarRellenar(List<Integer> valores) {
	log.info("Lista desordenada: {}", valores.toString());

	Integer max = valores.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
	log.info("Valor maximo obtenido del conjunto de valores ingresados: {}", max);
	List listaOrdenadaYCompleta = new ArrayList();
	for (int i = 0; i < max; i++) {
	    listaOrdenadaYCompleta.add(i + 1);
	}

	log.info("Lista ordenada: {}", listaOrdenadaYCompleta.toString());
	return listaOrdenadaYCompleta;
    }

    @Override
    public String cambiarLetras(String palabra) {
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

    @Override
    public List<List<Double>> obtenerCombinacionesBilletes(Double importe) {

	log.info("Importe recibido: {}", importe);
	List billetes = new ArrayList();
	Map<String, List<Double>> combinacionesSinRepetirse  = new HashMap<>();

	combinarBilletes(importe, DENOMINACIONES, billetes, 0D, combinacionesSinRepetirse);
	List<List<Double>> combinacionesList = new ArrayList<>();
	combinacionesSinRepetirse.forEach((k,v) -> combinacionesList.add(v));

	log.info("Combinacion de billetes para el importe recibido: {}", combinacionesList.toString());
	return combinacionesList;
    }

    private void combinarBilletes(Double importe, List<Double> denominaciones, List<Double> billetes, Double suma, Map<String, List<Double>> combinacionesSinRepetirse) {
	if(Double.compare(importe, suma) == 0 ) {
	    billetes.sort((b1,b2) -> b1.compareTo(b2));
	    if(!combinacionesSinRepetirse.containsKey(billetes.toString())) {
		combinacionesSinRepetirse.put(billetes.toString(), billetes.stream().collect(Collectors.toList()));
	    }
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
