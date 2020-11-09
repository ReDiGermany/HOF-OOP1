package Testate.Testat1;

public class SortCountMachine {

    public static void main(String[] args) {
        int max = 0;
        if(args.length>0){
            try {
                max = Integer.parseInt(args[0]);
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.err.println("Wrong Number Format! Abort.");
                return;
            }
        }else{
            System.err.println("No Number specified. Using 1_000_001 as your example used it.");
            max = 1_000_001;
//            max = (int) (Math.random()*Integer.MAX_VALUE);
        }
        if(max<0){
//            https://github.com/ReDiGermany/HOF-OOP1.git
            System.err.println("Negative numbers will always result in 0! Abort.");
            return;
        }
        System.err.format("max = %s\n\n",max);
        startSync(max);
    }

    public static void startSync(int max){
//        System.out.println("Calculating synchronius");
        int even = 0;
        int odd = 0;
        int prime = 0;
        int quad = 0;
        int power = 0;
        for (int i = 1; i < max; i++) {
            if (isEvenNumber(i)) even++;
            if (isOddNumber(i)) odd++;
            if (isPrimeNumber(i)) prime++;
            if (isQuadNumber(i)) quad++;
            if (isPowerOfTen(i)) power++;
        }
        System.out.format("Even numbers: %s\n" +
                "Odd numbers: %s\n" +
                "Prime numbers: %s\n" +
                "Quad numbers: %s\n" +
                "'Power of 10' numbers: %s\n", even, odd, prime, quad, power);
    }
    /**
     * Wenn n / 2 ohne Rest Teilbar ist, dann TRUE, sonst FALSE
     * @param n Zahl zum Überprüfen
     * @return True wenn n mod 2 = 0
     */
    public static boolean isEvenNumber(int n){
        return n%2==0;
    }

    /**
     * Wenn n / 2 nicht ohne Rest Teilbar ist, dann TRUE, sonst FALSE
     * @param n Zahl zum Überprüfen
     * @return True wenn n mod 2 nicht 0 ist
     */
    public static boolean isOddNumber(int n){
        return n%2!=0;
    }

    /**
     * Überprüft ob n eine Prim Zahl ist. Vorlage dafür war https://en.wikipedia.org/wiki/Primality_test#Simple_methods wie im Testat angegeben.
     * @param n Zahl zum Überprüfen
     * @return True wenn n prim ist
     */
    public static boolean isPrimeNumber(int n){
        if(n<1) return false; // <1 sind keine Prim Zahlen. Abbrechen!
        if(n==2) return true; // 2 ist eine Primzahl!
        if(isEvenNumber(n) || n%3==0) return false; // wenn n durch 2 oder durch 3 teilbar, abbrechen.
//        n = n/2;
//        n = (int)Math.sqrt(n);
        int i=3; // Wir beginnen bei 3, da wir 1, <1 und 2 schon einzeln abgefragt haben.
        while( Math.pow(i,2) <= n ) { // solange i^2 kleiner oder gleich n
            if (n % i == 0 || n % (i + 2) == 0) { // wenn n durch i teilbar oder n durch i+2 teilbar, abbrechen.
                return false;
            }
            i++;
        }
        /*
         * Wenn also n weder <1, noch 2, noch gerade oder durch 3 teilbar ist, überprüfe
         *   in der while schleife ob n durch i oder durch i+2 teilbar ist
         *   bis die Potenz von i gleich der zahl n ist.
         * Sollte alles korrekt sein, gebe true zurück.
         */
        return true;
    }

    /**
     * Überprüft ob die Wurzel von n - die abgerundete Zahl der Wurzel von n = 0 ist.
     * @param n Zahl zum Überprüfen
     * @return True wenn n quadratisch ist
     */
    public static boolean isQuadNumber(int n){
        double sqrt = Math.sqrt(n);
        return sqrt - Math.floor(sqrt) == 0;
    }

    /**
     * Überprüft ob n die 10te Potenz von einer Zahl ist.
     * @param n Zahl zum Überprüfen
     * @return True wenn n eine 10te Potenz ist.
     */
    public static boolean isPowerOfTen(int n){
        if(n==1) return false;
        return Math.log10(n)%1==0;
    }
}
