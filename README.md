# Secure Server Spark

Esta libreria está implementada en **JAVA** para la materia de **AREP**

Esta librería tiene por función representar los conceptos básicos de un **Servicio de Seguridad y Llaves** por medio de la generación de llaves y certificados.

 
 #### Arquitectura
 
 Como se pude ver en la siguiente imagen, la arquitectura busca el siguiente funcionamiento:
 
 ![image](https://user-images.githubusercontent.com/49318314/95168190-8f800800-0776-11eb-81a4-1b8fe718377e.png)
 
#### Explicación de la arquitectura
Por medio de los servicios proporcionados por un login construido a partir de un login seguro provisto por spark (más información [aquí](https://github.com/tipsy/spark-basic-structure/blob/master/src/main/java/app/login/LoginController.java)), se hace el acceso al primer servidor, que, permite acceder al otro por medio de las llaves, como ejemplo de lo visto tenemos:

![image](https://github.com/IJuanchoG/AREP_LAB_SECURITY/blob/main/images/Captura%20de%20pantalla%202020-10-06%20014458.png)

según el tipo de usuario (si existe en un registro quemado, **solo existe admin**) se dan los privilegios para acceder a la información o no.

## Getting Started


se recomienda clonar el repositorio a su computadora, como opción puede realizarlo por medio del siguiente comando:

``` git clone https://github.com/IJuanchoG/AREP_LAB_SECURITY.git```

La construcción del proyecto se ha realizado por medio de **MAVEN**, es por este motivo que puede ser necesario tener la herramienta en su dispositivo. 

Para compilar el proyecto, ejecute el siguiente comando:

```mvn compile```

posteriormente puede hacer el empaquetado:

``` mvn package```

o es posible usar el comando:

```mvn clean install```

Para realizar la correcta ejecución del programa es necesario usar el siguiente comando:

```java -cp ./classes:./dependency/* edu.eci.arep.securitysparkwebapp.SecureSparkServices```

como se puede apreciar en la consola, la aplicación corre por el puerto **5000** en **localhost**

Lo mejor para saber como funciona el paso de certificados es por medio de la clase ```URLReader``` en donde se puede conocer como obtiene los datos de la consulta según sea permitido acceder a la información.

del mismo modo se pueden ver los servicios corriengo en las siguientes rutas:

- [Primer Servidor de Login](http://ec2-3-80-26-118.compute-1.amazonaws.com:3002/)
- [Segundo Servidor de Otros servicios](http://ec2-3-80-52-35.compute-1.amazonaws.com:3001/hello)

 
 
 ### Prerequisitos.

Es necesario/recomendable que posea las siguientes herramientas:

- git instalado en su computador.
- Maven configurado en sus **Variables de Entorno**.
- Interprete de lenguaje de programacion **JAVA** (Eclipse, netbeans, Intellij, etc.)

si necesita instalar algunos de los servicios mencionados puede encontrarlos aquí:

- **Git** puede descargarlo [aqui.](https://git-scm.com/downloads)

- **Maven** puede descargarlo [aqui.](https://maven.apache.org/download.cgi)

- **IntelliJ** puede descargarlo [aqui.](https://www.jetbrains.com/es-es/idea/download/)

- **Docker** puede descargarlo [aquí.](https://www.docker.com/get-started)


## Built With

* [IntelliJ](https://www.jetbrains.com/es-es/idea/) - The develop enviroment
* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](https://junit.org/junit5/) - Used to generate Unitary Test
* [Docker](https://www.docker.com/get-started) - used to deploy

## Authors

* **Juan Carlos García** - *Initial work* - [IJuanchoG](https://github.com/IJuanchoG)


## License

Este proyecto es de libre uso y distribución, para más detalles vea el archivo [LICENSE.md](LICENSE.md).
