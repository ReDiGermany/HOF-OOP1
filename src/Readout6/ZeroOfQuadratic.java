package Readout6;

public class ZeroOfQuadratic {
    public static void main(String[] args){
//        double[] doubles = parseInput("1.2x²+2.55x+8.8"); // No zero of the function
//        double[] doubles = parseInput("-1.2x²+2.55x+8.8"); // x1 = -1.8464928812792467; x2 = 3.971492881279247
        double[] doubles = parseInput("1x²+0x+0"); // x = -0.0

        zeroOfQuadratic(doubles[0],doubles[1],doubles[2]);
    }

    /**
     * Danke für die Challenge @andy1631 :D
     * Diese Methode formt eine Quadratische Gleichung als String in ein Double Array um.
     * @param inp
     * @return
     */
    public static double[] parseInput(String inp){
        char[] test = inp.toCharArray();
        String[] strings = new String[]{"","",""};
        int step = 0;
        for (char c : test) {
            if (c == '+') {
                step++;
            } else {
                if ((int) c > 47 && (int) c < 58 || (int) c == 46 || (int) c == 45) {
                    strings[step] += c;
                }
            }
        }
        return new double[]{Double.parseDouble(strings[0]),Double.parseDouble(strings[1]),Double.parseDouble(strings[2])};
    }
    public static void zeroOfQuadratic(double a, double b, double c) {
        double[] result = quadSolveCompact(a,b,c);
        if(result==null) System.out.println("No zero of the function");
        else if(result.length==2){
            System.out.println("x1 = "+result[0]);
            System.out.println("x2 = "+result[1]);
        }else{
            System.out.println("x = "+result[0]);
        }
    }
    public static double[] quadSolveCompact(double a, double b, double c){
        //your code goes here
        double top = Math.sqrt((b*b)-(4*a*c));
        if(Double.isNaN(top)) return null; // Wenn die Wurzel NaN ist, fehler => return

        double x1 = ((b*-1) + top)/(2*a);
        double x2 = ((b*-1) - top)/(2*a);

        if(Double.isNaN(x1) || Double.isNaN(x2)) return null; // Wenn x1 oder x2 NaN ist, fehler => return
        if(x1==(x2*-1) || x1==x2) return new double[]{x2}; // Wenn x1 = -x2 ODER x1 == x2 => return x2
        /* Achtung! Diese Methode ist Unsicher! Hier "scheint" es zu funktionieren, aber im normalfall sollte man das resultat weiter validieren. */

        // Resultat zurückgeben
        if(x1<x2) return new double[]{x1, x2};
        return new double[]{x2, x1};
    }
}
