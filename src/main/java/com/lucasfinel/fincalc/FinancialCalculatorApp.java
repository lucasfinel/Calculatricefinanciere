package com.lucasfinel.fincalc;

import java.util.Scanner;

public class FinancialCalculatorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoanCalculator loanCalc = new LoanCalculator();
        InvestmentCalculator invCalc = new InvestmentCalculator();

        System.out.println("=== Financial Calculator ===");
        System.out.println("1) Loan monthly payment");
        System.out.println("2) Investment future value");
        System.out.print("Choose an option (1/2): ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Principal amount: ");
            double principal = scanner.nextDouble();
            System.out.print("Annual interest rate (e.g. 0.05 for 5%): ");
            double rate = scanner.nextDouble();
            System.out.print("Years: ");
            int years = scanner.nextInt();

            double payment = loanCalc.monthlyPayment(principal, rate, years);
            System.out.printf("Monthly payment: %.2f%n", payment);

        } else if (choice == 2) {
            System.out.print("Monthly contribution: ");
            double monthly = scanner.nextDouble();
            System.out.print("Annual interest rate (e.g. 0.05 for 5%): ");
            double rate = scanner.nextDouble();
            System.out.print("Years: ");
            int years = scanner.nextInt();

            double fv = invCalc.futureValue(monthly, rate, years);
            System.out.printf("Future value: %.2f%n", fv);

        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
