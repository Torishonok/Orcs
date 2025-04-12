/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.torishonok.orcs;

import com.github.javafaker.Faker;

/**
 *
 * @author vikus
 */
public class OrkDirector {
   private OrkBuilderFactory factory;
   private Faker faker;

    public OrkDirector(OrkBuilderFactory factory) {
        this.factory = factory;
        this.faker = new Faker();
    }

    public Ork createBasicOrk() {
        OrkBuilder builder = factory.createOrkBuilder();
        return builder
                .setName(faker.name().fullName())
                .setAttributes(factory.getTribe())
                .build();
    }

    public Ork createLeaderOrk() {
        OrkBuilder builder = factory.createOrkBuilder();
        return builder
                .setName(faker.name().fullName())
                .setAttributes(factory.getTribe()) 
                .setWeapon("Banner") 
                .build();
    }

    public Ork createScoutOrk() {
        OrkBuilder builder = factory.createOrkBuilder();
        return builder
                .setName(faker.name().fullName())
                .setAttributes(factory.getTribe()) 
                .setWeapon("Bow") 
                .build();
    }
}
