Actualmente existen dos paquetes, datos y dominio, el paquete datos contiene dos clases, una se encarga de la conexión a 
una base de datos MYSQL y la otra se encarga a través de sus métodos en realizar el respectivo CRUD.

En el paquete "dominio" existen tres clases y dos interfaces, entre ellas dos clases padres, la clase Cliente es la clase
padre que se encarga de cargar todos los datos del cliente a través de arrays y que dichos arrays sean heredados a las cla-
ses hijas, lo mismo pasa con la clase Mercancía, solo que este carga los datos de las mercancías de las base de datos, to-
do a través de Arrays, la clase Contenedor posee unos métodos mas simplificados para realizar CRUD en algún momento deter-
minado en cuanto se necesite, todo esto es para la el futuro paquete "presentación", donde se elaborará la parte gráfica 
del sistema.

El sistema cuenta con dos interfaces, uno es ICompletivo_Cliente y otro es ICompletivo_Mercancia, ambos se encargan de he-
redar los respectivos contadores de la consultas de las clases Cliente y Mercancía, todo esto para realizar un nuevo CRUD
y almacenarlos en Arrays a alguna clase que ya haya heredado de una clase padre, pero necesite datos de la otra clase pa-
dre, en definitiva, ámbas Interfaces servirán de puente entre las clases padres para las clases hijas que deseen heredar
datos de una clase que sea diferente a la del padre que tiene asignado.