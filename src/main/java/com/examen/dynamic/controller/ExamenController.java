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
import org.springframework.beans.factory.annotation.Autowired;
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
public class ExamenController {

    @Autowired
    @Setter
    @Getter
    private ExamenService examenService;


    @PostMapping("/ordenarYRellenar")
    @ApiOperation(value = "Ordena y rellena con los numeros que faltan", response = String.class)
    public ResponseEntity<ResultadoOrdenarYCompletar> ordenarRellenar(@RequestBody EntradaOrdenarYCompletar request) {
	List listaOrdenadaYCompleta = getExamenService().ordenarRellenar(request.getValores());
	ResultadoOrdenarYCompletar resultado = ResultadoOrdenarYCompletar.builder().valoresOriginales(request.getValores()).valoresCompletosYOrdenados(listaOrdenadaYCompleta).build();
	return ResponseEntity.ok().body(resultado);
    }

    @GetMapping("/cambiarLetras/{palabra}")
    @ApiOperation(value = "Reemplaza cada letra por la siguiente letra del abecedario, si es una Z, coloca una A", response = String.class)
    public ResponseEntity<ResultadoCambioLetras> cambiarLetras( @ApiParam(value = "Palabra", required = true, example = "Dynamic Devs") @PathVariable("palabra") String palabra) {
	String palabraResultado = getExamenService().cambiarLetras(palabra);
	ResultadoCambioLetras resultado = ResultadoCambioLetras.builder().palabraIngresada(palabra).palabraConvertida(palabraResultado).build();
	return ResponseEntity.ok().body(resultado);
    }

    @GetMapping("/combinarBilletes/{importe}")
    @ApiOperation(value = "Retorna las combinaciones posibles de billetes", response = String.class)
    public ResponseEntity<ResultadoCombinacionBilletes> obtenerCombinacionesBilletes( @ApiParam(value = "Importe", required = true, example = "1") @PathVariable("importe") Double importe) {
	List<List<Double>> combinacionesList = getExamenService().obtenerCombinacionesBilletes(importe);
	ResultadoCombinacionBilletes resultado = ResultadoCombinacionBilletes.builder().montoIngresado(importe)
			.combinacionBilletes(combinacionesList).build();
	return ResponseEntity.ok().body(resultado);
    }
}
