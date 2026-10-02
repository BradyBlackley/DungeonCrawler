package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum CampaignSettings {

    DARK_SUN("Dark Sun"),
    DRAGONLANCE("Dragonlance"),
    EBERRON("Eberron"),
    THE_FORGOTTEN_REALMS("The Forgotten Realms"),
    GREYHAWK("Greyhawk"),
    PLANESCAPE("Planescape"),
    RAVENLOFT("Ravenloft"),
    SPELLJAMMER("Spelljammer");

    private final String description;

}
