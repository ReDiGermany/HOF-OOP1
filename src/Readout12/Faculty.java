package Readout12;

public class Faculty {
    public static void main(String[] args) {
        System.out.println("factorialRec: "+factorialRec(20));
        System.out.println("factorialit: "+factorialIt(20));
    }
    public static Double factorialRec(double n){
        if(n==0.0) return 1.0;
        return n*factorialRec(n-1);
    }
    public static Double factorialIt(double n){
        double fac = 1.0;
        for(int i=(int)n;i>=0;i--){
            if(i==0) fac *= 1;
            else fac *= i;
        }
        return fac;
    }
}
