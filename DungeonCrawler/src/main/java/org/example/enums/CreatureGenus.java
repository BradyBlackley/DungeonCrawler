package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@Getter
@AllArgsConstructor
@ToString
public enum CreatureGenus {
    BEAST("beast"),
    DRAGON("dragon"),
    ELEMENTAL("elemental"),
    HUMAN("human"),
    MONSTROSITY("monstrosity"),
    PLANT("plant"),
    UNDEAD("undead");

    private final String description;
    private static final Random RAND = new Random();

    public static CreatureGenus randomCreatureType() {
        CreatureGenus[] creatureTypes = CreatureGenus.values();
        return creatureTypes[RAND.nextInt(creatureTypes.length)];
    }
}
