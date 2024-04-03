1. If I know that my problem has subproblems, which possible algorithm techniques can I use?
   R. Dynamic Programming and
   Greedy Algorithms

con  divide y venceras o memorizacion.


2. Given T = xyzasxyzxmb and P=xyzxm. Define the alphabet, finite set of states, start state, and accepting state.
   R.
   Alfabeto: {x, y, z, a, s, m, b}
   Patron = x  y  z  x  m
   {q0, q1, q2, q3, q4}
    x   y   z    x  m   ... x 
   Estado inicial: q0
   Estado de aceptación: q5

3. Given T = xyzasxyzxmb and P=xyzxm. What is the value of the transition funtion F(2, x)

F(i, a) es la longitud del prefijo más largo de P, el valor de F(2, x) será la longitud del más largo de P que también es un sufijo de P + "x" en la posición 2.

Dado P=xyzxm, analicemos:

Para F(2, x), tiene longitud 1 ya que se obtiene el valor de ""x".
Entonces, el valor de la funcion es 1.


3.  Cube is in a food competition; he is given N meals and has to eat as much as posible in M minutes. Cube can only eat one meal at a time and knows how much time he needs to finish eating each meal. Find the maximum number of meals he can eat in M inutes.

Input A number N and M
Output The maximum number of meals he can eat.

Sample input 1:
5 10
6 3 2 4 1

Sample output 1:
4


Identify if this problem can be solved with dynamic programming and greedy algorithm


If you say that can be solved with dynamic programming
1. Analize the problem based on subproblems.
2. Identify where the overlap occurs.

If you say that can be solved with Greedy
1. Identify the greedy choise.
2.  Explain the optimal substructure.

and What is the time complexity of your solution?

DP:
 Primero, Cuántas comidas puede Cube comer en M minutos si solo consideramos las primeras i comidas?
osea si tengo 5 comidas 6 3 2 4 1 = > en 10 minutos podemos comer => 1 + 4+ 2 + 3 = 10 osea un total de 4
aqui puede haber varios caminos 6 + 4 = 10 pero no es el maximo
6 + 3 + 1 = 10 pero no es el maximo y asi 
Segundo caso 

si Cube tiene 3 comidas => en 5 minutos
y tengo 1 2 3 = > 3 + 2= 5 osea un total de 2

Greedy:
Greedy choise
- Primero, ya podemos elegir tomar las comidas con menos tiempo
  - Ajustamos la comidas mas cortas en el tiempo que nos queda.

Optimal substructure
 - no tomamos en cuenta si hemos decidido comer esa comida en el tiempo dado, por que es optimo comer la comida con menos tiempo
y asi maximizamos el tiempo.

La subestructura óptima en este caso es que si hemos decidido comer una comida en un momento dado, no hay necesidad de reconsiderar esa decisión.
Esto se debe a que siempre será óptimo comer la comida que toma menos tiempo en un momento dado para maximizar el número total de comidas.
-- implementacion de sort cambia mi tiempo de complejidad
con greedy sacamos directamente el resultado:  6 3 2 4 1 = > en 10 minutos podemos comer => 1 + 4+ 2 + 3 = 10 osea un total de 4

por lo que afecta a la complejidad del algoritmo, 

DP: O(N * M), donde N es el número de comidas y M es el tiempo máximo.
Greedy:  O(N log N), ya que necesitaríamos ordenar las comidas por su tiempo de consumo.

