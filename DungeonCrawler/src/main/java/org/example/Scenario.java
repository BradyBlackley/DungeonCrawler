package org.example;

import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuperBuilder
public class Scenario extends Entity {

    private static final Random RAND = new Random();
    Location location;
    List<Creature> creatures;
    Dilemma dilemma;

    public void generateAttributes() {
        this.location = LocationGenerator.randomLocation();
        this.creatures = generateRandomCreatures();
        this.dilemma = generateDilemmaWithCreatures();
    }

    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append("Location: \n")
                .append(location.getDescription())
                .append("\n")
                .append("\n")
                .append("Creatures: \n");
        for (Creature creature : creatures) {
            sb.append(creature.describe()).append("\n");
        }
        sb.append("\n");
        sb.append("Dilemma: \n");
        sb.append(dilemma.getDescription());
        return sb.toString();
    }

    private List<Creature> generateRandomCreatures() {
        List<Creature> creatures = new ArrayList<>();

        int numberOfCreatures = RAND.nextInt(2, 6);

        for (int i = 0; i < numberOfCreatures; i++) {
            Creature creature = Creature.builder().build();
            creature.generateAttributes();
            creatures.add(creature);
        }

        return creatures;
    }

    private Dilemma generateDilemmaWithCreatures() {

        Dilemma template = DilemmaGenerator.randomDilemma();

        Dilemma dilemma = Dilemma.builder().build();

        dilemma.setId(template.getId());

        dilemma.setDescription(
                template.getDescription()
                        .replace("[character1]", creatures.get(0).firstName)
                        .replace("[character2]", creatures.get(1).firstName)
                        .replace("[character1.secret]", creatures.get(0).secret.getDescription())
                        .replace("[character2.secret]", creatures.get(1).secret.getDescription())
        );

        return dilemma;
    }

}
