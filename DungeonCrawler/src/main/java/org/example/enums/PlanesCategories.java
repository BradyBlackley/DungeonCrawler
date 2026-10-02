package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum PlanesCategories {

    MATERIAL_REALMS("Material Realms"),
    TRANSITIVE_PLANES("Transitive Planes"),
    INNER_PLANES("Inner Planes"),
    OUTER_PLANES("Outer Planes"),
    POSITIVE_AND_NEGATIVE_PLANES("Positive and Negative Planes");

    private final String description;

}
