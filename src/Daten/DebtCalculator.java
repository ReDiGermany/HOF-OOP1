package Daten;

public class DebtCalculator {
    public static double calculateMonthly(double money, double interests, double months){
        return (money/months)+(money*interests);
    }
    public static double calculate(double money, double interests, double months){
        return calculateMonthly(money,interests,months) * months;
    }
    public static void main(String[] args){
        if(args.length==3){
            double money = Double.parseDouble(args[0]); // geliehenen Betrag in Euro
            double interests = Double.parseDouble(args[1]); // monatlichen Zinsen
            double months = Double.parseDouble(args[2]); // Monate der vereinbarten Rückzahlung
//            System.out.format("money:%s interests:%s months:%s\n",money,interests,months);
            final double firstMonths = Double.parseDouble(args[2]);
            double toCalculate = calculate(money,interests,months);
            while(toCalculate >= money*1.5){
                months--;
                toCalculate = calculate(money,interests,months);
            }
            if(months!=firstMonths) {
                System.out.println("Warnung, Anpassung der Rückzahldauer..");
                System.out.println("Rückzahlung auf " + (int)months + " Monate angepasst.");
            }
            System.out.println("Return per month: "+calculateMonthly(money,interests,months));
            System.out.println("Return total    : "+toCalculate);
        }else{
            System.out.println("Bitte folgendes Format beachten: java DebtCalculator [geliehenen Betrag in Euro] [monatlichen Zinsen] [Monate der vereinbarten Rückzahlung]");
        }
    }
}
