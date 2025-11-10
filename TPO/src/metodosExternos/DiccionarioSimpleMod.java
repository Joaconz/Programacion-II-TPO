package metodosExternos;

import tda.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;
import imple.Conjunto;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {
    private int[] claves;
    private int[] valores;
    private int[] mods;
    private int n;

    private void ensureCapacity() {
        if (claves == null) {
            claves = new int[100];
            valores = new int[100];
            mods = new int[100];
            return;
        }
        if (n >= claves.length) {
            int newSize = claves.length * 2;
            int[] nc = new int[newSize];
            int[] nv = new int[newSize];
            int[] nm = new int[newSize];
            for (int i = 0; i < n; i++) {
                nc[i] = claves[i];
                nv[i] = valores[i];
                nm[i] = mods[i];
            }
            claves = nc;
            valores = nv;
            mods = nm;
        }
    }

    @Override
    public void inicializarDiccionario() {
        claves = new int[100];
        valores = new int[100];
        mods = new int[100];
        n = 0;
    }

    @Override
    public void agregar(int clave, int valor) {
        for (int i = 0; i < n; i++) {
            if (claves[i] == clave) {
                if (valores[i] != valor) {
                    valores[i] = valor;
                    mods[i] = mods[i] + 1;
                }
                return;
            }
        }
        ensureCapacity();
        claves[n] = clave;
        valores[n] = valor;
        mods[n] = 0;
        n++;
    }

    @Override
    public void eliminar(int clave) {
        for (int i = 0; i < n; i++) {
            if (claves[i] == clave) {
                claves[i] = claves[n - 1];
                valores[i] = valores[n - 1];
                mods[i] = mods[n - 1];
                n--;
                return;
            }
        }
    }

    @Override
    public int recuperar(int clave) {
        for (int i = 0; i < n; i++) {
            if (claves[i] == clave) return valores[i];
        }
        return 0; // suposición: devolver 0 si no existe
    }

    @Override
    public int recuperarMod(int clave) {
        for (int i = 0; i < n; i++) {
            if (claves[i] == clave) return mods[i];
        }
        return 0;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA c = new Conjunto();
        c.inicializarConjunto();
        for (int i = 0; i < n; i++) c.agregar(claves[i]);
        return c;
    }
}
