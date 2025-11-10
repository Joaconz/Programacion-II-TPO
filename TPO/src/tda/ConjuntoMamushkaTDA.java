package tda;

public interface ConjuntoMamushkaTDA extends ConjuntoTDA {
    void inicializar();
    void guardar(int dato); // agrega una acepción
    void sacar(int dato); // elimina una acepción
    int elegir();
    int perteneceCant(int dato);
    boolean estaVacio();
}
