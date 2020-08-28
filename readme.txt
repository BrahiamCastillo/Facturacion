Actualmente existen dos paquetes, datos y dominio, el paquete datos contiene dos clases, una se encarga de la conexi�n a 
una base de datos MYSQL y la otra se encarga a trav�s de sus m�todos en realizar el respectivo CRUD.

En el paquete "dominio" existen tres clases y dos interfaces, entre ellas dos clases padres, la clase Cliente es la clase
padre que se encarga de cargar todos los datos del cliente a trav�s de arrays y que dichos arrays sean heredados a las cla-
ses hijas, lo mismo pasa con la clase Mercanc�a, solo que este carga los datos de las mercanc�as de las base de datos, to-
do a trav�s de Arrays, la clase Contenedor posee unos m�todos mas simplificados para realizar CRUD en alg�n momento deter-
minado en cuanto se necesite, todo esto es para la el futuro paquete "presentaci�n", donde se elaborar� la parte gr�fica 
del sistema.

El sistema cuenta con dos interfaces, uno es ICompletivo_Cliente y otro es ICompletivo_Mercancia, ambos se encargan de he-
redar los respectivos contadores de la consultas de las clases Cliente y Mercanc�a, todo esto para realizar un nuevo CRUD
y almacenarlos en Arrays a alguna clase que ya haya heredado de una clase padre, pero necesite datos de la otra clase pa-
dre, en definitiva, �mbas Interfaces servir�n de puente entre las clases padres para las clases hijas que deseen heredar
datos de una clase que sea diferente a la del padre que tiene asignado.

12:14
37:00 horas
