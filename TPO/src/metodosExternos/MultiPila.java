package metodosExternos;

import tda.MultiPilaTDA;
import tda.PilaTDA;
import imple.Pila;

public class MultiPila implements MultiPilaTDA {
    private PilaTDA impl;

    @Override
    public void inicializarPila() {
        impl = new Pila();
        impl.inicializarPila();
    }

    public void apilar(int i) {

    }

    @Override
    public void desapilar() {

    }

    @Override
    public int tope() {
        return 0;
    }

    @Override
    public boolean pilaVacia() {
        return impl.pilaVacia();
    }

    @Override
    public void apilar(PilaTDA valores) {
        // Queremos colocar la pila "valores" sobre la multipila, preservando su orden
        // Si valores: (tope) v1 - v2 - ... - vn
        // Debemos obtener v1..vn y apilarlos en ese orden sobre impl
        PilaTDA aux = new Pila();
        aux.inicializarPila();

        while (!valores.pilaVacia()) {
            aux.apilar(valores.tope());
            valores.desapilar();
        }

        // ahora aux tiene en su tope el fondo de valores; para no destruir "valores" original
        // lo reconstruimos en "valores" y simultáneamente apilamos en impl
        while (!aux.pilaVacia()) {
            int x = aux.tope();
            aux.desapilar();
            valores.apilar(x);
            impl.apilar(x);
        }
    }

    @Override
    public void desapilar(PilaTDA valores) {
        // Debemos chequear que el tope de impl coincida con la secuencia de valores
        // Para esto comparamos elemento a elemento sin destruir impl permanentemente
        PilaTDA aux = new Pila();
        aux.inicializarPila();

        PilaTDA temp = new Pila();
        temp.inicializarPila();

        boolean coincide = true;

        // Copiamos la secuencia de valores en temp para no modificar valores
        while (!valores.pilaVacia()) {
            temp.apilar(valores.tope());
            valores.desapilar();
        }
        while (!temp.pilaVacia()) {
            valores.apilar(temp.tope());
            temp.desapilar();
        }

        // Comparamos
        while (!valores.pilaVacia()) {
            if (impl.pilaVacia()) { coincide = false; break; }
            int v = valores.tope();
            int t = impl.tope();
            if (v != t) { coincide = false; break; }
            aux.apilar(impl.tope());
            impl.desapilar();
            valores.desapilar();
        }

        if (!coincide) {
            // restaurar impl: los elementos en aux están en orden desde tope hacia abajo
            while (!aux.pilaVacia()) {
                impl.apilar(aux.tope());
                aux.desapilar();
            }
            return;
        }

        // Si coincide, ya hemos desapilado los elementos de impl en aux; debemos dejar impl ya con la secuencia removida
        // No restauremos, simplemente limpiamos aux
        while (!aux.pilaVacia()) aux.desapilar();
    }

    @Override
    public PilaTDA tope(int cantidad) {
        PilaTDA resultado = new Pila();
        resultado.inicializarPila();

        PilaTDA aux = new Pila();
        aux.inicializarPila();

        int cont = 0;
        while (!impl.pilaVacia() && cont < cantidad) {
            int x = impl.tope();
            impl.desapilar();
            aux.apilar(x);
            cont++;
        }

        // aux contiene los primeros cont elementos (tope hacia abajo)
        while (!aux.pilaVacia()) {
            int x = aux.tope();
            aux.desapilar();
            resultado.apilar(x);
            impl.apilar(x);
        }

        return resultado;
    }
}

