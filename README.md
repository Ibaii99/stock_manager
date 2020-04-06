# Stock Manager

Esta es **API REST** del proyecto del **Grupo 2** desarrollada en python 3 (Python 3) y Java 1.8(Oracle).

TecnologÃ­as usadas:
-  virtualenvwrapper --> **Entornos virtuales** que se van a usar
   - docu: https://virtualenvwrapper.readthedocs.io/en/latest/index.html 
- Django --> **Web Framework** que se va a usar para la parte de cliente
   - docu: https://docs.djangoproject.com/en/3.0/
- Maven --> **Herramienta de software para la gestión y construcción de proyectos Java** usada en la API REST.
   - docu: https://maven.apache.org/guides/index.html
- MySQL --> Sistema de gestión de bases de datos relacional **SGBD**
   - docu: https://dev.mysql.com/doc/

# Steps
### Client
1. Crear un entorno virtual
2. Instalar pip
3. Instalar dependencias:
~~~ 
pip install -r requirements.txt 
~~~
4. En stock_manager/mysite/stock_manager:
~~~ 
python manage.py runserver
~~~ 
### API
1. Instalar dependencias
~~~ 
mvn install
~~~ 
2. Compilar el proyecto
~~~ 
mvn clean compile
~~~ 
3. Crear el esquema de las clases en la base de datos
~~~ 
mvn datanucleus:schema-create
~~~ 
4. Ejecutar la API
~~~ 
mvn exec:java
~~~ 
0. Borrar las tablas de la base de datos
~~~ 
mvn datanucleus:schema-delete
~~~ 
*Notas: Si se tiene algún problema con el paso 3 ejecutar las tablas manualmente en mysql con el archivo BD?code.sql en src\main\sql.*

# Inicio de aplicación

Para un correcto uso de la aplicación implementada estos requisitos deberían ser completados.
1. Se debe activar el entorno virtual.
2. Se debe tener activa la aplicación de MySQL Workbench.
3. Se debe ejecutar el comando mvn compile exec:java para el correcto funcionamiento del proyecto.

Por otro lado si se implementa el proyecto por primera vez se deberían seguir las instrucciones que se especifican en el archivo instrucciones.txt
