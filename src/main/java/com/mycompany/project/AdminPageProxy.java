/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import javax.swing.JOptionPane;

/**
 *
 * @author BlueLap2
 */
public class AdminPageProxy {
    private boolean isAdmin;

    public AdminPageProxy(String role) {
        this.isAdmin = role.equals("Admin");
    }

    public void displayAdminPage() {
        if (isAdmin) {
            new AdminPage(); // فتح صفحة الإدارة
        } else {
            JOptionPane.showMessageDialog(null, "Access Denied! You are not an Admin.");
        }
    }
}

