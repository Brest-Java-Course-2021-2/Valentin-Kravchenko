package com.epam.brest.calc;

import com.epam.brest.resource.ResourceHandler;

import java.math.BigDecimal;
import java.util.NavigableMap;
import java.util.Objects;

public class PriceHandler {

    private final NavigableMap<BigDecimal, BigDecimal> mapPricePerKg;
    private final NavigableMap<BigDecimal, BigDecimal> mapPricePerKm;

    public PriceHandler(ResourceHandler resourceHandler, String filePriceKg, String filePriceKm) {
        this.mapPricePerKg = resourceHandler.getMapPrice(filePriceKg);
        this.mapPricePerKm = resourceHandler.getMapPrice(filePriceKm);
    }

    public BigDecimal getPrice(NavigableMap<BigDecimal, BigDecimal> mapPrice, BigDecimal requiredValue) {
        BigDecimal price = mapPrice.get(requiredValue);
        if (Objects.nonNull(price)) {
            return price;
        }
        return mapPrice.floorEntry(requiredValue).getValue();
    }

    public NavigableMap<BigDecimal, BigDecimal> getMapPricePerKg() {
        return mapPricePerKg;
    }

    public NavigableMap<BigDecimal, BigDecimal> getMapPricePerKm() {
        return mapPricePerKm;
    }

}
