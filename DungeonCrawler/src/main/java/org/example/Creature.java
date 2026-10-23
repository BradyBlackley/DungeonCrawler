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
    Secret secret;

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
        this.secret = generateSecretWithNames();
    }

    public String generateFirstNameByCreatureType() {
        String firstName;
        switch (this.genus) {
            case BEAST, MONSTROSITY -> firstName = NameGenerator.randomGutturalFirstName().getDescription();
            case DRAGON, UNDEAD -> firstName = NameGenerator.randomSinisterFirstName().getDescription();
            case ELEMENTAL, PLANT -> firstName = NameGenerator.randomMonosyllabicFirstName().getDescription();
            default -> firstName = NameGenerator.randomFirstName().getDescription();
        }
        return firstName;
    }

    public String generateSurnameByCreatureType() {
        String surname;
        switch (this.genus) {
            case BEAST, MONSTROSITY -> surname = NameGenerator.randomGutturalSurname().getDescription();
            case DRAGON, UNDEAD -> surname = NameGenerator.randomSinisterSurname().getDescription();
            case ELEMENTAL, PLANT -> surname = NameGenerator.randomMonosyllabicSurname().getDescription();
            default -> surname = NameGenerator.randomSurname().getDescription();
        }
        return surname;
    }

    public Secret generateSecretWithNames() {
        Secret secret1 = SecretGenerator.randomSecret();
        String temp = secret1.getDescription();

        temp = temp.replace("[character]", firstName);
        secret1.setDescription(temp);

        return secret1;
    }
}
