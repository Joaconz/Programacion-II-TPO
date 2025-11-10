//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Pruebas rápidas de los metodos externos ---");

        // Pila y Cola de ejemplo usando imple.Pila e imple.Cola
        imple.Pila p = new imple.Pila();
        p.inicializarPila();
        p.apilar(1);
        p.apilar(2);
        p.apilar(3);
        p.apilar(4);

        float pct = metodosExternos.PorcentajePares.resolver(p);
        System.out.println("Porcentaje pares (en %): " + pct);

        // Elementos repetidos en pila
        imple.Pila p2 = new imple.Pila();
        p2.inicializarPila();
        p2.apilar(1);
        p2.apilar(2);
        p2.apilar(3);
        p2.apilar(2);
        p2.apilar(4);
        p2.apilar(1);
        tda.ConjuntoTDA repetidos = metodosExternos.ElementosRepetidosPila.resolver(p2);
        System.out.print("Elementos repetidos en pila: ");
        while (!repetidos.conjuntoVacio()) {
            int x = repetidos.elegir();
            repetidos.sacar(x);
            System.out.print(x + " ");
        }
        System.out.println();

        // Cola sin repetidos
        imple.Cola c = new imple.Cola();
        c.inicializarCola();
        c.acolar(5);
        c.acolar(6);
        c.acolar(5);
        c.acolar(7);
        c.acolar(6);
        tda.ColaTDA colaSinRep = metodosExternos.ColaSinRepetidos.resolver(c);
        System.out.print("Cola sin repetidos: ");
        while (!colaSinRep.colaVacia()) {
            System.out.print(colaSinRep.primero() + " ");
            colaSinRep.desacolar();
        }
        System.out.println();

        // Elementos comunes entre pila y cola
        imple.Pila p3 = new imple.Pila(); p3.inicializarPila(); p3.apilar(10); p3.apilar(20); p3.apilar(30);
        imple.Cola c2 = new imple.Cola(); c2.inicializarCola(); c2.acolar(5); c2.acolar(20); c2.acolar(30);
        tda.ConjuntoTDA comunes = metodosExternos.ElementosComunesPilaCola.resolver(p3, c2);
        System.out.print("Elementos comunes pila/cola: ");
        while (!comunes.conjuntoVacio()) {
            int x = comunes.elegir(); comunes.sacar(x); System.out.print(x + " ");
        }
        System.out.println();

        // Diccionario de frecuencias desde pila
        imple.Pila p4 = new imple.Pila(); p4.inicializarPila(); p4.apilar(2); p4.apilar(3); p4.apilar(2); p4.apilar(5); p4.apilar(3);
        tda.DiccionarioSimpleTDA dic = metodosExternos.DiccionarioFrecuenciaPila.resolver(p4);
        System.out.println("Diccionario de frecuencias desde pila:");
        tda.ConjuntoTDA claves = dic.claves();
        while (!claves.conjuntoVacio()) {
            int k = claves.elegir(); claves.sacar(k);
            System.out.println("clave=" + k + " -> freq=" + dic.recuperar(k));
        }

        // ConjuntoEspecial
        metodosExternos.ConjuntoEspecial ce = new metodosExternos.ConjuntoEspecial();
        ce.inicializarConjunto();
        System.out.println("ConjuntoEspecial agregar 1: error=" + ce.agregarRespuesta(1).error);
        System.out.println("ConjuntoEspecial agregar 1 (otra vez): error=" + ce.agregarRespuesta(1).error);
        tda.ConjuntoEspecialTDA.Respuesta r = ce.elegirRespuesta();
        System.out.println("ConjuntoEspecial elegir: rta=" + r.rta + " error=" + r.error);
        System.out.println("ConjuntoEspecial sacar 1: error=" + ce.sacarRespuesta(1).error);
        System.out.println("ConjuntoEspecial sacar 1 otra vez: error=" + ce.sacarRespuesta(1).error);

        // ConjuntoMamushka
        metodosExternos.ConjuntoMamushka cm = new metodosExternos.ConjuntoMamushka(); cm.inicializar();
        cm.guardar(7); cm.guardar(7); cm.guardar(8);
        System.out.println("ConjuntoMamushka perteneceCant 7: " + cm.perteneceCant(7));
        cm.sacar(7);
        System.out.println("ConjuntoMamushka despues de sacar 7: " + cm.perteneceCant(7));

        // MultiPila
        metodosExternos.MultiPila mp = new metodosExternos.MultiPila(); mp.inicializarPila();
        imple.Pila valores = new imple.Pila(); valores.inicializarPila(); valores.apilar(1); valores.apilar(9);
        mp.apilar(valores);
        tda.PilaTDA top2 = mp.tope(2);
        System.out.print("MultiPila tope(2): ");
        while (!top2.pilaVacia()) { System.out.print(top2.tope() + " "); top2.desapilar(); }
        System.out.println();

        // DiccionarioSimpleMod
        metodosExternos.DiccionarioSimpleMod dmod = new metodosExternos.DiccionarioSimpleMod(); dmod.inicializarDiccionario();
        dmod.agregar(1,10); dmod.agregar(1,20); dmod.agregar(2,5);
        System.out.println("DiccionarioMod recuperar(1)=" + dmod.recuperar(1) + " mods=" + dmod.recuperarMod(1));

        // DiccionarioSimpleColaPrioridad
        metodosExternos.DiccionarioSimpleColaPrioridad dcp = new metodosExternos.DiccionarioSimpleColaPrioridad(); dcp.inicializarDiccionario();
        dcp.agregar(3,30); dcp.agregar(4,40); dcp.agregar(3,33);
        tda.ConjuntoTDA claves2 = dcp.claves();
        System.out.print("DiccionarioColaPrioridad claves: ");
        while (!claves2.conjuntoVacio()) { int k = claves2.elegir(); claves2.sacar(k); System.out.print(k + " "); }
        System.out.println();

        System.out.println("--- Fin pruebas ---");
    }
}