package com.lucasfinel.fincalc;

import org.apache.commons.math3.util.FastMath;

public class InvestmentCalculator {
    public double futureValue(double monthlyContribution, double annualRate, int years) {
        double monthlyRate = annualRate / 12.0;
        int n = years * 12;

        if (monthlyRate == 0) {
            return monthlyContribution * n;
        }

        double factor = FastMath.pow(1 + monthlyRate, n);
        return monthlyContribution * (factor - 1) / monthlyRate;
    }
}
