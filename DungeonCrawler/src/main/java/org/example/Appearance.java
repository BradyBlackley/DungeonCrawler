package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class Appearance {

    private static final Random RAND = new Random();
    private static final List<Feature> FEATURES;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = Appearance.class.getResourceAsStream("/appearances/features.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /appearance/features.json");
            }

            FEATURES = mapper.readValue(
                    in,
                    new TypeReference<List<Feature>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load appearance features", e);
        }
    }

    public static Feature randomAppearance() {
        return FEATURES.get(RAND.nextInt(FEATURES.size()));
    }
}
