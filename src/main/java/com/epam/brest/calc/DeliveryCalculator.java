package com.epam.brest.calc;

import java.math.BigDecimal;

public interface DeliveryCalculator {

    BigDecimal calcCost(BigDecimal weight, BigDecimal distance);

}
