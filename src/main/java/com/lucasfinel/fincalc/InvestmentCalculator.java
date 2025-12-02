package com.lucasfinel.fincalc;

import org.apache.commons.math3.util.FastMath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvestmentCalculator {

    private static final Logger logger = LoggerFactory.getLogger(InvestmentCalculator.class);

    public double futureValue(double monthlyContribution, double annualRate, int years) {

        logger.info("Starting future value computation");

        logger.debug("Inputs -> monthlyContribution={}, annualRate={}, years={}",
                monthlyContribution, annualRate, years);

        int n = years * 12;
        double monthlyRate = annualRate / 12.0;

        if (monthlyContribution < 0) {
            logger.warn("Monthly contribution is negative: {}", monthlyContribution);
        }
        if (annualRate < 0) {
            logger.warn("Annual rate is negative: {}", annualRate);
        }

        try {
            double result;

            if (monthlyRate == 0) {
                result = monthlyContribution * n;
            } else {
                double factor = FastMath.pow(1 + monthlyRate, n);
                result = monthlyContribution * (factor - 1) / monthlyRate;
            }

            logger.debug("Computed future value = {}", result);

            return result;

        } catch (Exception e) {
            logger.error("Error while computing future value", e);
            throw e;
        }
    }
}
