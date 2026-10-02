package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.SuperBuilder;
import org.example.enums.Alignment;
import org.example.enums.CreatureType;
import org.example.enums.Size;

@SuperBuilder
public class Creature extends Entity implements NPC {

    String firstName;
    String surname;
    Size size;
    CreatureType subtype;
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
                .append(subtype.getDescription())
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
        this.subtype = CreatureType.randomCreatureType();
        this.alignment = Alignment.randomAlignment();
        this.appearance = Appearance.randomAppearance();
        this.firstName = generateFirstNameByCreatureType();
        this.surname = Name.randomSurname().getDescription();
    }

    public String generateFirstNameByCreatureType() {
        String firstName;
        switch (this.subtype) {
            case BEAST -> firstName = Name.randomFirstName().getDescription();
            case DRAGON, DRAGON_METALLIC, DRAGON_CHROMATIC -> firstName = Name.randomFirstName().getDescription();
            case ELEMENTAL -> firstName = Name.randomMonosyllabicFirstName().getDescription();
            case HUMANOID -> firstName = Name.randomFirstName().getDescription();
            default -> firstName = Name.randomFirstName().getDescription();
        }
        return firstName;
    }

    public String generateSurnameByCreatureType() {
        String firstName;
        switch (this.subtype) {
            case BEAST -> firstName = Name.randomFirstName().getDescription();
            case DRAGON, DRAGON_METALLIC, DRAGON_CHROMATIC -> firstName = Name.randomFirstName().getDescription();
            case ELEMENTAL -> firstName = Name.randomMonosyllabicFirstName().getDescription();
            case HUMANOID -> firstName = Name.randomFirstName().getDescription();
            default -> firstName = Name.randomFirstName().getDescription();
        }
        return firstName;
    }
}
