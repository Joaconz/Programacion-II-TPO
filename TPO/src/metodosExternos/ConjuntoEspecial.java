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

    // implementamos la API tradicional heredada de ConjuntoTDA delegando en impl
    @Override
    public void agregar(int valor) {
        impl.agregar(valor);
    }

    @Override
    public void sacar(int valor) {
        impl.sacar(valor);
    }

    @Override
    public int elegir() {
        return impl.elegir();
    }

    @Override
    public boolean pertenece(int valor) {
        return impl.pertenece(valor);
    }

    @Override
    public boolean conjuntoVacio() {
        return impl.conjuntoVacio();
    }

    // Nuevos métodos que devuelven Respuesta
    @Override
    public Respuesta agregarRespuesta(int valor) {
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
    public Respuesta sacarRespuesta(int valor) {
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
    public Respuesta elegirRespuesta() {
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
}
