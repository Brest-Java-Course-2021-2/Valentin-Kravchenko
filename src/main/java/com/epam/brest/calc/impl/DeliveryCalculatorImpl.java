package com.epam.brest.calc.impl;

import com.epam.brest.calc.DeliveryCalculator;
import com.epam.brest.calc.PriceHandler;

import java.math.BigDecimal;

public class DeliveryCalculatorImpl implements DeliveryCalculator {

    private final PriceHandler priceHandler;

    public DeliveryCalculatorImpl(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    @Override
    public BigDecimal calcCost(BigDecimal weight, BigDecimal distance) {
        BigDecimal pricePerKg = priceHandler.getPrice(priceHandler.getMapPricePerKg(), weight);
        BigDecimal pricePerKm = priceHandler.getPrice(priceHandler.getMapPricePerKm(), distance);
        return weight.multiply(pricePerKg).add(distance.multiply(pricePerKm));
    }

}
