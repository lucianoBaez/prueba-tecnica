# Prueba Técnica


## Instalación  del proyecto 
**Descargar el código**

```console
git clone https://github.com/lucianoBaez/prueba-tecnica.git
```

**Compilar el código**

```console
 ./gradlew build
```

**Levantar proyecto:**

```console
./gradlew bootRun
```

## Tests

**Ejecución de tests:** 
```console
./gradlew :test --tests "com.examen.dynamic.controller.ExamenControllerTest"
```


**Ejecución test en particular:** 
```console
 ./gradlew :test --tests "com.examen.dynamic.controller.ExamenControllerTest.test_cambiar_letras_ok"
```


## Swagger UI  

Para acceder localmente, luego de levantar el proyecto en este [link](http://localhost:8080/swagger-ui.html)

Para acceder a la versión desplegada en Heroku desde este [link](https://prueba-tecnica-dynamic-dev.herokuapp.com/swagger-ui.html) 

