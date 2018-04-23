/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dao.interfaces.LogDAO;
import dao.modal.Log;
import dao.modal.User;
import downLayer.LogJDBC;
import exception.DatabaseError;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import serviceLayer.interfaces.SignIn;

/**
 *
 * @author AYUSH
 */
public class SignInImplementation implements SignIn{

    @Override
    public boolean isCorrect(User user) {
        LogDAO dao = new LogJDBC();
        try {
            Log[] log = dao.read();
            for(int i = 0; i < log.length; i++) {
                if(user.getName().equals(log[i].getUsername()) && user.getPassword().equals(log[i].getPassword())) {
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignInImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(SignInImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
        
    }

    @Override
    public String getUserName(String password) {
        LogDAO dao = new LogJDBC();
        try {
            Log[] log = dao.read();
            for(int i = 0; i < log.length; i++) {
                if(log[i].getPassword().equals(password))
                    return log[i].getUsername();
            }
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignInImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(SignInImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
        
    }

    @Override
    public void updateToDb(User user) {
        LogDAO dao = new LogJDBC();
        Log log = new Log(user.getName(), user.getPassword());
        try {
            dao.update(user.getName(),log);
        } catch (SQLException ex) {
            Logger.getLogger(SignInImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignInImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public String getPassword(String userName) {
        LogDAO dao = new LogJDBC();
        try {
            Log[] log = dao.read();
            for(int i = 0; i < log.length; i++) {
                if(log[i].getUsername().equals(userName))
                    return log[i].getPassword();
            }
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignInImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(SignInImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }
    
}
