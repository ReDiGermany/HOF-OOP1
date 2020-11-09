package Readout6;

public class MinMax {

    /**
     * Prüft und loggt das Resultat.
     *
     * @param c der Charakter, der geprüft werden soll.
     */
    public static void print(char c) {
        double[] out = minMax(c);
        if (out != null && out.length == 2) {
            System.out.println(c + ": " + out[0] + " ; " + out[1]);
        }
    }

    /**
     * Start Methode. Checkt hier automatisch jede Möglichkeit.
     *
     * @param args
     */
    public static void main(String[] args) {
        char[] testing = new char[]{'d', 'i', 'l', 's', 'f', 'b', 'c', 'y'};
        for (int i = 0; i < testing.length; i++)
            print(testing[i]);
    }

    /**
     * Gibt die minimalen und maximalen werte vom {char} zurück.
     * Mögliche werte sind: 'd', 'i', 'l', 's', 'f', 'b', 'c'
     *
     * @param c
     * @return
     */
    public static double[] minMax(char c) {
        if (c == 'd') {
            return new double[]{Double.MIN_VALUE, Double.MAX_VALUE};
        } else if (c == 'i') {
            return new double[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        } else if (c == 'l') {
            return new double[]{Long.MIN_VALUE, Long.MAX_VALUE};
        } else if (c == 's') {
            return new double[]{Short.MIN_VALUE, Short.MAX_VALUE};
        } else if (c == 'f') {
            return new double[]{Float.MIN_VALUE, Float.MAX_VALUE};
        } else if (c == 'b') {
            return new double[]{Byte.MIN_VALUE, Byte.MAX_VALUE};
        } else if (c == 'c') {
            return new double[]{Character.MIN_VALUE, Character.MAX_VALUE};
        } else {
            System.out.println("Falsches Format: " + c);
            return null;
        }
    }
}
