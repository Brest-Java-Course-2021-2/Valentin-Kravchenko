package com.epam.brest.model.impl;

import com.epam.brest.model.Action;
import com.epam.brest.model.MessageProvider;
import com.epam.brest.model.Status;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

import static com.epam.brest.model.Status.GET_DATA;

public class GetDataAction implements Action {

    public static final int NUMBER_OF_INPUT_DATA = 2;

    private final Scanner scanner;
    private final ApplicationContext context;
    private final MessageProvider messageProvider;

    public GetDataAction(Scanner scanner, ApplicationContext context) {
        this.scanner = scanner;
        this.context = context;
        this.messageProvider = context.getBean("messageProvider", MessageProvider.class);
    }

    @Override
    public Action perform() {
        if (inputData.size() == NUMBER_OF_INPUT_DATA) {
            return new CalcAction(scanner, context);
        }
        System.out.println(messageProvider.getMessage(inputData.size()));
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
        BigDecimal numericValue = new BigDecimal(inputValue);
        return numericValue.signum() >= 0 ? Optional.of(numericValue) : Optional.empty();
    }
    
}
