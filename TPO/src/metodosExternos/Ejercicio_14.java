/*
Ejercicio 14 - Vértices puente entre p y q en GrafoTDA

Estrategia:
1. Para cada vértice v ≠ p,q:
   - Copiar el grafo sin v.
   - Verificar si hay camino entre p y q.
   - Si no hay, v es puente.
Complejidad: Cuadratica.
*/

package metodosExternos;

import tda.*;
import implementaciones.*;


public class Ejercicio_14 {
    public ConjuntoTDA VerticesPuente(GrafoTDA grafo, int p, int q) {
        ConjuntoTDA resultado = new Conjunto();
        resultado.InicializarConjunto();

        ConjuntoTDA vertices = grafo.Vertices();
        ConjuntoTDA copiaVertices = Clonar(vertices);

        while (!copiaVertices.ConjuntoVacio()) {
            int v = copiaVertices.Elegir();
            copiaVertices.Sacar(v);

            if (v != p && v != q) {
                GrafoTDA copia = CopiarSinVertice(grafo, v);
                if (!HayCamino(copia, p, q)) {
                    resultado.Agregar(v);
                }
            }
        }

        return resultado;
    }

    private GrafoTDA CopiarSinVertice(GrafoTDA original, int excluido) {
        GrafoTDA copia = new Grafo();
        copia.InicializarGrafo();

        ConjuntoTDA vertices = Clonar(original.Vertices());
        while (!vertices.ConjuntoVacio()) {
            int v = vertices.Elegir();
            vertices.Sacar(v);
            if (v != excluido) copia.AgregarVertice(v);
        }

        vertices = Clonar(original.Vertices());
        while (!vertices.ConjuntoVacio()) {
            int v = vertices.Elegir();
            vertices.Sacar(v);
            if (v != excluido) {
                ConjuntoTDA ady = Clonar(original.Adyacentes(v));
                while (!ady.ConjuntoVacio()) {
                    int w = ady.Elegir();
                    ady.Sacar(w);
                    if (w != excluido) copia.AgregarArista(v, w, 1);
                }
            }
        }

        return copia;
    }

    private boolean HayCamino(GrafoTDA grafo, int p, int q) {
        ColaTDA cola = new Cola();
        cola.InicializarCola();
        cola.Acolar(p);

        ConjuntoTDA visitados = new Conjunto();
        visitados.InicializarConjunto();
        visitados.Agregar(p);

        while (!cola.ColaVacia()) {
            int actual = cola.Primero();
            cola.Desacolar();

            if (actual == q) return true;

            ConjuntoTDA ady = Clonar(grafo.Adyacentes(actual));
            while (!ady.ConjuntoVacio()) {
                int vecino = ady.Elegir();
                ady.Sacar(vecino);
                if (!visitados.Pertenece(vecino)) {
                    visitados.Agregar(vecino);
                    cola.Acolar(vecino);
                }
            }
        }

        return false;
    }

    private ConjuntoTDA Clonar(ConjuntoTDA original) {
        ConjuntoTDA copia = new Conjunto();
        copia.InicializarConjunto();

        ConjuntoTDA temp = new Conjunto();
        temp.InicializarConjunto();

        while (!original.ConjuntoVacio()) {
            int x = original.Elegir();
            original.Sacar(x);
            copia.Agregar(x);
            temp.Agregar(x);
        }

        while (!temp.ConjuntoVacio()) {
            int x = temp.Elegir();
            temp.Sacar(x);
            original.Agregar(x);
        }

        return copia;
    }
}

