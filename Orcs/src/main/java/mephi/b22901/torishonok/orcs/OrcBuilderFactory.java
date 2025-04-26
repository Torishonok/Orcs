/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.torishonok.orcs;

/**
 *
 * @author vikus
 */
public class OrcBuilderFactory {
    public static OrkBuilder createBuilder(String tribe) {
        if (tribe == null) {
            throw new IllegalArgumentException("Племя не может быть null");
        }
        switch (tribe) {
            case "Dol Guldur":
                return new DolGuldurOrkBuilder(new DolGuldurGearFactory());
            case "Mordor":
                return new MordorOrkBuilder(new MordorGearFactory());
            case "Misty Mountains":
               return new MistyMountainsOrkBuilder(new MistyMountainsGearFactory());
             default:
                throw new IllegalArgumentException("Неизвестное племя: " + tribe);
        
        }
        
    }
}
