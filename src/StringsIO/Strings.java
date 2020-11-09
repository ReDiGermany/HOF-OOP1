package StringsIO;

public class Strings {
    public static void main(String[] args) {
        System.out.println(repeatSeparator("Das", " und ", 3));
        System.out.println(repeatSeparator("test", "X", 2));
        xMasTreeQuickAndDirty(9,20);
//        xMasTree(1,9);
    }
    public static String repeatSeparator(String s1,String s2,int n){
        StringBuilder s = new StringBuilder();
        for(int i=0;i<n;i++){
            s.append(s1);
            if(i+1!=n){
                s.append(s2);
            }
        }
        return s.toString();
    }
    public static void xMasTree(int basewidth,int height){
        if(basewidth%2==0) {
            System.err.println("Die Breite muss eine ungerade Zahl sein!");
            return;
        }
        int baseheight = 2;
        height -= baseheight;

        for(int i=0;i<height;i++){
            System.out.println(padding(height-i)+leafs(i+1+i));
        }

        for(int i=0;i<baseheight;i++){
            System.out.println(padding(height-(basewidth/2))+leafs(basewidth));
        }
    }
    public static void xMasTreeQuickAndDirty(int basewidth,int height){
        int baseheight = 2;
        height -= baseheight;
        for(int i=0;i<height;i++)
            System.out.println(" ".repeat(height-i)+"#".repeat(i+1+i));

        for(int i=0;i<baseheight;i++)
            System.out.println(" ".repeat(height-(basewidth/2))+"#".repeat(basewidth));
    }
    public static String padding(int n){
        return repeat(" ",n);
    }
    public static String leafs(int n){
        return repeat("#",n);
    }
    public static String repeat(String s, int n){
        return s.repeat(Math.max(0,n));
    }
}
