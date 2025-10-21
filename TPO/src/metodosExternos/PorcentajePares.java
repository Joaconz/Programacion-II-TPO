package metodosExternos;

import tda.PilaTDA;
import imple.Pila;

public class PorcentajePares {

    public static float resolver(PilaTDA pila) {
        if (pila.pilaVacia()) return 0f;

        PilaTDA aux = new Pila();
        aux.inicializarPila();

        int total = 0, pares = 0;

        while (!pila.pilaVacia()) {
            int x = pila.tope();
            pila.desapilar();
            aux.apilar(x);
            total++;
            if (x % 2 == 0) pares++;
        }

        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        return (float) pares * 100 / total;
    }
}
