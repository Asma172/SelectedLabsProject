package com.mycompany.project;

import javax.swing.*;
import java.awt.*;

class AdminPage {
    private JFrame frame;
    private JTextField questionField;
    private JComboBox<String> questionTypeComboBox;
    private JButton addButton, backButton;

    public AdminPage() {
        // Frame setup
        frame = new JFrame("Admin Page");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(60, 179, 113)); // Green
        JLabel title = new JLabel("Admin Panel - Add Questions", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(Color.WHITE);
        titlePanel.add(title);

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(new Color(245, 245, 245)); // Light Gray

        JLabel questionLabel = new JLabel("Enter Question:");
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        questionField = new JTextField();

        JLabel questionTypeLabel = new JLabel("Select Question Type:");
        questionTypeLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        questionTypeComboBox = new JComboBox<>(new String[]{"Multiple Choice", "True/False", "Short Answer"});

        addButton = new JButton("Create Question");
        addButton.setBackground(new Color(30, 144, 255)); // Blue
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setFont(new Font("Arial", Font.BOLD, 14));

        backButton = new JButton("Logout");
        backButton.setBackground(new Color(255, 69, 0)); // Red
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(questionLabel);
        formPanel.add(questionField);
        formPanel.add(questionTypeLabel);
        formPanel.add(questionTypeComboBox);
        formPanel.add(new JLabel()); // Empty space for alignment
        formPanel.add(addButton);
        formPanel.add(new JLabel()); // Empty space for alignment
        formPanel.add(backButton);

        // Adding components to the frame
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(formPanel, BorderLayout.CENTER);

        // Event Listeners
        backButton.addActionListener(e -> {
            frame.dispose();
            new LoginPage();
        });

        addButton.addActionListener(e -> {
            if (!questionField.getText().trim().isEmpty()) {
                String questionType = (String) questionTypeComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(frame, "Question Added: " + questionField.getText() + "\nType: " + questionType);
                questionField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a question.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AdminPage();
    }
}