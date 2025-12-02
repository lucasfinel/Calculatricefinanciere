package com.lucasfinel.fincalc;

import org.apache.commons.math3.util.FastMath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanCalculator {

    private static final Logger logger = LoggerFactory.getLogger(LoanCalculator.class);

    public double monthlyPayment(double principal, double annualRate, int years) {

        logger.info("Starting monthly payment computation");

        logger.debug("Inputs -> principal={}, annualRate={}, years={}",
                principal, annualRate, years);

        int n = years * 12;
        double monthlyRate = annualRate / 12.0;

        if (principal < 0) {
            logger.warn("Principal is negative: {}", principal);
        }
        if (annualRate < 0) {
            logger.warn("Annual rate is negative: {}", annualRate);
        }

        try {
            double result;

            if (monthlyRate == 0) {
                result = principal / n;
            } else {
                double factor = FastMath.pow(1 + monthlyRate, n);
                result = principal * monthlyRate * factor / (factor - 1);
            }

            logger.debug("Computed monthly payment = {}", result);

            return result;

        } catch (Exception e) {
            logger.error("Error while computing monthly payment", e);
            throw e;
        }
    }
}
