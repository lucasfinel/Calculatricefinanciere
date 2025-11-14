package com.lucasfinel.fincalc;

import org.apache.commons.math3.util.FastMath;

public class LoanCalculator {
    public double monthlyPayment(double principal, double annualRate, int years) {
        double monthlyRate = annualRate / 12.0;
        int n = years * 12;

        if (monthlyRate == 0) {
            return principal / n;
        }

        double factor = FastMath.pow(1 + monthlyRate, n);
        return principal * monthlyRate * factor / (factor - 1);
    }
}
