package metodosExternos;

import tda.ConjuntoEspecialTDA;
import tda.ConjuntoEspecialTDA.Respuesta;
import tda.ConjuntoTDA;
import imple.Conjunto;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {
    private ConjuntoTDA impl;

    @Override
    public void inicializarConjunto() {
        impl = new Conjunto();
        impl.inicializarConjunto();
    }

    @Override
    public Respuesta agregar(int valor) {
        Respuesta r = new Respuesta();
        if (impl.pertenece(valor)) {
            r.error = true;
            r.rta = 0;
        } else {
            impl.agregar(valor);
            r.error = false;
            r.rta = 0;
        }
        return r;
    }

    @Override
    public Respuesta sacar(int valor) {
        Respuesta r = new Respuesta();
        if (!impl.pertenece(valor)) {
            r.error = true;
            r.rta = 0;
        } else {
            impl.sacar(valor);
            r.error = false;
            r.rta = 0;
        }
        return r;
    }

    @Override
    public Respuesta elegir() {
        Respuesta r = new Respuesta();
        if (impl.conjuntoVacio()) {
            r.error = true;
            r.rta = 0;
        } else {
            r.error = false;
            r.rta = impl.elegir();
        }
        return r;
    }

    @Override
    public boolean pertenece(int valor) {
        return impl.pertenece(valor);
    }

    @Override
    public boolean conjuntoVacio() {
        return impl.conjuntoVacio();
    }
}

