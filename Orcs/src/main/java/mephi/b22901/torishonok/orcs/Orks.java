/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mephi.b22901.torishonok.orcs;

import javax.swing.SwingUtilities;

/**
 *
 * @author vikus
 */
public class Orks {

    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            gui.initializeTree(); 
        });
}}
