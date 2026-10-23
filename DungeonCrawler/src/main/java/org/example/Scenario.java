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
        System.out.println("Describing location: ");
        System.out.println();
        System.out.println(location.getDescription());
        System.out.println();
        this.creatures = generateRandomCreatures();
        this.dilemma = generateDilemmaWithCreatures();
    }

    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append("Describing location: ")
                .append(location.getDescription())
                .append("Describing creatures: ");
        for (Creature creature : creatures) {
            sb.append(creature.describe()).append("\n");
        }
        sb.append("Describing dilemma: ");
        sb.append(dilemma.getDescription());
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

        System.out.println();
        return retVal;
    }

    private Dilemma generateDilemmaWithCreatures() {
        Dilemma dilemma1 = DilemmaGenerator.randomDilemma();

        String temp = dilemma1.getDescription();

        temp = temp
                .replace("[character1]", creatures.get(0).firstName)
                .replace("[character2]", creatures.get(1).firstName)
                .replace("[character1.secret]", creatures.get(0).secret.getDescription())
                .replace("[character2.secret]", creatures.get(1).secret.getDescription());

        dilemma1.setDescription(temp);

        System.out.println("Describing dilemma:");
        System.out.println();
        System.out.println(dilemma1.getDescription());
        return dilemma1;
    }

}
