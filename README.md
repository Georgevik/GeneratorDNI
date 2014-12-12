GeneratorDNI
============

Programa Java al cual se le introduce por consola el número de DNIs que se quieren obtener y genera 3 ficheros `.pat` 
preparados para ser leidos por JavaNNS:
- **dni_full.pat** Contiene todos los DNIs generados automaticamente y
- **dni_train.pat** Contiene el 70% de los casos generados en el archivo dni_full.pat
- **dni_test.pat** Contiene el 30% de los casos generados en el archivo dni_full.pat

Compilación y ejecución
=======================

Se compila el Main.java con: `javac Main.java`

Se ejecuta el programa con: `java Main <n_dni>`

Correspondencia Numero-Letra
============================
```
0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22
|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
T  R  W  A  G  M  Y  F  P  D  X  B  N  J  Z  S  Q  V  H  L  C  K  E
```
