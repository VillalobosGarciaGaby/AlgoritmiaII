Chocolate bar
Algoritmia II
Coco has a chocolate bar that is 1 x N, where each chocolate block is 1 x 1 and unbreakable.
She wants to divide the bar into different sizes. For example, if she has a bar of 1 x 8, she can
divide it into the following pieces: 1x1, 1x3, and 1x4.
Help Coco maximize the pieces of chocolate she will end up with.
Input
A number N.
Output
The maximum number of pieces of chocolate that can be obtained.

(a) If you say that can be solved with dynamic programming
i. Analyze the problem based on sub-problems.

El objetivo es encontrar el máximo número de piezas de chocolate que se pueden obtener al dividir una barra de
chocolate de longitud N en segmentos.

Comencemos con el tamaño de barra inicial de 1 x 8. Coco puede optar por dividirla en trozos más pequeños.
Ahora, identifiquemos las posibles divisiones:

- Coco puede dividirlo en 1 x 1 + 1 x 7, dándole 2 pedazos.
- También como en 1 x 2 + 1 x 6, lo que le da 2 piezas.
- Otra opción es 1 x 3 + 1 x 5, dando como resultado 2 piezas.
- Podría dividirlo en 1 x 4 + 1 x 4, lo que daría como resultado 2 piezas.
- Finalmente, Coco puede optar por dividirlo en 1 x 1 + 1 x 3 + 1 x 4, dándole 3 piezas.
  Entonces, al intentar desglosar el problema, podemos ver que para N = 8, el número máximo de piezas que Coco puede obtener es 3.

ii. Identify where the overlap occurs.

Ocurre cuando se llama a la función `divideChocolate` con los mismos parámetros. La matriz de memoria `dp` se utiliza
para almacenar los resultados de subproblemas que ya se han resuelto. Si la longitud de la barra de chocolate N y el
valor de inicio son los mismos, entonces el resultado ya está almacenado en `dp[n]`. Por lo tanto, si `dp[n]` no es -1,
significa que ya se ha calculado el resultado para esa longitud y se puede devolver directamente.


N   |  dp
-------------------------
8    |  [1, 3, 4]        | 3
12   |  [1, 2, 3, 6]     | 4
5    |  [2, 3]           | 2
20   |  [2, 3, 4, 5, 6]  | 5

N: 8	dp: [1, 3, 4]	count: 3

N: 12	dp: [1, 2, 3, 6]	count: 4

N: 5	dp: [2, 3]	count: 2

N: 20	dp: [2, 3, 4, 5, 6]	count: 5


iv. What is the time complexity of your solution?
- Por lo tanto, el número de subproblemas únicos es aproximadamente proporcional a \(O(N^2)\).

- Dado que cada subproblema se puede resolver en tiempo constante una vez que se calcula su valor, el trabajo por subproblema se puede considerar constante, O(1).

Al combinar estos dos factores, obtenemos una complejidad temporal de aproximadamente O(N^2) para la solución proporcionada.


