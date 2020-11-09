class Scratch {

    public static void main(String[] args) {

        String orig = "stanleys expeditionszug quer durch afrika wird von jedermann bewundert";
//        String orig = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
        char[] asArray = orig.toCharArray();

        rot13(asArray);
        String encoded = new String(asArray);
        System.out.println(encoded);

        rot13(asArray);
        encoded = new String(asArray);
        System.out.println(encoded);
        if(encoded.equals(orig)){
            System.out.println("Matched.");
        }
    }

    /**
     * Schiebt das Zeichen {ch} im Alphabet um {offset}
     * @param ch zeichen zum schieben
     * @param offset wert um den geschoben werden soll
     * @return geschobenes Zeichen
     */
    public static char shift(char ch,int offset){
        ch = shiftLowerCase(ch,offset);
//        ch = shiftUpperCase(ch,offset);
        return ch;
    }

    /**
     * Schiebt das Zeichen {ch} im kleinen Alphabet um {offset}
     * @param ch zeichen zum schieben
     * @param offset wert um den geschoben werden soll
     * @return geschobenes Zeichen
     */
    public static char shiftLowerCase(char ch,int offset){
        boolean check = ch >= 'a' && ch <= 'z';
        if( !check ) return ch;
        int n = ch + offset;
        if( n > 'z') n -= 26;
        return (char) n;
    }

    /**
     * Schiebt das Zeichen {ch} im großen Alphabet um {offset}
     * @param ch zeichen zum schieben
     * @param offset wert um den geschoben werden soll
     * @return geschobenes Zeichen
     */
    public static char shiftUpperCase(char ch,int offset){
        boolean check = ch >= 'A' && ch <= 'Z';
        if( !check ) return ch;
        int n = ch + offset;
        if( n > 'Z') n -= 26;
        return (char) n;
    }

    /**
     * Schiebt alle Zeichen eines char arrays um 13 Zeichen durch das Array
     * @param in eingabe Zeichenkette
     */
    public static void rot13(char[] in){
        for(int i=0;i<in.length;i++){
            in[i] = shift(in[i],13);
        }
    }
}