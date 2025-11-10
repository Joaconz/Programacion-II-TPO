package metodosExternos;

import tda.ConjuntoMamushkaTDA;

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

    @Override
    public void guardar(int dato) {
        // buscar
        for (int i = 0; i < n; i++) {
            if (elems[i] == dato) {
                counts[i] = counts[i] + 1;
                return;
            }
        }
        // insertar nuevo
        ensureCapacity();
        elems[n] = dato;
        counts[n] = 1;
        n++;
    }

    @Override
    public void sacar(int dato) {
        for (int i = 0; i < n; i++) {
            if (elems[i] == dato) {
                counts[i] = counts[i] - 1;
                if (counts[i] <= 0) {
                    // eliminar elemento: reemplazar con el último
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
        if (n == 0) return 0; // elección arbitraria cuando está vacío
        return elems[0];
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
