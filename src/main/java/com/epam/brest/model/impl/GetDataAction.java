package com.epam.brest.model.impl;

import com.epam.brest.calc.DeliveryCalculator;
import com.epam.brest.model.Action;
import com.epam.brest.model.Status;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.epam.brest.model.Status.GET_DATA;

public record GetDataAction(Scanner scanner, List<String> messages, DeliveryCalculator deliveryCalculator) implements Action {

    public static final int NUMBER_OF_INPUT_DATA = 2;

    @Override
    public Action perform() {
        if (inputData.size() == NUMBER_OF_INPUT_DATA) {
            return new CalcAction(deliveryCalculator, scanner, messages);
        }
        System.out.println(messages.get(inputData.size()));
        String inputValue = scanner.next();
        try {
            Optional<BigDecimal> optionalValue = getNumericValue(inputValue);
            BigDecimal numericValue = optionalValue.orElseThrow(IllegalArgumentException::new);
            if (numericValue.signum() == 0) {
                return new ExitAction();
            }
            inputData.add(numericValue);
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect value: " + inputValue);
        }
        return this;
    }

    @Override
    public Status getStatus() {
        return GET_DATA;
    }

    private Optional<BigDecimal> getNumericValue(String inputValue) {
        BigDecimal value = new BigDecimal(inputValue);
        return value.signum() >= 0 ? Optional.of(value) : Optional.empty();
    }
    
}
