1. How does it benefit us to have the pre-processing part in the string matching algorithms?
R. Eficienciencia, Optimizacion, y reconocimiento de patrones. 
Eficiencia porque manejamos de manera eficiente las cadenas de patrones o texto, reduciendo la complejidad total del algoritmo:
Teniendo un mejor caso de O(n) y un peor caso de O(m*n)
Optimizacion porque almacenamos en cache, teniendo ademas una manera o forma de verificar los posibles valores de s : P[1…m] = T[s+1 … s+m] for each of the n - m + 1 possible values of s. teniendo un tiempo de ejecucion mas rapido.
Y lo mas importante reconocimiento de patron, osea que implicamos una estructura de datos para reconocer un patron, teniendo como prioridad la busqueda de un patron, conociendo un preprocedimiento tenemos un algoritmo consistente, asegurando su efectividad.

Ejemplo tarea 1:
Texto : 000010001010001.
Patron : 0001


2. Given a text string "T" and pattern string "P", demostrate the step involved in applying the Rabin Karp String Matching algorithm to find all occurrences of "P" in "T"
R. 

Para el Rabin Karp se dice:
1. Assigning the Numerical Weight/ Value to the characters in general: In
this step, assign the values to the alphabets as per their
lexicographical order. For eg. a=1, b=2, c=3…
Or calculate a hash value for the pattern using a hash function.
2. Calculate the Hash Value of the string to be searched:
   How is Hash Value calculated in Rabin-Karp?
   Hash value is used to efficiently check for potential matches between
   a pattern and substrings of a larger text.
   The hash value is calculated using a rolling hash function.

Teniendo como hash:
Hash:
ascii of (P[0]) * Prime^0 + ascii of (P[1]) * Prime^1 + ascii of (P[2]) * Prime^2 + …
Hash of Pattern = 97 * 7^0 + 98 * 7^1 + 97 * 7^2 + 99 * 7^3 = 39493
Ascii of ‘a’ = 97. Ascii of ‘b’ = 98. Ascii of ‘c’ = 99.
Hash of abca = 97 * 7^0 + 98 * 7^1 + 99 * 7^2 + 97 * 7^3 = 38905
Note: In other cases: the problem provides the hash value

3. Calculate the Hash Value for the text by dividing them into groups of
   size 'm':
4. Comparison: You need to keep iterating and comparing the hash value
   of other windows and match it with the string. If it does, we perform the
   pattern matching for the rest of the alphabets, otherwise, we move to
   others.

Osea:

    - Pre-procesamiento: Calcular el valor hash de la cadena de patrón "P" o tambien puedes tomar otro camino con el LexicoGramatical.
    - Calculo de hash: Deslizar una ventana de longitud igual al tamaño del patrón sobre la cadena de texto "T". es usado verificando entre un patron o una subcadena del texto, calcular el valor hash a un rolling hash funtion.
Hash:
ascii of (P[0]) * Prime^0 + ascii of (P[1]) * Prime^1 + ascii of (P[2]) * Prime^2 + …
Hash of Pattern = 97 * 7^0 + 98 * 7^1 + 97 * 7^2 + 99 * 7^3 = 39493
Ascii of ‘a’ = 97. Ascii of ‘b’ = 98. Ascii of ‘c’ = 99.
Hash of abca = 97 * 7^0 + 98 * 7^1 + 99 * 7^2 + 97 * 7^3 = 38905
Note: In other cases: the problem provides the hash value

    - Calculas el valor del hash del texto dividiendo los grupos a una longitud m.
    - Comparacion: Necesitamos tener una iteracion y comparar el valor del hash de la ventana y combínalo con la cadena. Si es así, realizamos el coincidencia de patrones para el resto de los alfabetos; de lo contrario, pasamos a otros.

Ejemplo:
Given Text: ABCCDDAEFG
Text to be searched: CDD

