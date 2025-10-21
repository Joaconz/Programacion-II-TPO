package metodosExternos;

import tda.PilaTDA;
import tda.ConjuntoTDA;
import imple.Pila;
import imple.Conjunto;

public class ElementosRepetidosPila {

    public static ConjuntoTDA resolver(PilaTDA pila) {
        PilaTDA aux = new Pila();
        aux.inicializarPila();

        ConjuntoTDA vistos = new Conjunto();
        vistos.inicializarConjunto();

        ConjuntoTDA repetidos = new Conjunto();
        repetidos.inicializarConjunto();

        while (!pila.pilaVacia()) {
            int x = pila.tope();
            pila.desapilar();

            if (vistos.pertenece(x)) {
                repetidos.agregar(x);
            } else {
                vistos.agregar(x);
            }

            aux.apilar(x);
        }

        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        return repetidos;
    }
}
