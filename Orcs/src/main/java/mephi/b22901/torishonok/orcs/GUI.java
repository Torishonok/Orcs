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
import java.util.HashMap;
import java.util.Map;
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

    public GUI() {
        frame = new JFrame("Армия Мордора");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Создание корневого узла
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

        // Панель для выбора племени и роли
        JPanel controlPanel = new JPanel();
        tribeComboBox = new JComboBox<>(new String[]{"Мордор", "Дол Гулдур", "Мглистые Горы"});
        roleComboBox = new JComboBox<>(new String[]{"Базовый", "Командир", "Разведчик"});
        JButton createButton = new JButton("Создать Орка");

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

        // Панель для отображения информации об орке
        infoArea = new JTextArea();
        infoArea.setEditable(false);

        // Добавление компонентов в окно
        frame.add(new JScrollPane(tree), BorderLayout.WEST);
        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(infoArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void createOrk() {
        String tribe = (String) tribeComboBox.getSelectedItem();
        String role = (String) roleComboBox.getSelectedItem();

        OrkBuilderFactory factory;
        switch (tribe) {
            case "Мордор":
                factory = new MordorOrkFactory();
                break;
            case "Дол Гулдур":
                factory = new DolGuldurOrkFactory();
                break;
            case "Мглистые Горы":
                factory = new MistyMountainsOrkFactory();
                break;
            default:
                throw new IllegalArgumentException("Неизвестное племя: " + tribe);
        }

        OrkDirector director = new OrkDirector(factory);
        Ork newOrk;

        switch (role) {
            case "Базовый":
                newOrk = director.createBasicOrk();
                break;
            case "Командир":
                newOrk = director.createLeaderOrk();
                break;
            case "Разведчик":
                newOrk = director.createScoutOrk();
                break;
            default:
                return;
        }

        // Добавление нового орка в дерево
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
        info.append("Имя: ").append(ork.getName()).append("\n");
        info.append("Племя: ").append(ork.getAttributes()).append("\n");
        info.append("Оружие: ").append(ork.getWeapon()).append("\n");
        info.append("Броня: ").append(ork.getArmor()).append("\n");
        info.append("Знамя: ").append(ork.getBanner()).append("\n");
        info.append("Сила: ").append(ork.getStrength()).append("\n");
        info.append("Ловкость: ").append(ork.getAgility()).append("\n");
        info.append("Интеллект: ").append(ork.getIntelligence()).append("\n");
        info.append("Здоровье: ").append(ork.getHealth()).append("\n");

        infoArea.setText(info.toString());
    }

    public void initializeTree() {
        // Инициализация племен
        DefaultMutableTreeNode mordorNode = new DefaultMutableTreeNode("Мордор");
        DefaultMutableTreeNode dolGuldurNode = new DefaultMutableTreeNode("Дол Гулдур");
        DefaultMutableTreeNode mistyMountainsNode = new DefaultMutableTreeNode("Мглистые Горы");

        rootNode.add(mordorNode);
        rootNode.add(dolGuldurNode);
        rootNode.add(mistyMountainsNode);

        // Обновление модели дерева
        ((DefaultTreeModel) tree.getModel()).reload();
    }

}

