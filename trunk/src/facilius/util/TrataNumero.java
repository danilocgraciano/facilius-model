package facilius.util;

/**
 *
 * @author Graciano
 */
public class TrataNumero {

    public static double arredondar(double n) {
        int x = 2; //numeros depois da virgula.
        x = (int) Math.pow(10, x);
        double N = (int) (n * x);
        N = (double) (N / x);
        return N;
    }
}
