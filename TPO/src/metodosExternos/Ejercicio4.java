package metodosExternos;

import tda.ConjuntoTDA;
import imple.Conjunto;

public class Ejercicio4 {
    public static ConjuntoTDA resolver(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA inter = new Conjunto();
        inter.inicializarConjunto();

        ConjuntoTDA aux = new Conjunto();
        aux.inicializarConjunto();

        while (!a.conjuntoVacio()) {
            int x = a.elegir();
            a.sacar(x);
            if (b.pertenece(x)) {
                inter.agregar(x);
            }
            aux.agregar(x);
        }

        while (!aux.conjuntoVacio()) {
            int x = aux.elegir();
            aux.sacar(x);
            a.agregar(x);
        }

        return inter;
    }
}
