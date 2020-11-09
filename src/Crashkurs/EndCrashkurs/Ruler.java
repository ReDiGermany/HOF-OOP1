package EndCrashkurs;

/**
 * Frage 1:
 *
 * Schreiben Sie ein Java-Programm, das fünf verschiedene "Lineale" mit Unterteilungen ausgibt. Verwenden Sie String-Konkatenation: Lineal 2 verwendet Lineal 1; Lineal 3 verwendet Lineal 2 usw. Die Ausgabe soll wie folgt sein:
 *
 * Lin1 :: 1
 * Lin2 :: 1 2 1
 * Lin3 :: 1 2 1 3 1 2 1
 * Lin4 :: 1 2 1 3 1 2 1 4 1 2 1 3 1 2 1
 * Lin5 :: 1 2 1 3 1 2 1 4 1 2 1 3 1 2 1 5 1 2 1 3 1 2 1 4 1 2 1 3 1 2 1
 */
public class Ruler {
    public static void main(String[] args){
        ruler();
//        rulerStatic();
//        rulerTutor();
    }

    /**
     * Meine Lösung. Funktioniert und ist skalierbar.
     */
    static void ruler(){
        String t = "1 ";
        for(int i=1;i<=5;i++){
            System.out.println("Lin" + (i) + " :: " + t);
            t += (i+1) + " " + t;
        }
    }

    /**
     * Die wohl schlechteste Variante, obwohl sie durchaus funktioniert.
     */
    static void rulerStatic(){
        System.out.println("Lin1 :: 1");
        System.out.println("Lin2 :: 1 2 1");
        System.out.println("Lin3 :: 1 2 1 3 1 2 1");
        System.out.println("Lin4 :: 1 2 1 3 1 2 1 4 1 2 1 3 1 2 1");
        System.out.println("Lin5 :: 1 2 1 3 1 2 1 4 1 2 1 3 1 2 1 5 1 2 1 3 1 2 1 4 1 2 1 3 1 2 1");
    }

    /**
     * Lösung des Tutors.
     */
    static void rulerTutor(){
        String ruler1 = "1";
        String ruler2 = ruler1 + " 2 " + ruler1;
        String ruler3 = ruler2 + " 3 " + ruler2;
        String ruler4 = ruler3 + " 4 " + ruler3;
        String ruler5 = ruler4 + " 5 " + ruler4;
        System.out.println("Lin1 :: " + ruler1);
        System.out.println("Lin2 :: " + ruler2);
        System.out.println("Lin3 :: " + ruler3);
        System.out.println("Lin4 :: " + ruler4);
        System.out.println("Lin5 :: " + ruler5);
    }
}
