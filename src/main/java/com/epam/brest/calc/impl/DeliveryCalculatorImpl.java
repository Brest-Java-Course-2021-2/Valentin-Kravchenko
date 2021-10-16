package com.epam.brest.calc.impl;

import com.epam.brest.calc.DeliveryCalculator;

import java.math.BigDecimal;
import java.util.NavigableMap;
import java.util.Objects;

public record DeliveryCalculatorImpl(NavigableMap<BigDecimal, BigDecimal> mapPricePerKg,
                                     NavigableMap<BigDecimal, BigDecimal> mapPricePerKm) implements DeliveryCalculator {

    @Override
    public BigDecimal calcCost(BigDecimal weight, BigDecimal distance) {
        BigDecimal pricePerKg = getPrice(mapPricePerKg, weight);
        BigDecimal pricePerKm = getPrice(mapPricePerKm, distance);
        return weight.multiply(pricePerKg).add(distance.multiply(pricePerKm));
    }

    private BigDecimal getPrice(NavigableMap<BigDecimal, BigDecimal> mapPrice, BigDecimal requiredValue) {
        BigDecimal price = mapPrice.get(requiredValue);
        if (Objects.nonNull(price)) {
            return price;
        }
        return mapPrice.floorEntry(requiredValue).getValue();
    }

}
