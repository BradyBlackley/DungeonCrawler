package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class Name {

    private static final Random RAND = new Random();
    private static final List<Feature> COMMON_FIRST_NAMES;
    private static final List<Feature> COMMON_SURNAMES;
    private static final List<Feature> MONOSYLLABIC_FIRST_NAMES;
    private static final List<Feature> MONOSYLLABIC_SURNAMES;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = Name.class.getResourceAsStream("/names/common-first-names.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/common-first-names.json");
            }

            COMMON_FIRST_NAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Feature>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load first names", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = Name.class.getResourceAsStream("/names/common-surnames.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/common-surnames.json");
            }

            COMMON_SURNAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Feature>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load surnames", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = Name.class.getResourceAsStream("/names/monosyllabic-first-names.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/monosyllabic-first-names.json");
            }

            MONOSYLLABIC_FIRST_NAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Feature>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load first names", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = Name.class.getResourceAsStream("/names/monosyllabic-surnames.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/monosyllabic-surnames.json");
            }

            MONOSYLLABIC_SURNAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Feature>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load surnames", e);
        }
    }

    public static Feature randomFirstName() {
        return COMMON_FIRST_NAMES.get(RAND.nextInt(COMMON_FIRST_NAMES.size()));
    }

    public static Feature randomSurname() {
        return COMMON_SURNAMES.get(RAND.nextInt(COMMON_SURNAMES.size()));
    }

    public static Feature randomMonosyllabicFirstName() {
        return MONOSYLLABIC_FIRST_NAMES.get(RAND.nextInt(MONOSYLLABIC_FIRST_NAMES.size()));
    }

    public static Feature randomMonosyllabicSurname() {
        return MONOSYLLABIC_SURNAMES.get(RAND.nextInt(MONOSYLLABIC_SURNAMES.size()));
    }
}
