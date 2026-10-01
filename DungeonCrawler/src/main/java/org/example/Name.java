package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class Name {

    private static final Random RAND = new Random();
    private static final List<Feature> FIRST_NAMES;
    private static final List<Feature> SURNAMES;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = Name.class.getResourceAsStream("/names/first-names.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/first-names.json");
            }

            FIRST_NAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Feature>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load first names", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = Name.class.getResourceAsStream("/names/surnames.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/surnames.json");
            }

            SURNAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Feature>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load surnames", e);
        }
    }

    public static Feature randomFirstName() {
        return FIRST_NAMES.get(RAND.nextInt(FIRST_NAMES.size()));
    }

    public static Feature randomSurname() {
        return SURNAMES.get(RAND.nextInt(SURNAMES.size()));
    }
}
