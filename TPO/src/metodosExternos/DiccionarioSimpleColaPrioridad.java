package metodosExternos;

import tda.DiccionarioSimpleTDA;
import tda.ConjuntoTDA;
import imple.ColaPrioridad;
import imple.Conjunto;

public class DiccionarioSimpleColaPrioridad implements DiccionarioSimpleTDA {
    private ColaPrioridad cola; // almacenaremos pares (clave as valor, valor as prioridad)

    @Override
    public void inicializarDiccionario() {
        cola = new ColaPrioridad();
        cola.inicializarCola();
    }

    @Override
    public void agregar(int clave, int valor) {
        ColaPrioridad aux = new ColaPrioridad();
        aux.inicializarCola();

        boolean encontrado = false;

        while (!cola.colaVacia()) {
            int k = cola.primero();
            int v = cola.prioridad();
            cola.desacolar();
            if (k == clave) {
                // reemplazamos el valor
                aux.acolarPrioridad(k, valor);
                encontrado = true;
            } else {
                aux.acolarPrioridad(k, v);
            }
        }

        // restaurar en cola original
        while (!aux.colaVacia()) {
            int k = aux.primero();
            int v = aux.prioridad();
            aux.desacolar();
            cola.acolarPrioridad(k, v);
        }

        if (!encontrado) {
            cola.acolarPrioridad(clave, valor);
        }
    }

    @Override
    public void eliminar(int clave) {
        ColaPrioridad aux = new ColaPrioridad();
        aux.inicializarCola();

        while (!cola.colaVacia()) {
            int k = cola.primero();
            int v = cola.prioridad();
            cola.desacolar();
            if (k != clave) aux.acolarPrioridad(k, v);
        }

        while (!aux.colaVacia()) {
            int k = aux.primero();
            int v = aux.prioridad();
            aux.desacolar();
            cola.acolarPrioridad(k, v);
        }
    }

    @Override
    public int recuperar(int clave) {
        ColaPrioridad aux = new ColaPrioridad();
        aux.inicializarCola();

        int res = 0;
        while (!cola.colaVacia()) {
            int k = cola.primero();
            int v = cola.prioridad();
            cola.desacolar();
            if (k == clave) res = v;
            aux.acolarPrioridad(k, v);
        }

        while (!aux.colaVacia()) {
            int k = aux.primero();
            int v = aux.prioridad();
            aux.desacolar();
            cola.acolarPrioridad(k, v);
        }

        return res;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA c = new Conjunto();
        c.inicializarConjunto();

        ColaPrioridad aux = new ColaPrioridad();
        aux.inicializarCola();

        while (!cola.colaVacia()) {
            int k = cola.primero();
            int v = cola.prioridad();
            cola.desacolar();
            c.agregar(k);
            aux.acolarPrioridad(k, v);
        }

        while (!aux.colaVacia()) {
            int k = aux.primero();
            int v = aux.prioridad();
            aux.desacolar();
            cola.acolarPrioridad(k, v);
        }

        return c;
    }
}
