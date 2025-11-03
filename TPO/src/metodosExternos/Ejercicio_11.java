/*
Ejercicio 11 - DiccionarioMultipleTDA → ColaTDA sin repeticiones

Estrategia:
1. Recorrer todas las claves del diccionario.
2. Para cada clave, obtener sus valores y agregarlos a un ConjuntoTDA auxiliar.
3. Encolar cada valor único en una ColaTDA.

Complejidad: Lineal.
*/

package metodosExternos;
import tda.*;
import implementaciones.*;

public class Ejercicio_11 {
    public void ValoresSinRepeticion(DiccionarioMultipleTDA dic, ColaTDA resultado) {
        ConjuntoTDA claves = dic.Claves();

        ConjuntoTDA valoresUnicos = new Conjunto();
        valoresUnicos.InicializarConjunto();

        while (!claves.ConjuntoVacio()) {
            int clave = claves.Elegir();
            claves.Sacar(clave);

            ConjuntoTDA valores = dic.Recuperar(clave);
            while (!valores.ConjuntoVacio()) {
                int valor = valores.Elegir();
                valores.Sacar(valor);
                if (!valoresUnicos.Pertenece(valor)) {
                    valoresUnicos.Agregar(valor);
                }
            }
        }

        resultado.InicializarCola();
        while (!valoresUnicos.ConjuntoVacio()) {
            int valor = valoresUnicos.Elegir();
            valoresUnicos.Sacar(valor);
            resultado.Acolar(valor);
        }
    }
}