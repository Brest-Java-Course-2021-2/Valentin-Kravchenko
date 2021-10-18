package com.epam.brest.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface Action {

    List<BigDecimal> inputData = new ArrayList<>();
    Action perform();
    Status getStatus();

}
