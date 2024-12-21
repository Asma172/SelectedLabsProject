package com.mycompany.project;

public class QuestionPrototype implements Cloneable {
    private String question;

    public QuestionPrototype(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public QuestionPrototype clone() throws CloneNotSupportedException {
        return (QuestionPrototype) super.clone();
    }
}
