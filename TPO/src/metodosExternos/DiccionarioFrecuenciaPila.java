package metodosExternos;

import tda.PilaTDA;
import tda.DiccionarioSimpleTDA;
import imple.Pila;
import imple.DiccionarioSimple;

public class DiccionarioFrecuenciaPila {

    public static DiccionarioSimpleTDA resolver(PilaTDA pila) {
        PilaTDA aux = new Pila();
        aux.inicializarPila();

        DiccionarioSimpleTDA dic = new DiccionarioSimple();
        dic.inicializarDiccionario();

        while (!pila.pilaVacia()) {
            int x = pila.tope();
            pila.desapilar();

            int freq = dic.recuperar(x);
            dic.agregar(x, freq + 1);

            aux.apilar(x);
        }

        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        return dic;
    }
}
