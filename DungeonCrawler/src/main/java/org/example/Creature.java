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
        sb.append("A ")
                .append(size.getDescription())
                .append(" ")
                .append(alignment.getDescription())
                .append(" ")
                .append(subtype.getDescription())
                .append(" ")
                .append("with ")
                .append(appearance.getDescription())
                .append(" ")
                .append("named ")
                .append(firstName)
                .append(" ")
                .append(surname)
                .append(".");
        return sb.toString();
    }

    @Override
    public void generateAttributes() {
        this.firstName = Name.randomFirstName().getDescription();
        this.surname = Name.randomSurname().getDescription();
        this.size = Size.randomSize();
        this.subtype = CreatureType.randomCreatureType();
        this.alignment = Alignment.randomAlignment();
        this.appearance = Appearance.randomAppearance();
    }
}
