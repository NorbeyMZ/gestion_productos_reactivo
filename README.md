 Gestión de Productos Reactivos - Pruebas Automatizadas

Este proyecto tiene como objetivo gestionar productos y realizar pruebas automatizadas tanto unitarias como de integración, asegurando la calidad y funcionalidad del sistema. A continuación, se describe cómo ejecutar las pruebas en el entorno local y en GitHub Actions.

## Descripción

El sistema permite realizar operaciones CRUD sobre productos en una base de datos MongoDB. Las pruebas incluyen:

- Pruebas unitarias para el servicio de productos (ProductoService) utilizando **Mockito**.
- Pruebas de integración para el controlador de productos (ProductoController) utilizando **WebTestClient**.
- Automatización del proceso de pruebas con **GitHub Actions**.

## Estructura del Proyecto

- **`/src`**: Contiene todo el código fuente del proyecto.
  - **`/main/java`**: Código principal de la aplicación.
  - **`/test/java`**: Pruebas unitarias e integración.
  - **`/resources`**: Archivos de configuración y propiedades.

## Requisitos

Para ejecutar las pruebas localmente, necesitas:

- **Java 17** o superior.
- **Maven** instalado en tu máquina local.
- **MongoDB** configurado y en ejecución (si las pruebas de integración requieren acceso a la base de datos).

### Dependencias de Maven

Las dependencias necesarias están especificadas en el archivo `pom.xml` y se instalan automáticamente cuando se ejecuta:

```bash
mvn install





