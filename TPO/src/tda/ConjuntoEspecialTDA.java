package tda;

public interface ConjuntoEspecialTDA extends ConjuntoTDA {
    public class Respuesta {
        public boolean error;
        public int rta;
    }

    Respuesta agregarRespuesta(int valor);
    Respuesta sacarRespuesta(int valor);
    Respuesta elegirRespuesta();
}
