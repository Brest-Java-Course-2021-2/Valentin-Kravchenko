package com.epam.brest.io;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ResourceHandler {

    public NavigableMap<BigDecimal, BigDecimal> getMapPrice(String resourceFile) {
        URL resource = getClass().getClassLoader().getResource(resourceFile);
        if (Objects.isNull(resource)) {
            throw new IllegalArgumentException("File " + resourceFile + " not found!");
        }
        try {
            Path path = Paths.get(resource.toURI());
            NavigableMap<BigDecimal, BigDecimal> price = Files.lines(path)
                                                              .filter(line -> !line.startsWith("#"))
                                                              .map(line -> line.split("-"))
                                                              .collect(Collectors.toMap(arr -> BigDecimal.valueOf(Double.parseDouble(arr[0])),
                                                                                        arr -> BigDecimal.valueOf(Double.parseDouble(arr[1])),
                                                                                        (oldValue, newValue) -> oldValue,
                                                                                        TreeMap::new));
            return price;

        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