Para el Naive String Matching:
Procedure NAIVE-STRING-MATCHER takes time:
For example:
String: Hello
Pattern: ll
O((n-m+1)m)
Once ﬁnd the match, start iterating through the pattern to check for the
subsequent matches.
Pattern is found at index 2 in String
Length of pattern has to be less or
equal to length of string, if pattern's
length is greater than length of string
return pattern not found.

Diferencias importantes a tomar en cuenta:
ComplexityValue

Robin Karp
BestO(m+n)
WorstO ((n-m+1) m)

Naive String Matching
ComplexityValue
BestO(n)
WorstO(m*n)



Pasos involucrados en la aplicación del algoritmo de búsqueda de cadenas Rabin-Karp para encontrar todas las ocurrencias del patrón "P" en el texto "T":


3. Why do we need to do a formal proof for a greedy algorithm?
R.


3. ¿Por qué necesitamos hacer una prueba formal de un algoritmo codicioso?


Two fundamental approaches to proving
correctness of greedy algorithms
1. Greedy stays ahead: Partial greedy
   solution is, at all times, as good as an
   “equivalent” portion of any other
   solution
2. Exchange property: An optimal
   solution can be transformed into a
   greedy solution without sacriﬁcing
   optimality.

Osea, aseguramos que el algoritmo siempre de la solucion mas optima, cumpliendo asi con los criterios, garantizando asi el comportamiento de dicho algoritmo
ejemplo su complejidad. Ademas podemos ampliar escenarios que puede fallar el algoritmo, por lo que, podemos igualmente comparar con otros algoritmos


Coco's Theme party is coming soon, to have the surprise theme party ready, Alice is asking for your help, to find the least time for packing and delivering all the present
Input: a number n, followed by n numbers that represent the number presents to be repacked.
the next two lines separed by space, are given the second line is the repacking time of every present by Alice, and the third line is delivering time by delivery service 
Output: The shortest possible delivery time for all presents.

Input 1
4
2 3 10 5 
1 7 12 6

Output 1
31

Input 2
5
4 4 30 6 2
5 1 4 30 3

Output 2
47

Input 3
6
12 6 4 8 11 9
11 5 2 3 8 1

Output 3
51

Solucion :
1. Podemos ordenar los regalos en orden descendente de tiempo de entrega.
2. Para cada regalo podemos calcular el tiempo total de empaquetado y entrega.
3. y El tiempo total sera el maximo de los tiempos calculados en el punto 2.


Input 2
5
4 4 30 6 2
5 1 4 30 3

Output 2
47

[(4,5), (4,1), (30,4), (6,30), (2,3)]
Ordenar:
[(6,30), (30,4), (4,5), (2,3), (4,1)]
Suma:
Los tiempos totales son [36, 40, 45, 48, 49]


Input 3
6
12 6 4 8 11 9
11 5 2 3 8 1

Output 3
51

[(12,11), (6,5), (4,2), (8,3), (11,8), (9,1)]
Ordenar:
[(12,11), (11,8), (6,5), (8,3), (4,2), (9,1)]
Suma:
Los tiempos totales son [23, 42, 53, 64, 70, 79]

Input 1
4
2 3 10 5 
1 7 12 6

Output 1
31

[(2,1), (3,7), (10,12), (5,6)]
Ordenar:
[(10,12), (5,6), (3,7), (2,1)]
Suma:
Los tiempos totales son  [12, 18, 28, 31]

Ya, otra logica:

Ordenamos los regalos en orden descendente de tiempo de entrega
Actualizamos el tiempo total de empaquetado
Calculamos el tiempo total de empaquetado y entrega para este regalo
Actualizamos el tiempo máximo

y ya 

Greedy:

Sí, este problema se puede resolver utilizando greedy. La idea clave a resolverlo es que siempre quieres empaquetar el regalo que tiene el mayor tiempo de entrega a continuación. Esto se debe a que, una vez que un regalo está empaquetado, tienes que esperar su tiempo de entrega, pero puedes empaquetar otros regalos mientras tanto.

Complejidad es O(n log n), donde n es el número de regalos. Esto se debe a que necesitas ordenar los regalos, lo cual toma tiempo O(n log n).


