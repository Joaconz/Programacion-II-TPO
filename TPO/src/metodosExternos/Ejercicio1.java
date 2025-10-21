package metodosExternos;

import tda.PilaTDA;
import imple.Pila;

public class Ejercicio1 {
    public static void resolver(PilaTDA pila) {
        PilaTDA aux1 = new Pila();
        aux1.inicializarPila();

        PilaTDA aux2 = new Pila();
        aux2.inicializarPila();

        while (!pila.pilaVacia()) {
            aux1.apilar(pila.tope());
            pila.desapilar();
        }

        while (!aux1.pilaVacia()) {
            aux2.apilar(aux1.tope());
            aux1.desapilar();
        }

        while (!aux2.pilaVacia()) {
            pila.apilar(aux2.tope());
            aux2.desapilar();
        }
    }
}
