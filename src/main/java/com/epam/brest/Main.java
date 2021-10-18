package com.epam.brest;

import com.epam.brest.calc.DeliveryCalculator;
import com.epam.brest.calc.impl.DeliveryCalculatorImpl;
import com.epam.brest.model.Action;
import com.epam.brest.model.impl.GetDataAction;
import com.epam.brest.resource.ResourceHandler;
import com.epam.brest.resource.impl.TxtFileResourceHandler;

import java.math.BigDecimal;
import java.util.List;
import java.util.NavigableMap;
import java.util.Scanner;

import static com.epam.brest.model.Status.EXIT;

public class Main {

    public static void main(String[] args) {

        ResourceHandler resourceHandler = new TxtFileResourceHandler();
        NavigableMap<BigDecimal, BigDecimal> mapPricePerKg = resourceHandler.getMapPrice("price_per_kg.txt");
        NavigableMap<BigDecimal, BigDecimal> mapPricePerKm = resourceHandler.getMapPrice("price_per_km.txt");
        List<String> messages = resourceHandler.getMessages("messages.txt");

        DeliveryCalculator deliveryCalculator = new DeliveryCalculatorImpl(mapPricePerKg, mapPricePerKm);

        try (Scanner scanner = new Scanner(System.in)) {
            Action currentAction = new GetDataAction(scanner, messages, deliveryCalculator);
            while (currentAction.getStatus() != EXIT) {
                displayStatus(currentAction);
                currentAction = currentAction.perform();
            }
            displayStatus(currentAction);
        }
    }

    private static void displayStatus(Action action) {
        System.out.println("Current status: " + action.getStatus());
    }

}
