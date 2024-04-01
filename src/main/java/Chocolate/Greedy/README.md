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

If you say that can be solved with a greedy algorithm

i. Identify the greedy choice.
Siempre intentar hacer la pieza más grande posible sin exceder la longitud restante de la barra de chocolate.

ii. Explain the optimal substructure.
Para maximizar el número de piezas, siempre debes intentar cortar la pieza más grande posible sin dejar una pieza 
que no se pueda dividir más. Esto significa que en cada paso, eliges la pieza más grande posible que se pueda cortar de
la barra de chocolate restante.

iv. What is the time complexity of your solution?

Es O(N), donde N es la longitud de la barra de chocolate. Esto se debe a que iteramos a través de la longitud de la
barra de chocolate una vez para encontrar el número máximo de piezas.