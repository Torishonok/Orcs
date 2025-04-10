/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.torishonok.orcs;

/**
 *
 * @author vikus
 */
public class DolGuldurGearFactory implements OrcGearFactory {
    @Override
    public String createWeapon() {
        return "Spear";
    }

    @Override
    public String createArmor() {
        return "Chain mail";
    }

    @Override
    public String createBanner() {
        return "Banner with a spider";
    }
}
