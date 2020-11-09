package Readout11;

public class MultTable {
    public static void main(String[] args) {
        multTable(4,2);
        multTable(16,2);
        multTable(7,999);
    }

    /**
     * Loggt die Multiplikationstabelle von {a}*{b}
     * @param a
     * @param b
     */
    public static void multTable(int a,int b){
        int len = (int)Math.log10(a*b)+1;
        String template = "%"+(len+1)+"d"; // für printf
        for(int j=1;j<=b;j++) {
            for (int i = 1; i <= a; i++) {
//                System.out.printf(template,i*j);
                System.out.print(templateIfy(i*j,len));
            }
            System.out.println();
        }
    }

    /**
     * Eine alternative funktion statt dem printf
     * @param num
     * @param len
     * @return
     */
    public static String templateIfy(int num,int len){
        return (" ".repeat(len-(int)Math.log10(num)))+num;
    }
}
