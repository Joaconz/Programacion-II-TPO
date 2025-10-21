package metodosExternos;

import tda.PilaTDA;
import tda.ColaTDA;
import tda.ConjuntoTDA;
import imple.Pila;
import imple.Cola;
import imple.Conjunto;

public class ElementosComunesPilaCola {

    public static ConjuntoTDA resolver(PilaTDA pila, ColaTDA cola) {
        PilaTDA auxP = new Pila();
        auxP.inicializarPila();

        ColaTDA auxC = new Cola();
        auxC.inicializarCola();

        ConjuntoTDA vistos = new Conjunto();
        vistos.inicializarConjunto();

        ConjuntoTDA comunes = new Conjunto();
        comunes.inicializarConjunto();

        while (!pila.pilaVacia()) {
            int x = pila.tope();
            pila.desapilar();
            auxP.apilar(x);
            vistos.agregar(x);
        }

        while (!auxP.pilaVacia()) {
            pila.apilar(auxP.tope());
            auxP.desapilar();
        }

        while (!cola.colaVacia()) {
            int x = cola.primero();
            cola.desacolar();

            if (vistos.pertenece(x)) {
                comunes.agregar(x);
            }

            auxC.acolar(x);
        }

        while (!auxC.colaVacia()) {
            cola.acolar(auxC.primero());
            auxC.desacolar();
        }

        return comunes;
    }
}
