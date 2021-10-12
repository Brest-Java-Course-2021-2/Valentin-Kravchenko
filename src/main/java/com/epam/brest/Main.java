package com.epam.brest;

import com.epam.brest.calc.Calc;
import com.epam.brest.calc.CalcImpl;
import com.epam.brest.io.ResourceHandler;

import java.math.BigDecimal;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BigDecimal weight;
        BigDecimal pricePerKg;
        BigDecimal distance;
        BigDecimal pricePerKm;

        Calc calc = new CalcImpl();

        ResourceHandler resourceHandler = new ResourceHandler();
        NavigableMap<BigDecimal, BigDecimal> mapPricePerKg = resourceHandler.getMapPrice("pricePerKg.txt");
        NavigableMap<BigDecimal, BigDecimal> mapPricePerKm = resourceHandler.getMapPrice("pricePerKm.txt");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                weight = getValueFromConsole(scanner, "Enter weight: ");
                if (BigDecimal.ZERO.equals(weight)) {
                    break;
                }
                distance = getValueFromConsole(scanner, "Enter length: ");
                if (BigDecimal.ZERO.equals(distance)) {
                    break;
                }
                pricePerKg = getPrice(mapPricePerKg, weight);
                pricePerKm = getPrice(mapPricePerKm, distance);
                System.out.println("Delivery cost: " + calc.calcCost(weight, pricePerKg, distance, pricePerKm));
            }
        }
    }

    private static BigDecimal getValueFromConsole(Scanner scanner, String outputMessage) {
        BigDecimal enteredValue;
        System.out.print(outputMessage);
        enteredValue = scanner.nextBigDecimal();
        return enteredValue;
    }

    private static BigDecimal getPrice(NavigableMap<BigDecimal, BigDecimal> mapPrice, BigDecimal requiredValue) {
        BigDecimal price = mapPrice.get(requiredValue);
        if (Objects.nonNull(price)) {
            return price;
        }
        return mapPrice.floorEntry(requiredValue).getValue();
    }

}
