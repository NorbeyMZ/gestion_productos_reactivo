# gestion_productos_reactivo

GESTIÓN DE PRODUCTOS REACTIVO

Este proyecto es una API para gestionar productos reactivos, implementada con Spring Boot, MongoDB y Maven. Incluye funcionalidades para crear, obtener y eliminar productos, junto con pruebas automatizadas para garantizar su funcionamiento.

## Requisitos

Para ejecutar este proyecto y las pruebas, necesitas tener instalados los siguientes programas:

Java 17 o superior

Maven (si no estás utilizando el wrapper de Maven mvnw)

Docker (para ejecutar el servicio MongoDB en caso de que no lo tengas instalado)

Si quieres utilizar el wrapper de Maven (mvnw), no necesitas instalar Maven globalmente en tu máquina, solo Java.

# Pasos para ejecutar las pruebas localmente
Clona el repositorio:

bash
-Copiar
-Editar
-git clone https://github.com/NorbeyMZ/gestion_productos_reactivo.git
-cd gestion_productos_reactivo

## Ejecutar las pruebas unitarias localmente:
Si ya tienes Maven instalado en tu máquina, puedes ejecutar las pruebas con el siguiente comando:

bash
-Copiar
-Editar
-mvn test

## Si prefieres usar el wrapper de Maven (mvnw), ejecuta:

bash
-Copiar
-Editar
-./mvnw test

## Verifica los resultados de las pruebas:

Las pruebas se ejecutarán y verás un resumen de los resultados, indicando si todas pasaron correctamente o si hubo algún error. Los resultados estarán disponibles en la consola.

Los resultados también se guardan en el directorio target/surefire-reports, donde se encuentran los informes detallados.


## Ejecutar las pruebas en GitHub Actions
Cada vez que se realice un push a la rama main o se abra un pull request, las pruebas se ejecutarán automáticamente en GitHub Actions, gracias al pipeline CI/CD configurado.

Cómo verificar los resultados en GitHub Actions:
Accede a GitHub.

En la parte superior de la página, haz clic en la pestaña Actions.

Aquí podrás ver todas las ejecuciones de tu pipeline CI/CD. Si todo ha salido correctamente, deberías ver una ejecución con el estado success. Si algo ha fallado, el estado será failure y podrás hacer clic en el log para obtener más detalles.





