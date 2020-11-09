package Readout11;

public class Positions {
    public static void main(String[] args) {
        positions('f',"Donaudampfschifffahrtsgesellschaft");
    }

    /**
     * Loggt alle positionen vom Charakter {c} im String {s}
     * @param c
     * @param s
     */
    public static void positions(char c,String s){
        char[] sc = s.toCharArray();
        int counter = 0;
        for(int i=0;i<sc.length;i++){
            if(sc[i]==c){
                System.out.printf("%c @ index %d%n",c,i);
                counter++;
            }
        }
        System.out.printf("Found %d times the character %c%n",counter,c);
    }
}
