package com.epam.brest.resource.impl;

import com.epam.brest.resource.ResourceHandler;
import com.epam.brest.resource.ResourceUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TxtFileResourceHandler implements ResourceHandler {

    @Override
    public NavigableMap<BigDecimal, BigDecimal> getMapPrice(String resourceFile) {

        return ResourceUtils.getStream(resourceFile)
                            .filter(line -> !line.startsWith("#"))
                            .map(line -> line.split("-"))
                            .collect(Collectors.toMap(arr -> BigDecimal.valueOf(Double.parseDouble(arr[0])),
                                                      arr -> BigDecimal.valueOf(Double.parseDouble(arr[1])),
                                                      (oldValue, newValue) -> oldValue,
                                                      TreeMap::new));

    }

    @Override
    public List<String> getMessages(String resourceFile) {
        return ResourceUtils.getStream(resourceFile).toList();
    }

}
