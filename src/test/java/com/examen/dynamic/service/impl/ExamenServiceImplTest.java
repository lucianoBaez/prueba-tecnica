package com.examen.dynamic.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ExamenServiceImplTest {

    private final List<Integer> INPUT = Arrays.asList(1, 2, 5);
    private final List<Integer> OUTPUT = Arrays.asList(1, 2,3,4,5);

    @InjectMocks
    private ExamenServiceImpl service;

    @Test
    public void ordenarRellenar_test_ok() {
	List list = service.ordenarRellenar(INPUT);
	assertThat(list).isNotNull();
	assertThat(list.size()).isEqualTo(5);
	assertThat(list).isEqualTo(OUTPUT);
    }

    @Test
    public void ordenarRellenar_test_null() {
	List list = service.ordenarRellenar(null);
	assertThat(list).isNotNull();
	assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void ordenarRellenar_test_zero() {
	List list = service.ordenarRellenar(new ArrayList<>());
	assertThat(list).isNotNull();
	assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void cambiarLetras_test_ok() {
        String resultadoEsperado = "QSVFCB DPO A 123a **";
	String resultado = service.cambiarLetras("PRUEBA CON Z 123z **");
	assertThat(resultado).isNotNull();
	assertThat(resultado).isEqualTo(resultadoEsperado);
    }

    @Test
    public void cambiarLetras_test_null() {
        String resultadoEsperado = "";
	String resultado = service.cambiarLetras(null);
	assertThat(resultado).isNotNull();
	assertThat(resultado).isEqualTo(resultadoEsperado);
    }

    @Test
    public void cambiarLetras_test_blank() {
	String resultadoEsperado = "";
	String resultado = service.cambiarLetras("");
	assertThat(resultado).isNotNull();
	assertThat(resultado).isEqualTo(resultadoEsperado);
    }

    @Test
    public void combinarBilletes_test_ok() {
        List uno = Arrays.asList(0.5, 0.5);
        List dos = Arrays.asList(1.0);
        List tres = Arrays.asList(0.2, 0.2, 0.2, 0.2, 0.2);

        List combinacionesEsperadas = new ArrayList();
        combinacionesEsperadas.add(uno);
        combinacionesEsperadas.add(dos);
        combinacionesEsperadas.add(tres);

	List<List<Double>> lists = service.obtenerCombinacionesBilletes(1D);
	assertThat(lists).isNotNull();
	assertThat(lists.size()).isGreaterThan(0);
	assertThat(lists).isEqualTo(combinacionesEsperadas);
    }

    @Test
    public void combinarBilletes_test_null() {


	List<List<Double>> lists = service.obtenerCombinacionesBilletes(null);
	assertThat(lists).isNotNull();
	assertThat(lists.size()).isEqualTo(0);
    }

    @Test
    public void combinarBilletes_test_zero() {
     List<List<Double>> lists = service.obtenerCombinacionesBilletes(0D);
     assertThat(lists).isNotNull();
     assertThat(lists.size()).isEqualTo(0);
    }

}
