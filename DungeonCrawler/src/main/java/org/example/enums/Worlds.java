package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum Worlds {

    EBERRON("Eberron"),
    GREYHAWK("Greyhawk"),
    KRYNN("Krynn"),
    RAVENLOFT("Ravenloft"),
    SPELLJAMMER("Spelljammer"),
    TORIL("Toril");

    private final String description;
}
