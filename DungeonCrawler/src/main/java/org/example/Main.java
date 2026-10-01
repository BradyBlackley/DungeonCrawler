package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("***************************");
        System.out.println("Welcome to Dungeon Crawler.");
        System.out.println();

        Creature creature = Creature.builder().build();
        creature.generateAttributes();

        System.out.println(creature.describe());

        System.out.println();
        System.out.println("***************************");
    }
}
