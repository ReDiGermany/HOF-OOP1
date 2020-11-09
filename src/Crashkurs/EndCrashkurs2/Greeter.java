package EndCrashkurs2;

/**
 * Frage 1:
 *
 * Implementieren Sie eine Routine für die "internationale Begrüßung" von Anwendern.
 *
 * Dabei werden die jeweilige Sprache und der Vorname des Anwenders als Programm-Parameter übergeben.
 *
 * Im Rahmen dieser "CodeRunner"-Umgebung auf Moodle ist es nicht nötig eine Klasse zu erstellen und das compilierte Programm via Kommandozeile aufzurufen, der Code bleibt aber derselbe. Die für Sie nicht sichtbare main-Methode gibt die Programm-Parameter (String[] args) an die zu implementierende Methode weiter.
 *
 * Der Aufruf des Programms soll dann (das passiert für Sie im Hintergrund) so erfolgen:
 *
 * java Greeter de Thomas
 * Hallo Thomas
 * java Greeter en Thomas
 * Hello Thomas
 * java Greeter cz Eva
 * Ahoi Eva
 * java Greeter fr Heike
 * Salut Heike
 * Unterstützt werden die oben aufgeführten Sprachen (deutsch, englisch, tschechisch, französisch) mit dem jeweilig definierten "Kürzel". Der zweite Programm-Parameter ist der Vorname. Sie können davon ausgehen, dass die übergebenen Parameter immer gültig sind.
 *
 * Zum Beispiel:
 *
 * Test	Resultat
 * greeting(new String[]{"en", "World"});
 * Hello World
 *
 */
public class Greeter {
    public static void main(String[] args){
        greeting(new String[]{"en","World"});
        greeting(new String[]{"de","Thomas"});
        greeting(new String[]{"cz","Eva"});
        greeting(new String[]{"fr","Heike"});
    }

    /**
     * Lösung von sero583 @ discord
     */
    public static void greetingSero(String[] args) {
        String lang = args[0];
        String name = args[1];

        switch(lang) {
            case "cz":
                System.out.println("Ahoi " + name);
                break;
            case "de":
                System.out.println("Hallo " + name);
                break;
            case "en":
            default: // handle it like, nothing happened
                System.out.println("Hello " + name);
                break;
            case "fr":
                System.out.println("Salut " + name);
                break;
        }
    }

    /**
     * Meine Lösung. Checkt am ende "nur" nach cz und fr. Falls die Sprachvariable anders ist,
     *  wird per default die Englische Sprache gewählt.
     */
    public static void greeting(String[] args){

        String sprache = args[0];
        String name = args[1];
        if ("cz".equals(sprache)) {
            System.out.println("Ahoi " + name);

        } else if ("fr".equals(sprache)) {
            System.out.println("Salut " + name);

        } else if ("de".equals(sprache)) {
            System.out.println("Hallo " + name);

        } else {
            System.out.println("Hello " + name);

        }

    }
    public static void greeting2(String[] args) {
        java.util.Map<String,String> map = new java.util.HashMap<>();
        map.put("cz","Ahoi");
        map.put("fr","Salut");
        map.put("de","Hallo");
        map.put("en","Hello");
        if(map.containsKey(args[0])){
            System.out.println(map.get(args[0])+" "+args[1]);
        }
    }

    public static void greetingTutor(String[] args) {
        //your code goes here
        String lang = args[0];
        String res = "";
        if (lang.equals("de")) {
            res += "Hallo";
        } else if (lang.equals("cz")) {
            res += "Ahoi";
        } else if (lang.equals("fr")) {
            res += "Salut";
        } else if (lang.equals("en")) {
            res += "Hello";
        }
        System.out.println(res + " " + args[1]);
    }

}
