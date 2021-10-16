package com.epam.brest.calc;

import java.math.BigDecimal;

public interface Calc {

    BigDecimal calcCost(BigDecimal weight, BigDecimal pricePerKg, BigDecimal length, BigDecimal pricePerKm);

}
