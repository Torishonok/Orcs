/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.torishonok.orcs;

/**
 *
 * @author vikus
 */
public class DolGuldurOrkFactory implements OrkBuilderFactory {
     @Override
    public OrkBuilder createOrkBuilder() {
        OrkBuilder builder = new OrkBuilder();
        builder.setAttributes("Dol Guldur");
        return builder;
    }
    @Override
    public String getTribe() {
        return "Dol Guldur";
    }
}
