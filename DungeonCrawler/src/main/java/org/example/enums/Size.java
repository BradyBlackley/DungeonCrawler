package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@Getter
@AllArgsConstructor
@ToString
public enum Size {
    TINY("tiny"),
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    HUGE("huge");

    private final String description;
    private static final Random RAND = new Random();

    public static Size fromCode(int code) {
        return switch (code) {
            case 1 -> SMALL;
            case 2 -> MEDIUM;
            case 3 -> LARGE;
            default -> throw new IllegalArgumentException("Invalid size code");
        };
    }

    public static Size randomSize() {
        Size[] sizes = Size.values();
        return sizes[RAND.nextInt(sizes.length)];
    }
}
