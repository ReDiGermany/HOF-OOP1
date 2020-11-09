package EndCrashkurs;

/**
 * Frage 5:
 *
 * Schreiben Sie eine Methode, die eine Ganzzahl übernimmt und Potenzen in folgender Weise ausgibt:
 */
public class Power {
    public static void main(String[] args) {
        powersOfTwo(7);
        powersOfTwo(1);
        powersOfTwo(0);
        powersOfTwo(-1);
        powersOfTwo(4);
    }

    /**
     * Meine (und die für mich einfachste) Lösung.
     */
    static void powersOfTwo(int aNum) {
        for ( int i=0; i<=aNum; i++ ) {
            System.out.println( "2^" + i + " = " + (int)Math.pow(2,i) );
        }
    }

    /**
     * Meine (und die für mich einfachste) Lösung mit eigenem Power Algorithmus.
     */
    static void powersOfTwoOwnPow(int aNum) {
        for ( int i=0; i<=aNum; i++ ) {
            System.out.println( "2^" + i + " = " + pow(2,i) );
        }
    }

    /**
     * Calculates the power of a^b
     * @param a number to power
     * @param b number of power
     * @return a^b
     */
    static int pow(int a,int b) {
        int ret = 1;
        for ( int i=0; i<b; i++ ) {
            ret *= a;
        }
        return ret;
    }

    /**
     * Lösung des Tutors.
     */
    void powersOfTwoTutor(int aNum) {
        int i = 0;
        while (i <= aNum) {
            System.out.println("2^" + i + " = " + (int) Math.pow(2, i));
            i++;
        }
    }
}
