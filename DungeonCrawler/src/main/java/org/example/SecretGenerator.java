package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class SecretGenerator {

    private static final Random RAND = new Random();
    private static final List<Secret> SECRETS;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream in = NameGenerator.class.getResourceAsStream("/secrets/secrets.json");
            if (in == null) {
                throw new RuntimeException("Resource not found: /secrets/secrets.json");
            }

            SECRETS = mapper.readValue(
                    in,
                    new TypeReference<List<Secret>>() {}
            );

        } catch (IOException e) {
            throw new RuntimeException("Failed to load secrets", e);
        }
    }

    public static Secret randomSecret() {
        return SECRETS.get(RAND.nextInt(SECRETS.size()));
    }

}
