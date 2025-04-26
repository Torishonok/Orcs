/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.torishonok.orcs;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author vikus
 */
public class GUI {
     private JFrame frame;
    private JTree tree;
    private JTextArea infoArea;
    private JComboBox<String> tribeComboBox;
    private JComboBox<String> roleComboBox;
    private DefaultMutableTreeNode rootNode;
    private String name;
    private String weapon;
    private String armor;
    private String banner;
    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public GUI() {
        frame = new JFrame("Армия Мордора");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        rootNode = new DefaultMutableTreeNode("Армия Мордора");
        tree = new JTree(rootNode);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode != null && selectedNode.getUserObject() instanceof Ork) {
                    Ork selectedOrk = (Ork) selectedNode.getUserObject();
                    displayOrkInfo(selectedOrk);
                }
            }
        });

        JPanel controlPanel = new JPanel();
        tribeComboBox = new JComboBox<>(new String[]{"Mordor", "Dol Guldur", "Misty Mountains"});
        roleComboBox = new JComboBox<>(new String[]{"Basic", "Leader", "Scout"});
        JButton createButton = new JButton("Creature Orc");

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createOrk();
            }
        });

        controlPanel.add(new JLabel("Племя:"));
        controlPanel.add(tribeComboBox);
        controlPanel.add(new JLabel("Роль:"));
        controlPanel.add(roleComboBox);
        controlPanel.add(createButton);

        infoArea = new JTextArea();
        infoArea.setEditable(false);

        frame.add(new JScrollPane(tree), BorderLayout.WEST);
        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(infoArea), BorderLayout.CENTER);

        frame.setVisible(true);
        initializeTree();
    }

    private void createOrk() {
        String tribe = (String) tribeComboBox.getSelectedItem();
        String role = (String) roleComboBox.getSelectedItem();

        OrkBuilder factory = OrcBuilderFactory.createBuilder(tribe);
        if (factory == null) {
        System.out.println("Не удалось создать строителя орков для племени: " + tribe);
        return;
    }
        /*if (tribe.equals("Мордор")) {
            factory = new MordorOrkBuilder<>(new MordorGearFactory());
        } else if (tribe.equals("Дол Гулдур")) {
            factory = new DolGuldurOrkBuilder<>(new DolGuldurGearFactory());
        } else if (tribe.equals("Мглистые Горы")) {
            factory = new MistyMountainsOrkBuilder<>(new MistyMountainsGearFactory());
        } else {
            throw new IllegalArgumentException("Неизвестное племя: " + tribe);
        }*/

        OrkDirector director = new OrkDirector();
        director.setOrkBuilder(factory);
        Ork newOrk = null;

        if (role.equals("Basic")) {
            director.createBasicOrk();
            newOrk = director.getOrk();
        } else if (role.equals("Leader")) {
            director.createLeaderOrk();
            newOrk = director.getOrk();
        } else if (role.equals("Scout")) {
            director.createScoutOrk();
            newOrk = director.getOrk();
        } else {
            return;
        }

        DefaultMutableTreeNode tribeNode = findTribeNode(tribe);
        if (tribeNode != null) {
            tribeNode.add(new DefaultMutableTreeNode(newOrk));
            ((DefaultTreeModel) tree.getModel()).reload(tribeNode);
        }
    }

    private DefaultMutableTreeNode findTribeNode(String tribe) {
        for (int i = 0; i < rootNode.getChildCount(); i++) {
            DefaultMutableTreeNode tribeNode = (DefaultMutableTreeNode) rootNode.getChildAt(i);
            if (tribeNode.getUserObject().equals(tribe)) {
                return tribeNode;
            }
        }
        return null;
    }   
    private void displayOrkInfo(Ork ork) {
        StringBuilder info = new StringBuilder();
        info.append("Name: ").append(ork.getName()).append("\n");
        info.append("Weapon: ").append(ork.getWeapon()).append("\n");
        info.append("Armor: ").append(ork.getArmor()).append("\n");
        info.append("Banner: ").append(ork.getBanner()).append("\n");
        info.append("Strength: ").append(ork.getStrength()).append("\n");
        info.append("Agility: ").append(ork.getAgility()).append("\n");
        info.append("Intelligence: ").append(ork.getIntelligence()).append("\n");
        info.append("Health: ").append(ork.getHealth()).append("\n");

        infoArea.setText(info.toString());
    }

    public void initializeTree() {
        
        DefaultMutableTreeNode mordorNode = new DefaultMutableTreeNode("Mordor");
        DefaultMutableTreeNode dolGuldurNode = new DefaultMutableTreeNode("Dol Guldur");
        DefaultMutableTreeNode mistyMountainsNode = new DefaultMutableTreeNode("Misty Mountains");

        rootNode.add(mordorNode);
        rootNode.add(dolGuldurNode);
        rootNode.add(mistyMountainsNode);

        
        ((DefaultTreeModel) tree.getModel()).reload();
    }

}

