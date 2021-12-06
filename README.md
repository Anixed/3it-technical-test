# Prueba Técnica 3IT – Desarrollador Mobile

```bash
$ git clone https://github.com/Anixed/3it-technical-test.git
$ cd 3it-technical-test/
```

## Backend (Spring Boot)

```bash
$ cd apirest/

# Correr los tests
$ ./mvnw test

# Correr Api REST
$ ./mvnw spring-boot:run
```

### Rutas disponibles

Ruta base `http://localhost:8080/`

Método HTTP | Ruta | Body | Descripción
--- | --- | --- | ---
`GET` | `/api/musical-styles` | N/A | Obtener los estilos musicales disponibles
`GET` | `/api/musical-styles/{id}` | N/A | Obtener estilo musical según Id
`GET` | `/api/quiz/results` | N/A | Obtener resultados de encuestas
`GET` | `/api/quiz/{id}` | N/A | Obtener encuesta según Id
`POST` | `/api/quiz` | `{"email": "example@3it.cl", "musical_styles_ids": [12, 26, 6]}` | Agregar una nueva encuesta
`DELETE` | `/api/quiz/{id}` | N/A | Eliminar una encuesta según Id

## App móvil (React Native)

Por defecto la ruta base del Api REST es `http://localhost:8080/api`. Esta se puede modificar en `app/api/ApiService.js` línea `14`.

```bash
$ cd QuizApp/
$ yarn install

# Correr la app (modo desarrollo)
$ npx react-native run-android
```