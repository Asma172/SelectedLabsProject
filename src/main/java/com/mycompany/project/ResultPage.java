package com.mycompany.project;

import javax.swing.*;
import java.awt.*;

class ResultPage {
    private JFrame frame;

    public ResultPage(int score, int totalQuestions) {
        frame = new JFrame("Results");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Header with custom background color
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 128, 128)); // Teal
        JLabel headerLabel = new JLabel("Quiz Results", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        // Main content panel
        JPanel contentPanel = new JPanel(new GridLayout(2, 1));
        contentPanel.setBackground(new Color(240, 240, 240)); // Light gray

        JLabel resultLabel = new JLabel("Your Score: " + score + " / " + totalQuestions, SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(new Color(50, 50, 50)); // Dark gray

        JButton closeButton = new JButton("Close");
        closeButton.setBackground(new Color(220, 20, 60)); // Crimson
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.addActionListener(e -> frame.dispose());

        contentPanel.add(resultLabel);
        contentPanel.add(closeButton);

        // Add panels to frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
