/*
Ejercicio 15 - Grado de vértice en GrafoTDA

Estrategia:
1. Contar aristas que salen de v.
2. Contar aristas que llegan a v.
3. Restar: salientes - entrantes.
Complejidad: Lineal.
*/

package metodosExternos;

import tda.*;

public class Ejercicio_15 {
    public int GradoVertice(GrafoTDA grafo, int v) {
        int salientes = 0;
        int entrantes = 0;

        ConjuntoTDA adyacentes = grafo.Adyacentes(v);
        while (!adyacentes.ConjuntoVacio()) {
            int destino = adyacentes.Elegir();
            adyacentes.Sacar(destino);
            salientes++;
        }

        ConjuntoTDA vertices = grafo.Vertices();
        while (!vertices.ConjuntoVacio()) {
            int origen = vertices.Elegir();
            vertices.Sacar(origen);

            if (origen != v) {
                ConjuntoTDA ady = grafo.Adyacentes(origen);
                while (!ady.ConjuntoVacio()) {
                    int destino = ady.Elegir();
                    ady.Sacar(destino);
                    if (destino == v) entrantes++;
                }
            }
        }

        return salientes - entrantes;
    }
}