package com.epam.brest.model.impl;

import com.epam.brest.calc.DeliveryCalculator;
import com.epam.brest.model.Action;
import com.epam.brest.model.Status;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

import static com.epam.brest.model.Status.CALC;

public class CalcAction implements Action {

    private final Scanner scanner;
    private final ApplicationContext context;
    private final DeliveryCalculator deliveryCalculator;

    public CalcAction(Scanner scanner, ApplicationContext context) {
        this.scanner = scanner;
        this.context = context;
        this.deliveryCalculator = context.getBean("deliveryCalculator", DeliveryCalculator.class);
    }

    @Override
    public Action perform() {
        try {
            System.out.println("Delivery cost: " + deliveryCalculator.calcCost(inputData.get(0), inputData.get(1)));
        } finally {
            inputData.clear();
        }
        return new GetDataAction(scanner, context);
    }

    @Override
    public Status getStatus() {
        return CALC;
    }

}
