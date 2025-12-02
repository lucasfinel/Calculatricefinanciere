package com.lucasfinel.fincalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanCalculatorTest {

    @Test
    void testMonthlyPaymentZeroRate() {
        LoanCalculator calc = new LoanCalculator();
        double payment = calc.monthlyPayment(1200.0, 0.0, 1);
        assertEquals(100.0, payment, 1e-6);
    }

    @Test
    void testMonthlyPaymentPositiveRate() {
        LoanCalculator calc = new LoanCalculator();
        double payment = calc.monthlyPayment(10000.0, 0.05, 5);
        assertEquals(188.71, payment, 1e-2);
    }
}
