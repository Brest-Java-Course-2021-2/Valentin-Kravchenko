package com.epam.brest.resource;

import java.math.BigDecimal;
import java.util.List;
import java.util.NavigableMap;

public interface ResourceHandler {

    NavigableMap<BigDecimal, BigDecimal> getMapPrice(String resourceFile);
    List<String> getMessages(String resourceFile);

}
