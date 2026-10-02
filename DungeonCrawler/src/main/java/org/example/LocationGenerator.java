package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class LocationGenerator {

    private static final Random RAND = new Random();
    private static final List<Location> LOCATIONS;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/locations/locations.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /locations/locations.json");
            }

            LOCATIONS = mapper.readValue(
                    in,
                    new TypeReference<List<Location>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load locations", e);
        }
    }

    public static Location randomLocation() {
        return LOCATIONS.get(RAND.nextInt(LOCATIONS.size()));
    }
}
