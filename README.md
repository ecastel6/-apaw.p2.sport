# Práctica APAW. ECP2. Arquitecturas y Patrones Web
#### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*
#### [Máster en Ingeniería Web por la U.P.M.](http://miw.etsisi.upm.es)

### Tecnologías necesarias
* Java
* Maven
* Eclipse
* GitHub

### Descripción
Aplicación de patrones de diseño Web y arquitecturas por capas.
Se pretende desarrollar la aplicación software: Sports. Su funcionalidad será la gestión de un conjunto de usuarios con los deportes que practican.

Deberá responder correctamente a las siguientes peticiones de API:
* POST / users body=nick:email
** Se crea un usuario
** Si se intenta un Nick que ya existe debe dar un mensaje de error
* POST / sports body=name
** Se crea un deporte
** Si se intenta un deporte que ya existe debe dar un mensaje de error
* PUT / users/{nick}/sport body=portName
** Se añade un deporte a un usuario
** Se pueden añadir varios deportes
** Si se intenta un deporte que no existe debe dar un error
* GET / users
** Devuelve todos los usuarios (nick:email)
* GET / users/search?sport=*
** Devuelve todos los usuarios que practican un deporte (nick)
