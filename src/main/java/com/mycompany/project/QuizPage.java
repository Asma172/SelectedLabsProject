package com.mycompany.project;

import javax.swing.*;
import java.awt.*;

class QuizPage {
    private JFrame frame;
    private JLabel questionLabel;
    private ButtonGroup optionsGroup;
    private JButton nextButton;
    private JRadioButton option1, option2, option3, option4;

    private String[] questions = {
            "What is the number of principles in SOLID programming?",
            "Adapter pattern part of the Creational design pattern family?",
            "Which design patterns belong to the structural family?"
    };

    private String[][] options = {
            {"3", "4", "5", "6"},
            {"True", "False", "Maybe", "Not Sure"},
            {"Singelton", "Factory", "Adapter", "Builder"}
    };

    private String[] correctAnswers = {"5", "False", "Adapter"};
    private int currentQuestion = 0;
    private int score = 0;

    public QuizPage() {
        frame = new JFrame("Quiz Page");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(60, 130, 200));
        JLabel headerLabel = new JLabel("Quiz Time!");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        frame.add(headerPanel, BorderLayout.NORTH);

        // Question Panel
        JPanel questionPanel = new JPanel();
        questionPanel.setBackground(new Color(240, 248, 255));
        questionPanel.setLayout(new GridLayout(5, 1));

        questionLabel = new JLabel(questions[currentQuestion], SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionPanel.add(questionLabel);

        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();

        optionsGroup = new ButtonGroup();
        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);

        questionPanel.add(option1);
        questionPanel.add(option2);
        questionPanel.add(option3);
        questionPanel.add(option4);

        frame.add(questionPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(60, 130, 200));
        
        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setBackground(new Color(30, 144, 255));
        nextButton.setForeground(Color.WHITE);
        
        buttonPanel.add(nextButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        loadQuestion();

        nextButton.addActionListener(e -> {
            checkAnswer();
            currentQuestion++;
            if (currentQuestion < questions.length) {
                loadQuestion();
            } else {
                JOptionPane.showMessageDialog(frame, "Quiz Finished! Your score: " + score);
                frame.dispose();
                new ResultPage(score, questions.length);
            }
        });

        frame.setVisible(true);
    }

    private void loadQuestion() {
        questionLabel.setText(questions[currentQuestion]);
        option1.setText(options[currentQuestion][0]);
        option2.setText(options[currentQuestion][1]);
        option3.setText(options[currentQuestion][2]);
        option4.setText(options[currentQuestion][3]);
        optionsGroup.clearSelection();
    }

    private void checkAnswer() {
        String selectedAnswer = null;
        if (option1.isSelected()) {
            selectedAnswer = option1.getText();
        } else if (option2.isSelected()) {
            selectedAnswer = option2.getText();
        } else if (option3.isSelected()) {
            selectedAnswer = option3.getText();
        } else if (option4.isSelected()) {
            selectedAnswer = option4.getText();
        }

        if (selectedAnswer != null && selectedAnswer.equals(correctAnswers[currentQuestion])) {
            score++;
        }
    }
}
