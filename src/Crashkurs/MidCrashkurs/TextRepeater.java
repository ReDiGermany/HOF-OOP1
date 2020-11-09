package MidCrashkurs;

/**
 * Frage 2:
 *
 * Die Methode 'test' soll den String 'text' 'times'-mal ausgeben, immer in einer neuen Zeile.
 *
 * Beispiele:
 *
 * times(5, "Hallo") =>
 *
 * Hallo
 * Hallo
 * Hallo
 * Hallo
 * Hallo
 * times(0, "Hallo") =>
 *
 * times(2, "Ahoi") =>
 *
 * Ahoi
 * Ahoi
 */
public class TextRepeater {
    public static void main(String[] args){
        times(5,"Hallo");
        times(0,"Hallo");
        times(2,"Ahoi");
    }

    /**
     * Die (für mich) einzig richtige Methode.
     */
    public static void times(int times, String text){
        for( int i = 0; i < times; i++ ){
            System.out.println(text);
        }
    }

    /**
     * Eine weiter Möglichkeit, den Text in eine Variable zu schreiben, und diese dann auszugeben.
     */
    public static void timesConcat(int times, String text){
        String out = "";
        for( int i = 0; i < times; i++ ){
            out += text+"\n";
        }
        System.out.println(out);
    }

    /**
     * Das gleiche via Stringbuilder
     */
    public static void timesConcatViaStringbuilder(int times, String text){
        StringBuilder out = new StringBuilder();
        for( int i = 0; i < times; i++ ){
            out.append(text).append("\n");
        }
        System.out.println(out);
    }

    /**
     * Lösung 1:1 vom Tutor kopiert.
     */
    public static void timesRecursive(int times, String text){
        if(times <= 0) return;
        else {
            System.out.println(text);
            times(times-1, text);
        }
    }
}
