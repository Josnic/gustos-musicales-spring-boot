# Api rest Gutos musicales

Api rest desarrollada usando `Java 1.8` y `SpringBoot 2.7.1`.

## Generalidades

Contiene autenticación apiKey (ver archivo .properties para ver el nombre del header y el valor del apiKey a enviar, dado que la autenticación esta "hardcodeada" y no está dinámica por Base de Datos o tabla de apiKey´s) y la documentación [Swagger](https://localhost:8080/swagger-ui/index.html) para ver la información de los paths y sus respectivos schemas: https://localhost:8080/swagger-ui/index.html. Los test aún no están finalizados.

El Api cuenta con endpoints de tipo POST para crear los estilos musicales y adicionar el registro de encuenta, y de tipo GET para las consultas.

Para el uso con el app móvil es necesario poblar la Base de Datos In-memory H2 para los estilos musicales, ya que no se pobla por defecto y se prefiere la inserción de data por medio del endpoint `/apiv1/musical-style/add`. 