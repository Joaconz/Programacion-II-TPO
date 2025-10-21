package metodosExternos;

import tda.ColaTDA;
import imple.Cola;

public class Ejercicio2 {
    public static ColaTDA resolver(ColaTDA cola) {
        ColaTDA aux = new Cola();
        aux.inicializarCola();

        ColaTDA clon = new Cola();
        clon.inicializarCola();

        while (!cola.colaVacia()) {
            int x = cola.primero();
            cola.desacolar();
            clon.acolar(x);
            aux.acolar(x);
        }

        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }

        return clon;
    }
}
