# DYNAMIC DEVS

## Consigna

1. Crear una función que reciba como parámetro un arreglo de números enteros positivos en cualquier
orden, el algoritmo debe completar si faltan números en el arreglo en el rango dado. Finalmente
devolver el arreglo completo y ordenado de manera ascendente.

2. Crear una función que reciba como parámetro un monto en soles y devuelva todas las combinaciones
posibles de billetes y monedas en un arreglo.
Considerar las siguientes denominaciones: 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100, 200

3. Crear una función que reciba un parámetro string que reemplace cada letra de la cadena con la letra
siguiente en el alfabeto. Por ejemplo, reemplazar a por b ó c por d. Finalmente devolver la cadena.

## Solución

1. Para solucionar el problema, se encontró el mayor valor del arreglo, utilizando funciones lambda, luego se generaron los valores desde el 1 al valor máximo.

2. Para solucionar este problema, se utilizó el concepto de recursividad con backtracking o vuelta atrás. Para evitar que se repitan las combinaciones, se ordena la combinación se genera un identificador y se coloca la combinación dentro de un mapa para evitar que se duplique la combinación.

3. Existen varias formas de resolver esto, en este caso se opto por aprovechar la correlatividad que existe en el código ascii respecto al alfabeto.


## Tecnologías utilizadas para implementar la solución.

* Lenguaje: java versión 1.8.
* Framework: spring boot.
* Librerias: Jacoco para code coverage, mockito para los tests, swagger para documentar los servicios rests, lombok.
* Plataforma de despliegue: Heroku




## Instalación  del proyecto 
1. **Descargar código fuente**

```console
git clone https://github.com/lucianoBaez/prueba-tecnica.git
```

2. **Compilar**

```console
 ./gradlew build
```

3. **Desplegar**

```console
./gradlew bootRun
```

4. **Urls**

Para acceder localmente, luego de levantar el proyecto [http://localhost:8080/swagger-ui.html]

Para acceder a la versión desplegada en Heroku desde la url: [https://prueba-tecnica-dynamic-dev.herokuapp.com/swagger-ui.html]

5. **Invocación a servicios**

* Ordernar y rellenar arreglo

```console
curl -X POST "http://localhost:8080/examen/ordenarYRellenar" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"valores\": [ 1,8,14 ]}"
```


* Cambiar letras de la palabra

```console
curl -X GET "http://localhost:8080/examen/cambiarLetras/Dynamic%20Devs" -H "accept: */*"
```


* Obtener combinacion de billetes

```console
curl -X GET "http://localhost:8080/examen/combinarBilletes/1" -H "accept: */*"
```



## Tests

**Ejecución de tests:** 
```console
./gradlew :test --tests "com.examen.dynamic.controller.ExamenControllerTest"

./gradlew :test --tests "com.examen.dynamic.service.impl.ExamenServiceImplTest"
```


**Ejecución test en particular:** 
```console
 ./gradlew :test --tests "com.examen.dynamic.controller.ExamenControllerTest.test_cambiar_letras_ok"
```

**Para revisar la cobertura de código se uso jacoco:** 
```console
 ./gradlew test jacocoTestReport
```

El resultado queda en:

```console
 {ruta del proyecto}/prueba-tecnica/build/jacocoHtml/index.html
```
