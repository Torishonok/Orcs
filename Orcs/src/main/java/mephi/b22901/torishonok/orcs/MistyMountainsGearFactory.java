/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.torishonok.orcs;

/**
 *
 * @author vikus
 */
public class MistyMountainsGearFactory implements OrcGearFactory {
     @Override
    public Weapon createWeapon() {
        return new Axe();
    }

    @Override
    public Armor createArmor() {
        return new LeatherArmor();
    }

    @Override
    public Banner createBanner() {
        return new MistyMountainsBanner();
    }
}
