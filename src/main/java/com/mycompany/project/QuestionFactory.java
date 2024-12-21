/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

/**
 *
 * @author BlueLap2
 */public class QuestionFactory {
    public static Question createQuestion(String type) {
        switch (type) {
            case "MultipleChoice":
                return new MultipleChoiceQuestion();
            case "TrueFalse":
                return new TrueFalseQuestion();
            default:
                throw new IllegalArgumentException("Invalid question type");
        }
    }
}