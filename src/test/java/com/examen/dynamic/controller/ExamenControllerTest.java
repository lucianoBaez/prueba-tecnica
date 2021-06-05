package com.examen.dynamic.controller;


import com.examen.dynamic.model.EntradaOrdenarYCompletar;
import com.examen.dynamic.model.ResultadoCambioLetras;
import com.examen.dynamic.model.ResultadoCombinacionBilletes;
import com.examen.dynamic.model.ResultadoOrdenarYCompletar;
import com.examen.dynamic.service.ExamenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//Probando con baby
@RunWith(MockitoJUnitRunner.class)
public class ExamenControllerTest {

    @InjectMocks
    private ExamenController controller;

    @Mock
    private ExamenService service;

    @Test
    public void test_cambiar_letras_ok() {
        when(service.cambiarLetras("123 abcd*3")).thenReturn("“123 bcde*3");
	ResponseEntity<ResultadoCambioLetras> result = controller
			.cambiarLetras("123 abcd*3");
	assertThat(result).isNotNull();
	assertThat(result.getStatusCode().value()).isEqualTo(200);
	assertThat(result.getBody()).isNotNull();
    }

    @Test
    public void test_cambiar_letras_null() {

	ResponseEntity<ResultadoCambioLetras> result = controller
			.cambiarLetras(null);
	assertThat(result).isNotNull();
	assertThat(result.getStatusCode().value()).isEqualTo(400);
	assertThat(result.getBody()).isNull();
    }

    @Test
    public void test_cambiar_letras_blank() {

	ResponseEntity<ResultadoCambioLetras> result = controller
			.cambiarLetras("");
	assertThat(result).isNotNull();
	assertThat(result.getStatusCode().value()).isEqualTo(400);
	assertThat(result.getBody()).isNull();
    }

    @Test
    public void test_ordenar_rellenar_ok() {

        List valores = new ArrayList<>();
        valores.add(1);
        valores.add(2);
        valores.add(6);

	when(service.ordenarRellenar(any())).thenReturn(valores);
	EntradaOrdenarYCompletar entradaOrdenarYCompletar = new EntradaOrdenarYCompletar();
	entradaOrdenarYCompletar.setValores(valores);

	ResponseEntity<ResultadoOrdenarYCompletar> result = controller
			.ordenarRellenar(entradaOrdenarYCompletar);
	assertThat(result).isNotNull();
	assertThat(result.getStatusCode().value()).isEqualTo(200);
	assertThat(result.getBody()).isNotNull();
    }

    @Test
    public void test_ordenar_rellenar_list_null() {

	EntradaOrdenarYCompletar entradaOrdenarYCompletar = new EntradaOrdenarYCompletar();
	entradaOrdenarYCompletar.setValores(null);

	ResponseEntity<ResultadoOrdenarYCompletar> result = controller.ordenarRellenar(entradaOrdenarYCompletar);
	assertThat(result.getStatusCode().value()).isEqualTo(400);
    }

    @Test
    public void test_ordenar_rellenar_size_zero() {

	EntradaOrdenarYCompletar entradaOrdenarYCompletar = new EntradaOrdenarYCompletar();
	entradaOrdenarYCompletar.setValores(new ArrayList<>());

	ResponseEntity<ResultadoOrdenarYCompletar> result = controller.ordenarRellenar(entradaOrdenarYCompletar);
	assertThat(result.getStatusCode().value()).isEqualTo(400);
    }

    @Test
    public void test_combinarBilletes_ok() {

	when(service.obtenerCombinacionesBilletes(any())).thenReturn(new ArrayList<>());

	ResponseEntity<ResultadoCombinacionBilletes> result = controller
			.obtenerCombinacionesBilletes(1D);

	assertThat(result).isNotNull();
	assertThat(result.getStatusCode().value()).isEqualTo(200);
	assertThat(result.getBody()).isNotNull();
    }

    @Test
    public void test_combinarBilletes_zero() {

	ResponseEntity<ResultadoCombinacionBilletes> result = controller
			.obtenerCombinacionesBilletes(0D);
	assertThat(result.getStatusCode().value()).isEqualTo(400);
	assertThat(result.getBody()).isNull();
    }

    @Test
    public void test_combinarBilletes_null() {

	ResponseEntity<ResultadoCombinacionBilletes> result = controller
			.obtenerCombinacionesBilletes(null);
	assertThat(result.getStatusCode().value()).isEqualTo(400);
	assertThat(result.getBody()).isNull();
    }
}
