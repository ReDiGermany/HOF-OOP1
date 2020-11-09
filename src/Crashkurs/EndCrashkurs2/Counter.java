package EndCrashkurs2;

/**
 * Frage 2
 *
 * Aufgabe ist die Erzeugung eines neuen int-Arrays. Dabei sollen alle Felder nach einem bestimmten Muster mit Werten vorbelegt werden.
 *
 * Das Muster geht wie folgt:
 *
 * Der erste und zweite Wert des Arrays wird vorgegeben: int seed
 * Der seed gibt auch die Größe des Arrays vor: 3 * seed (daraus folgt auch: seed darf nicht negativ sein, das darf vorausgesetzt werden)
 * Der Wert jedes Feldes berechnet sich aus der Summe der beiden vorhergehenden (Ausnahme sind die bereits definierten Felder 0 und 1)
 * Zum Beispiel:
 *
 * Test	Resultat
 * print(test(3));
 * 3, 3, 6, 9, 15, 24, 39, 63, 102
 * print(test(1));
 * 1, 1, 2
 */
public class Counter {
    public static void main(String[] args){
        int[] test5 = test(5);
        int[] test3 = test(3);
        int[] test2 = test(2);
        int[] test1 = test(1);
        int[] testneg1 = test(-1);
    }
    public static int[] test(int seed){
        if(seed<1) return null;
        int[] ret = new int[seed*3];
        ret[0]=seed;
        ret[1]=seed;
        for(int i=2;i<ret.length;i++){
            ret[i]=ret[i-1]+ret[i-2];
        }
        return ret;
    }

    //test method, please ignore
    public static void print(int[] arr){
        String[] sarr = new String[arr.length];
        for(int i = 0; i < sarr.length;  i++){
            sarr[i] = arr[i]+"";
        }
        System.out.println(String.join(", ", sarr));
    }

    public int[] testTutor(int seed){
        int[] res = new int[3 * seed];
        res[0] = seed;
        res[1] = seed;

        for(int i = 2; i < res.length; i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res;
    }

}
