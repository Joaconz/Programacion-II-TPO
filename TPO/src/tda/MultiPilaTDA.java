package tda;

public interface MultiPilaTDA extends PilaTDA {
    public void apilar(PilaTDA valores);
    public void desapilar(PilaTDA valores);
    public PilaTDA tope(int cantidad);
    // los métodos de PilaTDA (inicializarPila, pilaVacia, apilar, desapilar, tope)
    // ya están disponibles por herencia
}
