package com.mycompany.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ScoreManager {
    // متغير static للاحتفاظ بالنسخة الوحيدة
    private static ScoreManager instance;
    private Connection connection;

    // Constructor خاص لمنع إنشاء نسخ جديدة
    private ScoreManager() {
        // تهيئة الاتصال بقاعدة البيانات
        try {
            String url = "jdbc:mysql://localhost:3306/quiz_system";
            String user = "root";
            String password = "your_password";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // دالة public static للحصول على النسخة الوحيدة
    public static ScoreManager getInstance() {
        if (instance == null) {
            instance = new ScoreManager();
        }
        return instance;
    }

    // دالة لحساب الدرجات
    public void calculateScore(int quizId, int userId, int score) {
        // كود حساب الدرجات وتخزينها في قاعدة البيانات
        String sql = "INSERT INTO User_Quiz_Results (user_id, quiz_id, score) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, quizId);
            pstmt.setInt(3, score);
            pstmt.executeUpdate();
            System.out.println("Score stored for user " + userId + " in quiz " + quizId + ": " + score);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // دالة لتخزين النتائج
    public void storeResults(int quizId, int userId, int score) {
        // كود تخزين النتائج
        calculateScore(quizId, userId, score);
    }
}

