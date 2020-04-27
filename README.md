# Stock Manager
[![Coverage Status](https://coveralls.io/repos/github/ProcesoSoftware/stock_manager/badge.svg?branch=master)](https://coveralls.io/github/ProcesoSoftware/stock_manager?branch=master)
[![Build Status](https://travis-ci.com/Ibaii99/stock_manager.svg?branch=master)](https://travis-ci.com/Ibaii99/stock_manager)

Este es el repositorio del proyecto del **Grupo 2**, incluye:
- **API REST** desarrollada en Java 1.8 (Oracle) con maven. *[Stock_manager]*
- **CLIENTE** desarrollado en python 3 (Python 3) y django. *[Mysite]*
- **ADMINISTRADOR** dessarrollado en Java 1.8 (Oracle) con maven. *[Myadmin]*

### Tecnologias usadas:
- virtualenvwrapper-win --> **Entornos virtuales** que se van a usar
   - docu: https://virtualenvwrapper.readthedocs.io/en/latest/index.html 
- Django --> **Web Framework** que se va a usar para la parte de cliente
   - docu: https://docs.djangoproject.com/en/3.0/
- Maven --> **Herramienta de software para la gestión y construcción de proyectos Java** usada en la API REST.
   - docu: https://maven.apache.org/guides/index.html
- MySQL --> Sistema de gestión de bases de datos relacional **SGBD**
   - docu: https://dev.mysql.com/doc/

# Pasos para ejecutar
### Cliente
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
*Notas: Si se tiene algún problema con el paso 3 ejecutar las tablas manualmente en mysql con el archivo BD_code.sql que se encuentra en src.main.sql.*
### Administrador
1. Instalar dependencias
~~~ 
mvn install
~~~ 
2. Compilar el proyecto
~~~ 
mvn clean compile
~~~ 
3. Ejecutar la aplicacion.
~~~ 
mvn exec:java
~~~ 

