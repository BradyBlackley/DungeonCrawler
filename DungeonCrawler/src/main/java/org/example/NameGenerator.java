package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class NameGenerator {

    private static final Random RAND = new Random();
    private static final List<Name> COMMON_FIRST_NAMES;
    private static final List<Name> COMMON_SURNAMES;
    private static final List<Name> MONOSYLLABIC_FIRST_NAMES;
    private static final List<Name> MONOSYLLABIC_SURNAMES;
    private static final List<Name> GUTTURAL_FIRST_NAMES;
    private static final List<Name> GUTTURAL_SURNAMES;
    private static final List<Name> SINISTER_FIRST_NAMES;
    private static final List<Name> SINISTER_SURNAMES;
    private static final List<Name> LYRICAL_FIRST_NAMES;
    private static final List<Name> LYRICAL_SURNAMES;
    private static final List<Name> WHIMSICAL_FIRST_NAMES;
    private static final List<Name> WHIMSICAL_SURNAMES;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/names/common-first-names.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/common-first-names.json");
            }

            COMMON_FIRST_NAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Name>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load first names", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/names/common-surnames.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/common-surnames.json");
            }

            COMMON_SURNAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Name>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load surnames", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/names/monosyllabic-first-names.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/monosyllabic-first-names.json");
            }

            MONOSYLLABIC_FIRST_NAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Name>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load monosyllabic first names", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/names/monosyllabic-surnames.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/monosyllabic-surnames.json");
            }

            MONOSYLLABIC_SURNAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Name>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load monosyllabic surnames", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/names/guttural-first-names.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/guttural-first-names.json");
            }

            GUTTURAL_FIRST_NAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Name>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load guttural first names", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/names/guttural-surnames.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/guttural-surnames.json");
            }

            GUTTURAL_SURNAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Name>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load guttural surnames", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/names/sinister-first-names.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/sinister-first-names.json");
            }

            SINISTER_FIRST_NAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Name>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load sinister first names", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/names/sinister-surnames.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/sinister-surnames.json");
            }

            SINISTER_SURNAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Name>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load sinister surnames", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/names/lyrical-first-names.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/lyrical-first-names.json");
            }

            LYRICAL_FIRST_NAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Name>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load lyrical first names", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/names/lyrical-surnames.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/lyrical-surnames.json");
            }

            LYRICAL_SURNAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Name>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load lyrical surnames", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/names/whimsical-first-names.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/whimsical-first-names.json");
            }

            WHIMSICAL_FIRST_NAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Name>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load whimsical first names", e);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/names/whimsical-surnames.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /names/whimsical-surnames.json");
            }

            WHIMSICAL_SURNAMES = mapper.readValue(
                    in,
                    new TypeReference<List<Name>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load whimsical surnames", e);
        }
    }

    public static Name randomFirstName() {
        return COMMON_FIRST_NAMES.get(RAND.nextInt(COMMON_FIRST_NAMES.size()));
    }

    public static Name randomSurname() {
        return COMMON_SURNAMES.get(RAND.nextInt(COMMON_SURNAMES.size()));
    }

    public static Name randomMonosyllabicFirstName() {
        return MONOSYLLABIC_FIRST_NAMES.get(RAND.nextInt(MONOSYLLABIC_FIRST_NAMES.size()));
    }

    public static Name randomMonosyllabicSurname() {
        return MONOSYLLABIC_SURNAMES.get(RAND.nextInt(MONOSYLLABIC_SURNAMES.size()));
    }

    public static Name randomGutturalFirstName() {
        return GUTTURAL_FIRST_NAMES.get(RAND.nextInt(GUTTURAL_FIRST_NAMES.size()));
    }

    public static Name randomGutturalSurname() {
        return GUTTURAL_SURNAMES.get(RAND.nextInt(GUTTURAL_SURNAMES.size()));
    }

    public static Name randomSinisterFirstName() {
        return SINISTER_FIRST_NAMES.get(RAND.nextInt(SINISTER_FIRST_NAMES.size()));
    }

    public static Name randomSinisterSurname() {
        return SINISTER_SURNAMES.get(RAND.nextInt(SINISTER_SURNAMES.size()));
    }

    public static Name randomLyricalFirstName() {
        return LYRICAL_FIRST_NAMES.get(RAND.nextInt(LYRICAL_FIRST_NAMES.size()));
    }

    public static Name randomLyricalSurname() {
        return LYRICAL_SURNAMES.get(RAND.nextInt(LYRICAL_SURNAMES.size()));
    }

    public static Name randomWhimsicalFirstName() {
        return WHIMSICAL_FIRST_NAMES.get(RAND.nextInt(WHIMSICAL_FIRST_NAMES.size()));
    }

    public static Name randomWhimsicalSurname() {
        return WHIMSICAL_SURNAMES.get(RAND.nextInt(WHIMSICAL_SURNAMES.size()));
    }
}
