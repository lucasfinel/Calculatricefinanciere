package com.lucasfinel.fincalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InvestmentCalculatorTest {

    @Test
    void testFutureValuePositive() {
        InvestmentCalculator calc = new InvestmentCalculator();
        double fv = calc.futureValue(100.0, 0.05, 10);
        assertTrue(fv > 0);
    }
}
