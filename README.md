# WherEat
Una aplicacion que reune todos los menus de 
establecimientos de comida en CU UAEMex

## Descripcion
Esta aplicacion esta pensada para que los estudiantes de la
UAEMex puedan ver los menus de los establecimientos de comida
de Ciudad Universitaria, asi como tambien poder ver la ubicacion
de estos establecimientos deacuerdo a 
la facultad a la que pertenecen en CU.

## Requerimientos
- Java 21 o superior
- Tener el archivo .xlsx con los menus de los establecimientos (Incluido en el zip src/main/resources/Data/menus.xlsx)

## Notas
- La aplicacion esta pensada para ejecutarse de forma local, por lo que no se ha implementado un servidor
- No se ha implementado una base de datos, por lo que los datos se obtienen del archivo .xlsx
- El compilado .jar no implementa el archivo .xlsx, por lo que se debe ejecutar desde el IDE
- IDE recomendado: IntelliJ IDEA
- Aquellas instrucciones sout del codigo son para pruebas, por lo que se pueden eliminar (No se han eliminado por si se requieren en un futuro)
- El archivo .jar se encuentra en la carpeta out/artifacts/WherEat_jar (Pero no se podra iniciar sesion debido a la falta del archivo .xlsx)
