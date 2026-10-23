package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class DilemmaGenerator {

    private static final Random RAND = new Random();
    private static final List<Dilemma> DILEMMAS;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/dilemmas/dilemmas.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /dilemmas/dilemmas.json");
            }

            DILEMMAS = mapper.readValue(
                    in,
                    new TypeReference<List<Dilemma>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load dilemmas", e);
        }
    }

    public static Dilemma randomDilemma() {
        return DILEMMAS.get(RAND.nextInt(DILEMMAS.size()));
    }
}
