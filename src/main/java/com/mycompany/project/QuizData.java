package com.mycompany.project;

import java.util.ArrayList;

public class QuizData{
    private static ArrayList<String> questions = new ArrayList<>();
    private static ArrayList<String> answers = new ArrayList<>();
    private static ArrayList<String> studentAnswers = new ArrayList<>();
    private static ArrayList<Integer> scores = new ArrayList<>();

    // تهيئة الأسئلة والإجابات الافتراضية
    public static void initializeQuestions() {
        questions.add("What is the capital of France?");
        questions.add("Is Java a programming language? (True/False)");
        questions.add("What is 2 + 2?");
        
        answers.add("Paris");
        answers.add("True");
        answers.add("4");
    }

    // إضافة سؤال جديد
    public static void addQuestion(String question, String answer) {
        questions.add(question);
        answers.add(answer);
    }

    // الحصول على السؤال
    public static String getQuestion(int index) {
        return questions.get(index);
    }

    // الحصول على الإجابة الصحيحة
    public static String getAnswer(int index) {
        return answers.get(index);
    }

    // إضافة إجابة الطالب
    public static void addStudentAnswer(String answer) {
        studentAnswers.add(answer);
    }

    // حساب النتيجة بناءً على الإجابات
    public static int calculateScore() {
        int score = 0;
        for (int i = 0; i < studentAnswers.size(); i++) {
            if (studentAnswers.get(i).equals(answers.get(i))) {
                score++;
            }
        }
        scores.add(score);  // إضافة النتيجة
        return score;
    }

    // الحصول على النتيجة
    public static int getScore(int index) {
        return scores.get(index);
    }

    // الحصول على عدد الأسئلة
    public static int getTotalQuestions() {
        return questions.size();
    }
}
