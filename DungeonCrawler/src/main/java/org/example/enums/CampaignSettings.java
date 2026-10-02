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
    EXANDRIA("Exandria"),
    THE_FORGOTTEN_REALMS("The Forgotten Realms"),
    GREYHAWK("Greyhawk"),
    PLANESCAPE("Planescape"),
    RAVENLOFT("Ravenloft"),
    RAVNICA("Ravnica"),
    SPELLJAMMER("Spelljammer"),
    STRIXHAVEN("Strixhaven"),
    THEROS("Theros");

    private final String description;

}
