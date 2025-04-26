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
public class OrkNames {
    
    private static final Faker faker = new Faker(); 

    public String generateName() {
        Random random = new Random();
        String orkName = faker.name().fullName();
        return orkName;
    }
}
