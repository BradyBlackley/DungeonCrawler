package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.CampaignSettings;
import org.example.enums.PlanesCategories;
import org.example.enums.Worlds;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
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
