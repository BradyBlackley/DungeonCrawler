package org.example;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Entity {

    protected String name;
    protected String description;

}
