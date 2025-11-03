/*
Ejercicio 13 - Contar hojas pares en ABB

Estrategia:
Recorrer el árbol recursivamente. Si el nodo es hoja y su valor es par, contar.
Complejidad: Lineal.
*/

package metodosExternos;
import tda.*;

public class Ejercicio_13 {
    public int ContarHojasPares(ABB abb) {
        return contarHojasParesRec(abb);
    }

    private int contarHojasParesRec(ABB abb) {
        if (abb.ArbolVacio()) return 0;

        boolean esHoja = abb.HijoIzq().ArbolVacio() && abb.HijoDer().ArbolVacio();
        int valor = abb.Raiz();

        if (esHoja && valor % 2 == 0) return 1;

        return contarHojasParesRec(abb.HijoIzq()) + contarHojasParesRec(abb.HijoDer());
    }
}