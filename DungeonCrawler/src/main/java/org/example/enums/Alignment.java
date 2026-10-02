package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@Getter
@AllArgsConstructor
@ToString
public enum Alignment {
    LAWFUL_GOOD("lawful-good"),
    LAWFUL_NEUTRAL("lawful-neutral"),
    LAWFUL_EVIL("lawful-evil"),
    NEUTRAL_GOOD("neutral-good"),
    NEUTRAL("neutral"),
    NEUTRAL_EVIL("neutral-good"),
    CHAOTIC_GOOD("chaotic-good"),
    CHAOTIC_NEUTRAL("chaotic-neutral"),
    CHAOTIC_EVIL("chaotic-evil"),
    UNALIGNED("unaligned");

    private final String description;
    private static final Random RAND = new Random();

    public static Alignment randomAlignment() {
        Alignment[] alignments = Alignment.values();
        return alignments[RAND.nextInt(alignments.length)];
    }
}
