package com.epam.brest;

import com.epam.brest.model.Action;
import com.epam.brest.model.impl.GetDataAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

import static com.epam.brest.model.Status.EXIT;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        try (Scanner scanner = new Scanner(System.in)) {
            Action currentAction = new GetDataAction(scanner, context);
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
