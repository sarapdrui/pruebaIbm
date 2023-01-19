# pruebaIbm
Prueba Sara Para IBM

Este programa tiene como objetivo generar un fichero plano que vuelque los registros de la base de datos dado 
el id de un cliente. 

Para ello es necesario introducir como argumento un numerico, de lo contrario el programa devolverá un mensaje con
el error y dejará de ejecutarse. 
Si el id introducido no corresponde a ningún cliente el programa devolverá un mensaje con el error y dejará de ejecutarse. 

El fichero plano se generará en la raiz del proyecto. 

Forma de ejecución:

ENTORNO: 
Para ejecutar el programa es necesario que sea compilado desde in IDE como, por ejemplo, inteliJIdea.
Una vez tengamos el IDE es necesario indicar que la jdk utilizada será Java 11 y la versión de maven será 3.8.1.

BASE DATOS:
Antes de ejecutar el programa es necesario tener un entorno de mysql levantado, para que se pueda acceder a la base de datos.
Una vez tengamos este entorno ejecutaremos el script que hay en la raiz del proyecto para crear un nuevo esquema que contenga la 
tabla de proveedores y realice los inserts. 

ARGUMENTOS: 

Una vez configurado el entorno será necesario añadir 5 argumentos al programa: El id del cliente del que se quiere
recuperar la informacion, el host de la base de datos, el puerto, el nombre del usuario y la contraseña. 

Una vez se hayan realizado estos pasos el programa de podrá ejecutar. 

DEPENDENCIAS:

Como se trata de un proyecto simple las unicas dependencias usadas han sido las de lombok y las de mysql. 