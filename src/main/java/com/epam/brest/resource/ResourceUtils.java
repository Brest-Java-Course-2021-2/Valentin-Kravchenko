package com.epam.brest.resource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public final class ResourceUtils {

    private ResourceUtils() {

    }

    public static Stream<String> getLines(String resourceFile) {
        URL resource = ResourceUtils.class.getClassLoader().getResource(resourceFile);
        if (Objects.isNull(resource)) {
            throw new IllegalArgumentException("File " + resourceFile + " not found!");
        }
        try {
            Path path = Paths.get(resource.toURI());
            return Files.lines(path);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
