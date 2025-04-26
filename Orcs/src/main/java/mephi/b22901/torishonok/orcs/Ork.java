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
    
 
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setWeapon(String weapon){
        this.weapon = weapon;
    }

    public String getWeapon() {
        return weapon;
    }
    
    public void setArmor(String armor){
        this.armor = armor;
    }

    public String getArmor() {
        return armor;
    }
    
    public void setBanner(String banner){
        this.banner = banner;
    }

    public String getBanner() {
        if (banner == null){
            return "not a leader";
        }else{
        return banner;
        }
    }
    
    public void setStrength(int strength){
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }
    
    public void setAgility(int agility){
        this.agility = agility;
    }

    public int getAgility() {
        return agility;
    }
    
    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }

    public int getIntelligence() {
        return intelligence;
    }
    
    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return name; 
    }
    
}



    