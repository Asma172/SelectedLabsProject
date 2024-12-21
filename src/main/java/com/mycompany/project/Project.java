
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project;

/**
 *
 * @author BlueLap2
 */
public class Project {

    public static void main(String[] args) throws CloneNotSupportedException {
        new LoginPage();
       
//singleton
QuizManager manager1 = QuizManager.getInstance();
QuizManager manager2 = QuizManager.getInstance();
System.out.println(manager1 == manager2); // يجب أن تطبع true
//factory
//Question mcq = QuestionFactory.createQuestion("MultipleChoice");
//System.out.println(mcq.getQuestionText()); // يجب أن تطبع نص السؤال المتعدد الخيارات
//
//Question trueFalse = QuestionFactory.createQuestion("TrueFalse");
//System.out.println(trueFalse.getQuestionText()); // يجب أن تطبع نص السؤال الصواب أو الخطأ
//Bullider
User user = new User.Builder()
                .setName("John")
                .setRole("Admin")
                .build();
System.out.println(user.getName()); // يجب أن تطبع "John"
System.out.println(user.getRole()); // يجب أن تطبع "Admin"
//Prototype
QuestionPrototype originalQuestion = new QuestionPrototype("What is 2 + 2?");
QuestionPrototype clonedQuestion = originalQuestion.clone();
System.out.println(originalQuestion.getQuestion()); // يجب أن تطبع "What is 2 + 2?"
System.out.println(clonedQuestion.getQuestion()); // يجب أن تطبع نفس الشيء "What is 2 + 2?"
System.out.println(originalQuestion != clonedQuestion); // يجب أن تطبع true لأنهما كائنين منفصلين
//Proxy
AdminPageProxy proxy = new AdminPageProxy("Admin");
proxy.displayAdminPage(); // يجب أن يتم عرض صفحة Admin

AdminPageProxy proxy2 = new AdminPageProxy("Student");
proxy2.displayAdminPage(); // يجب أن يظهر رسالة منع الوصول



    }
}
// User user = new User.Builder()
//                .setName("John Doe")
//                .setRole("Admin")
//                .build();
//QuestionPrototype originalQuestion = new QuestionPrototype("What is the capital of France?");
//QuestionPrototype clonedQuestion = originalQuestion.clone();
//System.out.println(clonedQuestion.getQuestion());