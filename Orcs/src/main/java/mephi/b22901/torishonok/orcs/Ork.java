/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.torishonok.orcs;

/**
 *
 * @author vikus
 */
class Ork {
    private String name;
    private String weapon;
    private String armor;
    private String banner;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Ork(String name, String weapon, String armor, String banner, int strength, int agility, int intelligence, int health) {
        this.name = name;
        this.weapon = weapon;
        this.armor = armor;
        this.banner = banner;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = health;
    }
    public String getName() {
        return name;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getArmor() {
        return armor;
    }

    public String getBanner() {
        return banner;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }

    public String getAttributes() {
        return "Племя: " + banner; // Здесь можно изменить на более подходящее значение
    }

    @Override
    public String toString() {
        return name; // Отображение имени орка в JTree
    }

    
}



    