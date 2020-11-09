package Readout9;

public class Readout9 {
    public static void main(String[] args){
        Readout9 readout9 = new Readout9();
        readout9.multTable(8,4);
    }
    char hex(int n){
        return (char) (n<10?('0'+n):('A'+(n-10)));
    }
    void multTable(int x, int y){
        for( int i=1;i<=y;i++){
            for(int j=1;j<=x;j++) {
                System.out.print((i*j)+" ");
            }
            System.out.println();
        }
    }
    void countUpBy2(int aNum){
        for(int i=1;i<=aNum;i+=2){
            System.out.println(i);
        }
    }
    void countUpAndDownBy2(int aNum){
        for(int i=1,j=aNum;i<=aNum;i+=2,j-=2){
            System.out.println(i+" "+j);
        }
    }
    void countByHalf(double aDouble){
        for(double i=0.0;i<=aDouble;i+=0.5){
            System.out.println(i);
        }
    }
    void countByTenth(double aDouble){
        for(double i=0.0;i<=aDouble;i+=0.1){
            System.out.println(i);
        }
    }
    void countByTenthFixed(double aDouble){
        for(int i=0;i<=aDouble*10;i++){
            System.out.println((double)i/10);
        }
    }
}
