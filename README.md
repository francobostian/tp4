Maven: <br>
mvn clean: limpia artefactos creados por compilaciones previas.<br>
mvn compile: compila el código fuente del proyecto<br>
mvn package: toma el código compilado y lo empaqueta en el .jar en nuestro caso.<br>
mvn install: instala el paquete en el repositorio local, para usar como dependencia en otros proyectos localmente.<br>

Scope<br>
Compile: es el scope por defecto, se usa si no hay otro especificado. Las dependencias compiladas están disponibles en todos los classpath del proyecto. 
<br>Provided: indica que se espere el JDK o un contenedor que provee a las dependencias en tiempo de ejecución.
<br>Runtime: indica que la dependencia no es requerida para compilación, pero si para ejecucion.
<br>Test: Indica que la dependencia solo estará disponible realizando testing.
<br>System: es similar a provided, pero se debe especificar donde buscar la dependencia del JAR.
<br>Import: Indica la dependencia a ser reemplazada con la lista de dependencias en el POM especificado.

Que es un Arquetype?<br>
Un arquetipo es un patrón o modelo original sobre el que pueden desarrollar todas aquellas cosas que son de un mismo tipo. Puede decirse que son plantillas, parametrizadas o configuradas para utilizar determinadas tecnologías, que los programadores utilizan como base para escribir y organizar el código de la aplicación.
<br><br>Defina la estructura base de un proyecto Maven
 <br>Tiene cuatro carpetas por defecto,  src/main/java: donde guardaremos nuestras clases java fuente. Debajo de esta carpetaclases java situaremos nuestras clases en distintos paquetes, src/main/resources: aquí almacenaremos los recursos (ficheros xml, ficheros de propiedades, imagenes, etc) que pueda necesitar las  de nuestro proyecto. Igualmente aquí tienen que ir los ficheros de configuración de Spring o Hibernate por ejemplo., src/test/java: en dicha carpeta se guardan las clases de test que se encargarán de probar el correcto funcionamiento de nuestra aplicación. Aquí por ejemplo podemos guardar nuestros test unitarios de JUnit, src/test/resources: en esta carpeta guardamos los recursos que usan los recursos. Ademas el proyecto contiene un POM, donde se hace la configuración del proyecto.<br>


<br>Diferencia de Archetype y Artifact <br>
El artifact es el proyecto en si mismo, el resultado de la compilación. El Archetype es la plantilla configurada para utilizar determinadas tecnologías, que los programadores utilizan como base para escribir y organizar el código de la aplicación.


<br>Explique los 4 stereotypes basicos y realice un diagrama de cada uno de ellos . (@Component, @Repository, @Service, @Controller).
<br><br>@Repository: Es un marcador para cualquier clase que funcione como acceso a datos en un repositorio.
![Imagen Diagrama @Repository](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesRepository.png) <br />

<br>@Component: Es un estereotipo genérico para cualquier bean sea interpretado por Spring como uno de sus objetos.
![Imagen Diagrama @Component](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypes.png) <br />
	
<br>@Service: Es el estereotipo de la capa de servicios, posee la lógica de negocios. Es el intermediario del @Controller y el @Repository <br>
![Imagen Diagrama @Service](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesService.png) <br />

<br>@Controller: Es quien se encarga de realizar las acciones que hace el usuario en la aplicación, realiza las tareas de gestión entre el usuario y la aplicación.<br>
![Imagen Diagrama @Controller](https://www.arquitecturajava.com/wp-content/uploads/SpringStereotypesController.png) <br />
<br>REST:<br>
<br>GET: trae información.
<br>POST: crea recursos.
<br>PUT: edita recursos.
<br>DELETE: borra recursos.
<br>PATCH: actualiza solo un campo especificado.
