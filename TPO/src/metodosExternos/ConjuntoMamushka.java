package metodosExternos;

import tda.ConjuntoMamushkaTDA;
import tda.ConjuntoTDA;

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {
    private int[] elems;
    private int[] counts;
    private int n;

    private void ensureCapacity() {
        if (elems == null) {
            elems = new int[100];
            counts = new int[100];
            return;
        }
        if (n >= elems.length) {
            int newSize = elems.length * 2;
            int[] ne = new int[newSize];
            int[] nc = new int[newSize];
            for (int i = 0; i < n; i++) {
                ne[i] = elems[i];
                nc[i] = counts[i];
            }
            elems = ne;
            counts = nc;
        }
    }

    @Override
    public void inicializar() {
        elems = new int[100];
        counts = new int[100];
        n = 0;
    }

    // Métodos heredados de ConjuntoTDA
    @Override
    public void inicializarConjunto() {
        inicializar();
    }

    @Override
    public void agregar(int dato) {
        guardar(dato);
    }

    @Override
    public void sacar(int dato) {
        // sacrar una acepción
        for (int i = 0; i < n; i++) {
            if (elems[i] == dato) {
                counts[i] = counts[i] - 1;
                if (counts[i] <= 0) {
                    elems[i] = elems[n - 1];
                    counts[i] = counts[n - 1];
                    n--;
                }
                return;
            }
        }
    }

    @Override
    public int elegir() {
        if (n == 0) return 0;
        return elems[0];
    }

    @Override
    public boolean pertenece(int dato) {
        return perteneceCant(dato) > 0;
    }

    @Override
    public boolean conjuntoVacio() {
        return estaVacio();
    }

    // Métodos propios de ConjuntoMamushka
    @Override
    public void guardar(int dato) {
        for (int i = 0; i < n; i++) {
            if (elems[i] == dato) {
                counts[i] = counts[i] + 1;
                return;
            }
        }
        ensureCapacity();
        elems[n] = dato;
        counts[n] = 1;
        n++;
    }

    @Override
    public int perteneceCant(int dato) {
        for (int i = 0; i < n; i++) {
            if (elems[i] == dato) return counts[i];
        }
        return 0;
    }

    @Override
    public boolean estaVacio() {
        return n == 0;
    }
}
