package com.examen.dynamic.controller;

import com.examen.dynamic.model.EntradaOrdenarYCompletar;
import com.examen.dynamic.model.ResultadoCambioLetras;
import com.examen.dynamic.model.ResultadoCombinacionBilletes;
import com.examen.dynamic.model.ResultadoOrdenarYCompletar;
import com.examen.dynamic.service.ExamenService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/examen")
@Slf4j
public class ExamenController {

    @Autowired
    @Setter
    @Getter
    private ExamenService examenService;


    @PostMapping("/ordenarYRellenar")
    @ApiOperation(value = "Ordena y rellena con los numeros que faltan", response = String.class)
    public ResponseEntity<ResultadoOrdenarYCompletar> ordenarRellenar(@RequestBody EntradaOrdenarYCompletar request) {
        log.info("Iniciando procesode ordenar y rellenar arreglo");

        if (request.getValores() != null && request.getValores().size() > 0) {
	    List listaOrdenadaYCompleta = getExamenService().ordenarRellenar(request.getValores());
	    ResultadoOrdenarYCompletar resultado = ResultadoOrdenarYCompletar.builder().valoresOriginales(request.getValores()).valoresCompletosYOrdenados(listaOrdenadaYCompleta).build();
	    return ResponseEntity.ok().body(resultado);
	} else {
	    log.info("El arreglo esta nulo o vacio");
            return ResponseEntity.badRequest().body(null);
	}
    }

    @GetMapping("/cambiarLetras/{palabra}")
    @ApiOperation(value = "Reemplaza cada letra por la siguiente letra del abecedario, si es una Z, coloca una A", response = String.class)
    public ResponseEntity<ResultadoCambioLetras> cambiarLetras( @ApiParam(value = "Palabra", required = true, example = "Dynamic Devs") @PathVariable("palabra") String palabra) {

        if (palabra != null && !palabra.trim().equals("")) {
	    log.info("Cambiando letras de la palabra {}", palabra);
	    String palabraResultado = getExamenService().cambiarLetras(palabra);

	    log.info("El resultado obtenido fue {}", palabraResultado);
	    ResultadoCambioLetras resultado = ResultadoCambioLetras.builder().palabraIngresada(palabra).palabraConvertida(palabraResultado).build();
	    return ResponseEntity.ok().body(resultado);
 	} else {
	    return ResponseEntity.badRequest().body(null);
	}

    }

    @GetMapping("/combinarBilletes/{importe}")
    @ApiOperation(value = "Retorna las combinaciones posibles de billetes", response = String.class)
    public ResponseEntity<ResultadoCombinacionBilletes> obtenerCombinacionesBilletes( @ApiParam(value = "Importe", required = true, example = "1") @PathVariable("importe") Double importe) {

       	if(importe != null && importe.compareTo(0D) > 0) {
	    log.info("Generando combinaciones de billetes para el {} soles", importe);
	    List<List<Double>> combinacionesList = getExamenService().obtenerCombinacionesBilletes(importe);
	    ResultadoCombinacionBilletes resultado = ResultadoCombinacionBilletes.builder().montoIngresado(importe)
			    .combinacionBilletes(combinacionesList).build();
	    return ResponseEntity.ok().body(resultado);
	} else {
	    log.info("El importe es nulo o invaĺido", importe);
	    return ResponseEntity.badRequest().body(null);
	}
    }
}
