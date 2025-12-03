package com.lucasfinel.fincalc;

import org.apache.commons.math3.util.FastMath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Classe qui permet de calculer la mensualité d'un prêt.
 */
public class LoanCalculator {

    private static final Logger logger = LoggerFactory.getLogger(LoanCalculator.class);
    /**
     * Calcule la mensualité d'un prêt à partir du capital, du taux annuel
     * et de la durée en années.
     *
     * Si le taux est nul, le calcul se limite à diviser le capital
     * par le nombre total de mensualités.
     *
     * @param principal montant emprunté
     * @param annualRate taux annuel en décimal (ex : 0.05 pour 5 %)
     * @param years durée du prêt en années
     * @return la mensualité
     * @throws IllegalArgumentException si la durée est inférieure ou égale à 0
     */
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
