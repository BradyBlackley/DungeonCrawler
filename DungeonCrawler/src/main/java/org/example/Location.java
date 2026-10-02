package org.example;

import lombok.Data;
import lombok.Getter;
import org.example.enums.CampaignSettings;
import org.example.enums.PlanesCategories;
import org.example.enums.Worlds;

@Data
@Getter
public class Location {

    int id;
    String name;
    String region;
    Worlds world;
    CampaignSettings setting;
    String plane;
    PlanesCategories planeCategory;
    String description;

}
