package MidCrashkurs;

/**
 * Frage 1:
 *
 * Implementieren Sie eine Methode, die eine positive Ganzzahl entgegennimmt und überprüft, ob diese gerade oder ungerade ist.
 * Je nach Fall wird der Text "<Zahl> ist ungerade" oder "<Zahl> ist gerade" auf der Konsole ausgegeben.
 *
 * Zum Beispiel:
 * Test	        Resultat
 * test(2);     2 ist gerade
 * test(3);     3 ist ungerade
 *
 */
public class EvenNumber {
    public static void main(String[] args){
        test(2);
        test(3);
        test(100);
        test(55);
        test(55);
    }

    /**
     * Diese Lösung erscheint mir am besten verständlich. Jedoch hat man damit mehr Schreibarbeit.
     */
    public static void test(int number){
        if ( number%2 == 0 ) {
            System.out.println( number + " ist gerade" );
        } else {
            System.out.println( number + " ist ungerade" );
        }
    }

    /**
     * Die kürzeste Variante mittels ternärem Operator.
     *
     * Vorteil: funktioniert und ist schön klein.
     * Nachteil: kann man nicht intuitiv lesen.
     */
    public static void testTernaer(int number){
        System.out.println( number + " ist " + ( number%2 == 0 ? "gerade" : "ungerade" ) );
    }

    /**
     * Weitere Möglichkeit, die eine Variable nutzt.
     */
    public static void testVariable(int number){
        String even = "";
        if ( number%2 == 0 ) {
            even = "gerade";
        } else {
            even = "ungerade";
        }
        System.out.println(number + " ist " + even);
    }

    /**
     * Weitere Möglichkeit, die eine Variable und den ternären Operator nutzt.
     */
    public static void testVariableTernaer(int number){
        String even = ( number%2 == 0 ) ? "gerade" : "ungerade";
        System.out.println(number + " ist " + even);
    }
}
