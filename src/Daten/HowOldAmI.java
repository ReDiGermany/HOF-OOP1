package Daten;
import java.time.LocalDateTime;

public class HowOldAmI {
    public static void main(String[] args) {
        int[] bDay = new int[]{19,10,1994};
        int[] toDay = new int[]{29,10,2020};
        if(args.length==3){
            for(int i=0;i<3;i++)
            bDay[i] = Integer.parseInt(args[i]);
        }
        System.out.println(calculateDaysOnEarth(bDay[0], bDay[1], bDay[2], toDay[0], toDay[1], toDay[2]));
        int days = calculateDaysOnEarthToToday(bDay[0], bDay[1], bDay[2]);
        System.out.format("Days on Earth: %s\n",days);
        System.out.format("Hours on Earth: %s\n",(days*24));
        System.out.format("Minutes on Earth: %s\n",(days*24*60));
        System.out.format("Seconds on Earth: %s\n",(days*24*60*60));
    }
    public static int calculateDaysOnEarthToToday(int bDay, int bMonth, int bYear){
        LocalDateTime date = LocalDateTime.now();
        return calculateDaysOnEarth(bDay,bMonth,bYear,date.getDayOfMonth(),date.getMonthValue(),date.getYear());
    }
    public static int calculateDaysOnEarth(int bDay, int bMonth, int bYear, int toDay, int toMonth, int toYear) {
        int days = 0;
        for (int year = bYear; year <= toYear; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= daysOfMonth(month, year); day++) {
                    boolean check = true;
                    if (bYear == year) {
                        if (month < bMonth) {
                            check = false;
                        } else if (month == bMonth && day <= bDay) {
                            check = false;
                        }
                    } else if (year == toYear) {
                        if (month > toMonth) {
                            check = false;
                        } else if (month == toMonth && day >= toDay) {
                            check = false;
                        }
                    }
                    if (check) {
                        days++;
                    }
                }
            }
        }
        return days;
    }
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
}
