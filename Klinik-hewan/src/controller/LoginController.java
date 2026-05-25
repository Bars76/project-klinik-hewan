/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDAO;

public class LoginController {

    private UserDAO userDao;

    public LoginController() {
        userDao = new UserDAO();
    }

    public boolean login(String username, String password) {
        return userDao.login(username, password);
    }
}