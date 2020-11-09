package Readout6;

public class PotentialEnergy {
    /**
     * untested but seems to work. lol.
     */
    public static void main(String[] args){
        System.out.println("double "+potE(42.42,99.2));
        System.out.println("float "+potEFloat(42.42f,99.2f));
    }
    public static double potE(double m,double h){
        return m*9.81*h;
    }
    public static float potEFloat(float m,float h){
        return m*9.81f*h;
    }
}
