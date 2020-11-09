package EndCrashkurs;

/**
 * Frage 3:
 *
 * Schreiben Sie eine Methode, die zwei Integer übernimmt und diese für Operationen mit den vier Grundrechenarten und
 *  Modulo verwendet. Es sollen sowohl die Rechnungen als auch die Ergebnisse ausgegeben werden.
 *
 * Beispiel: calc(42, 8);
 *
 * 42 + 8 = 50
 * 42 - 8 = 34
 * 42 * 8 = 336
 * 42 / 8 = 5
 * 42 % 8 = 2
 * (Ausgabe der Rechenarten bitte in der Reihenfolge, Leerzeichen beachten!)
 */
public class Calc {
    public static void main(String[] args){
        calc(42,8);
        calc(8,42);
        calc(56,7);
        calc(-42,6);
    }

    /**
     * Meine lösung. Ich bin auf nichts "besseres" gekommen.
     * Alle anderen Lösungen werden super lang und haben keinen Vorteil.
     */
    static void calc(int a,int b){
        System.out.println( a + " + " + b + " = " + (a + b) );
        System.out.println( a + " - " + b + " = " + (a - b) );
        System.out.println( a + " * " + b + " = " + (a * b) );
        System.out.println( a + " / " + b + " = " + (a / b) );
        System.out.println( a + " % " + b + " = " + (a % b) );
    }

    /**
     * Lösung des Tutors
     */
    void calcTutor(int a, int b) {
        int sum = a+ b;
        int diff = a - b;
        int prod = a * b;
        int quot = a / b;
        int rem = a % b;
        System.out.println(a + " + " + b + " = " + sum);
        System.out.println(a + " - " + b + " = " + diff);
        System.out.println(a + " * " + b + " = " + prod);
        System.out.println(a + " / " + b + " = " + quot);
        System.out.println(a + " % " + b + " = " + rem);
    }
}
