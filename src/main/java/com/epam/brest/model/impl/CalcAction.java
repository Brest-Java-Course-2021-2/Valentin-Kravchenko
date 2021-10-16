package com.epam.brest.model.impl;

import com.epam.brest.calc.DeliveryCalculator;
import com.epam.brest.model.Action;
import com.epam.brest.model.Status;

import java.util.List;
import java.util.Scanner;

import static com.epam.brest.model.Status.CALC;

public record CalcAction(DeliveryCalculator deliveryCalculator, Scanner scanner, List<String> messages) implements Action {

    @Override
    public Action perform() {
        try {
            System.out.println("Delivery cost: " + deliveryCalculator.calcCost(inputData.get(0), inputData.get(1)));
        } finally {
            inputData.clear();
        }
        return new GetDataAction(scanner, messages, deliveryCalculator);
    }

    @Override
    public Status getStatus() {
        return CALC;
    }

}
