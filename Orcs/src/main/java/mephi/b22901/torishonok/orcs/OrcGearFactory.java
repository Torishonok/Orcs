/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.torishonok.orcs;

/**
 *
 * @author vikus
 */
public interface OrcGearFactory {
    public Weapon createWeapon();
    public Armor createArmor();
    public Banner createBanner();
    default public Bow createBow(){
        return new Bow();
    }
}
