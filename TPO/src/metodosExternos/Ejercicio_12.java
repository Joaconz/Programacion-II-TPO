/*
Ejercicio 12 - Suma de elementos impares en ABB

Estrategia:
Recorrer el árbol en forma recursiva y acumular los valores impares.
Complejidad: Lineal.
*/

package metodosExternos;

import tda.*;

public class Ejercicio_12 {
    public int SumarImparesABB(ABB abb) {
        return sumarImparesRec(abb);
    }

    private int sumarImparesRec(ABB abb) {
        if (abb.ArbolVacio()) return 0;

        int sumaIzq = sumarImparesRec(abb.HijoIzq());
        int sumaDer = sumarImparesRec(abb.HijoDer());
        int valor = abb.Raiz();

        return (valor % 2 != 0 ? valor : 0) + sumaIzq + sumaDer;
    }
}