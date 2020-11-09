package EndCrashkurs;

/**
 * Frage 2:
 *
 * Math.random()
 * ... liefert eine Fließkommazahl x im Intervall 0 ≤ x < 1. Schrieben Sie eine Methode, die eine Zufallszahl zwischen 0 und k leiner 100 am Bildschirm ausgibt und feststellt, ob die Zahl ≤ 50 oder > 50 ist.
 *
 * Beispiele:
 *
 * 42.504608673307295 <= 50
 * 56.1425908325579 > 50
 * Wichtig: Die Ausgabe nicht mit ' System.out.println("xyz") ' sondern mit 'return "xyz" ' damit die automatischen Tests funktionieren können.
 *
 * return gibt streng genommen nichts aus, sondern liefert dem Code, der die Funktion aufruft, das Ergebnis zurück. In diesem Fall sind dies die Testfälle.
 *
 * //your solution
 * double rand = ???
 * String result = if ....??
 * return result;
 *
 */
public class CheckFifty {
    public static void main(String[] args){
        System.out.println(gamble());
    }

    /**
     * Auch hier wieder: mit Ternärem operator.
     * @return
     */
    static String gamble(){
        double rand = Math.random()*100;
        String result = rand+" ";
        if ( rand<=50 ) {
            result += "<= 50";
        } else {
            result += "> 50";
        }
        return result;
    }

    /**
     * Auch hier wieder: mit Ternärem operator.
     * @return
     */
    static String gambleTernaer(){
        double rand = Math.random()*100;
        String result = rand + ( rand <= 50 ? " <= ":" > " ) + 50;
        return result;
    }

    /**
     * Lösung des Tutors
     */
    static String gambleTutor(){
        double rand = Math.random() * 100;
        if ( rand <= 50 ) {
            return ( rand + " <= 50" );
        } else {
            return ( rand + " > 50" );
        }
    }
}
