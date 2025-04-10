/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.torishonok.orcs;

/**
 *
 * @author vikus
 */
  public class MordorGearFactory implements OrcGearFactory {
    @Override
    public String createWeapon() {
        return "Heavy Sword";
    }

    @Override
    public String createArmor() {
        return "Steel armor";
    }

    @Override
    public String createBanner() {
        return "Banner with the Red Eye";
    }
}  
