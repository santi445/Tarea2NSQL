# Tarea2NSQL

# Descripción:
Gestionar la información de domicilios asociados a personas. Permitir realizar operaciones como la creación de nuevas personas, nuevos domicilios, consulta de domicilios por cédula de persona o bajo ciertos criterios (Barrio, Localidad, Departamento), y paginación de resultados.

# Formato de Intercambio de Datos: 
Se realiza en formato JSON. A continuación, se muestra un ejemplo de la estructura de un objeto de domicilio:
```json
{
"cedula": 1234,
"departamento": "Montevideo",
"calle": "Jose Elizalde",
"numero": "123",
"barrio": "Pajas Blancas"
}
```
# URL de los Servicios:
- Crear Persona: localhost:8080/Personas

- Crear Domicilio: localhost:8080/Domicilio?cedulaPersona=12345

- Obtener Domicilios por Cedula: localhost:8080/Domicilio?cedulaPersona=12345&size=3&page=0&sort=_id,desc

- Obtener Domicilios por Criterio: localhost:8080/Domicilio/getDomicilio?departamento=Montevideo

# Tecnologías Utilizadas
- Spring Boot
- MongoDB
- Maven
- Postman
- Java

# Instalación
- Tener instalado MongoDB, Postman, Java JDK 11
- Contar con una Base de Datos llamada "Tarea2NSQL" junto con las siguientes colecciones "Personas" y "Domicilio"
- Clonar este repositorio e importar el proyecto en Spring Tool Suite 4
- Ejecutar el proyecto y utulizar las URL anteriormente mencionadas para su funcionamiento
