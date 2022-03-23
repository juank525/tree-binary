# Árbol Binario

### ¿Qué es un árbol binario?
Un árbol binario de búsqueda también llamado BST (acrónimo del inglés Binary Search Tree) es un tipo particular de árbol binario que presenta una estructura de datos en forma de árbol

### Arquitectura

1. Creacion del proyecto con java 8 y spring boot
2. Carga de aplicacion en Heroku

### Pruebas Servicio

En las siguientes URL se puede consultar la documentación de los servicios

- https://tree-binary-test.herokuapp.com/v2/api-docs
- https://tree-binary-test.herokuapp.com/swagger-ui.html

Url de la colección de postman para realizar consumo y pruebas de los servicios, seleccionar el enviroment env-tree-binary

- https://www.postman.com/redesposicionadas/workspace/test-mo-technologies/overview

- Primero consumir el endpoint /tree-binary para la creación del árbol binario, curl de ejemplo: 
  - curl --location --request POST 'https://tree-binary-test.herokuapp.com/tree-binary' --header 'Content-Type: application/json' --data-raw '{
    "root" : 67,
    "nodes":[39,28,44,29,76,74,85,83,87]
}'
- Segundo consumir el endpoint /lowest-common-ancestor para obtener el ancestro común más cercano, curl de ejemplo:
  - curl --location --request GET 'https://tree-binary-test.herokuapp.com/lowest-common-ancestor?nodeOne=44&nodeTwo=28' --data-raw ''

