package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@Getter
@AllArgsConstructor
@ToString
public enum CreatureType {
    BEAST("beast"),
    DRAGON("dragon"),
    DRAGON_METALLIC("metallic dragon"),
    DRAGON_CHROMATIC("chromatic dragon"),
    ELEMENTAL("elemental"),
    HUMANOID("humanoid"),
    HUMANOID_HUMAN("human"),
    MONSTROSITY("monstrosity"),
    PLANT("plant"),
    PLANT_MYCONID("myconid plant"),
    UNDEAD("undead");

    private final String description;
    private static final Random RAND = new Random();

    public static CreatureType randomCreatureType() {
        CreatureType[] creatureTypes = CreatureType.values();
        return creatureTypes[RAND.nextInt(creatureTypes.length)];
    }
}
