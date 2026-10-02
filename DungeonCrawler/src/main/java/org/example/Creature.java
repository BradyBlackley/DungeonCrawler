package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.SuperBuilder;
import org.example.enums.Alignment;
import org.example.enums.CreatureGenus;
import org.example.enums.Size;

@SuperBuilder
public class Creature extends Entity implements NPC {

    String firstName;
    String surname;
    Size size;
    String species;
    CreatureGenus genus;
    Alignment alignment;
    StatBlock stats;
    double challenge;
    Feature appearance;

    ObjectMapper mapper;

    @Override
    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstName)
                .append(" ")
                .append(surname)
                .append(", a ")
                .append(size.getDescription())
                .append(" ")
                .append(genus.getDescription())
                .append(" ")
                .append("with ")
                .append(appearance.getDescription())
                .append(" that is ")
                .append(alignment.getDescription())
                .append(".");
        return sb.toString();
    }

    @Override
    public void generateAttributes() {
        this.size = Size.randomSize();
        this.genus = CreatureGenus.randomCreatureType();
        this.alignment = Alignment.randomAlignment();
        this.appearance = Appearance.randomAppearance();
        this.firstName = generateFirstNameByCreatureType();
        this.surname = generateSurnameByCreatureType();
    }

    public String generateFirstNameByCreatureType() {
        String firstName;
        switch (this.genus) {
            case BEAST, MONSTROSITY -> firstName = Name.randomGutturalFirstName().getDescription();
            case DRAGON, UNDEAD -> firstName = Name.randomSinisterFirstName().getDescription();
            case ELEMENTAL, PLANT -> firstName = Name.randomMonosyllabicFirstName().getDescription();
            default -> firstName = Name.randomFirstName().getDescription();
        }
        return firstName;
    }

    public String generateSurnameByCreatureType() {
        String surname;
        switch (this.genus) {
            case BEAST, MONSTROSITY -> surname = Name.randomGutturalSurname().getDescription();
            case DRAGON, UNDEAD -> surname = Name.randomSinisterSurname().getDescription();
            case ELEMENTAL, PLANT -> surname = Name.randomMonosyllabicSurname().getDescription();
            default -> surname = Name.randomSurname().getDescription();
        }
        return surname;
    }
}
