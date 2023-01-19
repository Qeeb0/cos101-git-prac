import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //This code is like a reference takes the public code
        int principle = (int) readNumber("Principle: ",1000,1_000_000);
        double annualInterest = (double) readNumber("Annual Interest Rate: ", 1,30);
        int year = (int) readNumber("Years: ", 1,30);

        double mortage=mortgageCalculate(principle,annualInterest,year);
        //Converting the numbers to rands
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(mortage);
        //The result
        System.out.println("The Mortgage is: "+ result);
    }
    public static double readNumber(String prompt, int min, int max){
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double value;
        while(true){
            System.out.print(prompt);
            value= scanner.nextDouble();
            if(value>= min && value <= max)
                break;
            System.out.println("Enter a value between "+ min + " and " + max);
        }
        return value;
    }
    public static double mortgageCalculate(int principle, double annualInterest, int year) {
        int percent= 100;
        int monthly=12;

        double monthlyPayments = year*monthly;
        double monthlyInterests = annualInterest / percent / monthly;

        double mortage= principle*(monthlyInterests*Math.pow(1+monthlyInterests,monthlyPayments))/(Math.pow(1+monthlyInterests,monthlyPayments)-1);

        return mortage;
    }
}


