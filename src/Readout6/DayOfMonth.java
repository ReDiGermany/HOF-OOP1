package Readout6;

public class DayOfMonth {
    public static final int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args){
        System.out.println(numberOfDays(2,2000)); // 29
        System.out.println(numberOfDays(2,2001)); // 28
        System.out.println(numberOfDays(11,2001)); // 30
        System.out.println(numberOfDays(12,2001)); // 31
    }
    public static int numberOfDays(int month, int year){
        if(month==2 && isLeapYear(year)){
            return 29;
        }
//        return daysOfMonth(month); // alternativ
        return months[--month]; // array methode, deswegen muss month vorher -1 gerechnet werden
    }

    /**
     * Testet ein Schaltjahr mit einfacheren if statements.
     * @param i das Jahr, welches getestet werden muss.
     * @return true | false ob es sich um ein Schaltjahr handelt.
     */
    public static boolean isLeapYear(int i) {
        if (i % 4 == 0) { // durch 4 Teilbar
            if (i % 100 != 0) { // nicht durch 100 Teilbar
                return true;
            }
            if (i % 400 == 0) { // durch 400 Teilbar
                return true;
            }
        }
        return false;
    }

    /**
     * Danke an @andy1631 für die Idee der Berechnung.
     * @param month
     * @return
     */
    public static int daysOfMonth(int month){
        if(month==2) return 28;
        if((month<=7 && month%2!=0) || (month>7 && month%2==0)){
            return 31;
        }else{
            return 30;
        }
    }
    public static int daysOfMonth(int month,int year) {
        if(month==2) return isLeapYear(year)?29:28;
        return daysOfMonth(month);
    }
}
