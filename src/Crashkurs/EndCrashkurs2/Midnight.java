package EndCrashkurs2;

/**
 * Frage 3:
 *
 * Implementieren Sie eine Funktion zur Lösung quadratischer Gleichungen der Form
 *
 * ax2+bx+c=0
 *
 * Als Input fungieren analog die Variablen a, b und c mit dem Datentyp double.
 *
 * Zur Erinnerung, die aus der Schule bekannte "Mitternachtsformel":
 *
 * x1,2=−b±b2−4ac−−−−−−−√2a
 *
 * Die Rückgabe der Lösung erfolgt über ein double-Array, beachten Sie dabei folgende Konventionen:
 *
 * Gibt es keine Lösung wird eine null Referenz verwendet
 * return null;
 * Gibt es eine Lösung wird ein double-Array der Größe 1 verwendet
 * Gibt es zwei Lösungen wird ein double-Array der Größe 2 verwendet, wobei die kleinere der beiden Lösungen an der ersten Stelle [0] steht.
 *
 *
 * Hinweis: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#sqrt-double-
 */
public class Midnight {
    public static void main(String[] args) {
        result(quadSolve(2, 5, -3));    // soll sein -3.0 - 0.5
        result(quadSolve(2, 5, 0));     // soll sein: -2.5 - 0.0
        result(quadSolve(2, 0, 0));     // soll sein: -0.0
        result(quadSolve(10, 2, 3));    // soll sein: null
        result(quadSolve(1, -2, 1));    // soll sein: 1.0
    }
    public static double[] quadSolve(double a, double b, double c){
        //your code goes here
        double top = Math.sqrt((b*b)-(4*a*c));
        if(Double.isNaN(top)){
            return null; // Wenn die Wurzel NaN ist, fehler => return
        }
        double x1 = ((b*-1) + top)/(2*a);
        double x2 = ((b*-1) - top)/(2*a);
        if(Double.isNaN(x1) || Double.isNaN(x2)){
            return null; // Wenn x1 oder x2 NaN ist, fehler => return
        }
        if(x1==(x2*-1) || x1==x2){
            return new double[]{x2}; // Wenn x1 = -x2 ODER x1 == x2 => return x2
            /*
            Achtung! Diese Methode ist Unsicher! Hier "scheint" es zu funktionieren, aber im normalfall sollte man das
            resultat weiter validieren.
             */
        }

        // Resultat zurückgeben
        if(x1<x2){
            return new double[]{x1, x2};
        }else {
            return new double[]{x2, x1};
        }

        /*Tipps:2
         * double[] a = new double[2]; (Größe 2)
         * a[1] = 3.0; (Belegung des zweiten Feldes mit 3.0)
         * double[] b = new double(){ 2.9, 3.1 }; (Array in-line decleration, Größe 2 mit 2.9 und 3.1)
         */
    }

    public static double[] quadSolveCompact(double a, double b, double c){
        //your code goes here
        double top = Math.sqrt((b*b)-(4*a*c));
        if(Double.isNaN(top)) return null; // Wenn die Wurzel NaN ist, fehler => return

        double x1 = ((b*-1) + top)/(2*a);
        double x2 = ((b*-1) - top)/(2*a);

        if(Double.isNaN(x1) || Double.isNaN(x2)) return null; // Wenn x1 oder x2 NaN ist, fehler => return
        if(x1==(x2*-1) || x1==x2) return new double[]{x2}; // Wenn x1 = -x2 ODER x1 == x2 => return x2
            /* Achtung! Diese Methode ist Unsicher! Hier "scheint" es zu funktionieren, aber im normalfall sollte man das resultat weiter validieren. */

        // Resultat zurückgeben
        if(x1<x2) return new double[]{x1, x2};
        return new double[]{x2, x1};

        /*Tipps:2
         * double[] a = new double[2]; (Größe 2)
         * a[1] = 3.0; (Belegung des zweiten Feldes mit 3.0)
         * double[] b = new double(){ 2.9, 3.1 }; (Array in-line decleration, Größe 2 mit 2.9 und 3.1)
         */
    }

    //ignore this method, it is needed to drive the tests (hence: do not delete it!)
    public static void result(double[] arr){
        if(arr == null) System.out.println("null");
        else{
            System.out.print(arr[0]);
            if(arr.length > 1) System.out.print(" - "+arr[1]);
            System.out.println();
        }
    }

    public double[] quadSolveTutor(double a, double b, double c){
        //your code goes here

        double disc = b * b - 4 * a * c; //Diskriminante

        if(disc < 0) return null;
        else if(disc == 0.0){
            return new double[]{ -b / (2 * a) };
        } else { //disc is > 0.0
            disc = Math.sqrt(disc);
            double x1 = (-b + disc) / (2 * a);
            double x2 = (-b - disc) / (2 * a);
            if(x2 < x1) {
                double tmp = x2;
                x2 = x1;
                x1 = tmp;
            }
            return new double[]{x1, x2};
        }

        /*Tipps:
         * double[] a = new double[2]; (Größe 2)
         * a[1] = 3.0; (Belegung des zweiten Feldes mit 3.0)
         * double[] b = new double(){ 2.9, 3.1 }; (Array in-line decleration, Größe 2 mit 2.9 und 3.1)
         */
    }
}
