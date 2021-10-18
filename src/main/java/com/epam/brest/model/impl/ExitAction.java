package com.epam.brest.model.impl;

import com.epam.brest.model.Action;
import com.epam.brest.model.Status;

import static com.epam.brest.model.Status.EXIT;

public class ExitAction implements Action {

    @Override
    public Action perform() {
        return null;
    }

    @Override
    public Status getStatus() {
        return EXIT;
    }

}
