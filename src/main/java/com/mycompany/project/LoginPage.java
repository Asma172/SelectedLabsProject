package com.mycompany.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    JFrame frame = new JFrame("Login Page");

    public LoginPage() {
        // Create components
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        JLabel roleLabel = new JLabel("Role:");
        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"Admin", "Student"});
        JButton loginButton = new JButton("Login");

        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String role = (String) roleComboBox.getSelectedItem();
                if (role.equals("Admin")) {
                    new AdminPageProxy(role).displayAdminPage(); // Use Proxy
                } else {
                    new QuizPage(); // Open Quiz Page
                }
                frame.dispose();
            }
        });

        // Set layout and add components
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(usernameLabel, gbc);

        gbc.gridx = 1;
        frame.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(passwordLabel, gbc);

        gbc.gridx = 1;
        frame.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(roleLabel, gbc);

        gbc.gridx = 1;
        frame.add(roleComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        frame.add(loginButton, gbc);

        // Customize frame
        frame.getContentPane().setBackground(new Color(224, 255, 255)); // Light cyan background
        loginButton.setBackground(new Color(100, 149, 237)); // Cornflower blue button
        loginButton.setForeground(Color.WHITE); // White text on button

        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage(); // Open Login Page
    }
}