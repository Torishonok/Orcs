/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.torishonok.orcs;

import com.github.javafaker.Faker;
import java.util.Random;

/**
 *
 * @author vikus
 */
public class OrkBuilder {
    private String name;
    private String weapon;
    private String armor;
    private String banner;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    private static final Random random = new Random();
    private static final Faker faker = new Faker();

    public OrkBuilder setName(String name) {
        this.name = name;
        return this;
    }
    
    
    
    public OrkBuilder setWeapon(String weapon) {
        this.weapon = weapon;
        return this;
    }


    public OrkBuilder setAttributes(String tribe) {
        OrcGearFactory gearFactory;
        
        switch (tribe) {
            case "Mordor":
                gearFactory = new MordorGearFactory();
                this.strength = (int) (random.nextInt(100) * 1.3);
                this.agility = (int) (random.nextInt(100) * 0.7);
                this.intelligence = random.nextInt(50) + 1;
                this.health = random.nextInt(151) + 50; 
                break;
            case "Dol Guldur":
                gearFactory = new DolGuldurGearFactory();
                this.strength = random.nextInt(100) + 1;
                this.agility = random.nextInt(100) + 1;
                this.intelligence = random.nextInt(50) + 1;
                this.health = random.nextInt(151) + 50; 
                break;
            case "Misty Mountains":
                gearFactory = new MistyMountainsGearFactory();
                this.strength = (int) (random.nextInt(100) * 0.7);
                this.agility = (int) (random.nextInt(100) * 1.3);
                this.intelligence = (int) (random.nextInt(50) * 0.7);
                this.health = random.nextInt(151) + 50; 
                break;
            default:
                throw new IllegalArgumentException("Unknown tribe");
        }
        this.weapon = gearFactory.createWeapon();
        this.armor = gearFactory.createArmor();
        this.banner = gearFactory.createBanner();
        return this;
    }

    public Ork build() {
        if (name == null) {
            name = faker.name().fullName(); 
        }
        return new Ork(name, weapon, armor, banner, strength, agility, intelligence, health);
    }
}
