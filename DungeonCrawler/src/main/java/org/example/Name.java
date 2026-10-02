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
    private static final List<Feature> GUTTURAL_FIRST_NAMES;
    private static final List<Feature> GUTTURAL_SURNAMES;
    private static final List<Feature> SINISTER_FIRST_NAMES;
    private static final List<Feature> SINISTER_SURNAMES;

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
            throw new RuntimeException("Failed to load monosyllabic first names", e);
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
            throw new RuntimeException("Failed to load monosyllabic surnames", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = Name.class.getResourceAsStream("/names/guttural-first-names.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/guttural-first-names.json");
            }

            GUTTURAL_FIRST_NAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Feature>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load guttural first names", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = Name.class.getResourceAsStream("/names/guttural-surnames.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/guttural-surnames.json");
            }

            GUTTURAL_SURNAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Feature>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load guttural surnames", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = Name.class.getResourceAsStream("/names/sinister-first-names.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/sinister-first-names.json");
            }

            SINISTER_FIRST_NAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Feature>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load sinister first names", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = Name.class.getResourceAsStream("/names/sinister-surnames.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/sinister-surnames.json");
            }

            SINISTER_SURNAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Feature>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load sinister surnames", e);
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

    public static Feature randomGutturalFirstName() {
        return GUTTURAL_FIRST_NAMES.get(RAND.nextInt(GUTTURAL_FIRST_NAMES.size()));
    }

    public static Feature randomGutturalSurname() {
        return GUTTURAL_SURNAMES.get(RAND.nextInt(GUTTURAL_SURNAMES.size()));
    }

    public static Feature randomSinisterFirstName() {
        return SINISTER_FIRST_NAMES.get(RAND.nextInt(SINISTER_FIRST_NAMES.size()));
    }

    public static Feature randomSinisterSurname() {
        return SINISTER_SURNAMES.get(RAND.nextInt(SINISTER_SURNAMES.size()));
    }
}
