/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer.interfaces;

import dao.modal.User;

/**
 *
 * @author AYUSH
 */
public interface SignIn {
    public boolean isCorrect(User user);
    public String getUserName(String password);
    public void updateToDb(User user);
    public String getPassword(String userName);
}
