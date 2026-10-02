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

    public void generateAttributes() {
        this.location = LocationGenerator.randomLocation();
        System.out.println("Describing location: ");
        System.out.println(location.getDescription());
        System.out.println();
        this.creatures = generateRandomCreatures();
    }

    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append("Describing location: ")
                .append(location.getDescription())
                .append("Describing creatures: ");
        for (Creature creature : creatures) {
            sb.append(creature.describe()).append("\n");
        }
        return sb.toString();
    }

    private List<Creature> generateRandomCreatures() {
        System.out.println("Describing creatures:");
        System.out.println();

        int loop = 0;
        List<Creature> retVal = new ArrayList<>(List.of());
        while(loop < RAND.nextInt(2, 6)) {
            Creature creature = Creature.builder().build();
            creature.generateAttributes();
            System.out.println(creature.describe());
            retVal.add(creature);
            loop++;
        }

        return retVal;
    }

}
