package org.example;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Character extends Creature implements NPC {

    String background;
    StatBlock stats;

    @Override
    public String describe() {
        return "";
    }

    @Override
    public void generateAttributes() {

    }
}
