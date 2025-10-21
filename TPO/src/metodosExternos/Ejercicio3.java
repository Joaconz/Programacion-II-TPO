package metodosExternos;

import tda.ConjuntoTDA;
import imple.Conjunto;

public class Ejercicio3 {
    public static ConjuntoTDA resolver(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA union = new Conjunto();
        union.inicializarConjunto();

        ConjuntoTDA auxA = new Conjunto();
        auxA.inicializarConjunto();

        ConjuntoTDA auxB = new Conjunto();
        auxB.inicializarConjunto();

        while (!a.conjuntoVacio()) {
            int x = a.elegir();
            a.sacar(x);
            union.agregar(x);
            auxA.agregar(x);
        }

        while (!auxA.conjuntoVacio()) {
            int x = auxA.elegir();
            auxA.sacar(x);
            a.agregar(x);
        }

        while (!b.conjuntoVacio()) {
            int x = b.elegir();
            b.sacar(x);
            union.agregar(x);
            auxB.agregar(x);
        }

        while (!auxB.conjuntoVacio()) {
            int x = auxB.elegir();
            auxB.sacar(x);
            b.agregar(x);
        }

        return union;
    }
}
