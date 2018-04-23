/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dao.interfaces.SellsDAO;
import dao.modal.Sells;
import downLayer.SellsJDBC;
import exception.DatabaseError;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import serviceLayer.interfaces.SellsService;

/**
 *
 * @author AYUSH
 */
public class SellsServiceImplementation implements SellsService{

    @Override
    public void addToDb(int catId, int itemId,int sellNum, int sellId) {
        SellsDAO dao = new SellsJDBC();
        java.util.Date currentDay = new java.util.Date();
        Date date = new Date(currentDay.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDay);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        Sells sells = new Sells(catId,itemId,date,hours,minutes,seconds,sellNum,sellId);
        try {
            dao.write(sells);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SellsServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(SellsServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public int getSellsId() {
        try {
            SellsDAO dao = new SellsJDBC();
            return dao.getMaxId() + 1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SellsServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(SellsServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public int getNum(int catId, int itemId) {
        SellsDAO dao = new SellsJDBC();
        try {
            Sells[] sells = dao.read();
            int num = 0;
            for(int i = 0; i < sells.length; i++) {
                if(sells[i].getCat_id() == catId && sells[i].getItem_id() == itemId)
                    num += sells[i].getSell_num();
            }
            return num;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SellsServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(SellsServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public int getNum(int itemId, Date date) {
        SellsDAO dao = new SellsJDBC();
        try {
            Sells[] sells = dao.read();
            int num = 0;
            for(int i = 0; i < sells.length; i++) {
                Date sDate = sells[i].getSell_date();
                boolean isSameDay = false;
                if(sDate.getDay() == date.getDay() && sDate.getMonth() == date.getMonth() && sDate.getYear() == date.getYear())
                    isSameDay =true;
                if(sells[i].getItem_id() == itemId && isSameDay)
                    num += sells[i].getSell_num();
            }
            return num;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SellsServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(SellsServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public Sells[] getSells() {
        SellsDAO dao = new SellsJDBC();
        try {
            Sells[] sells = dao.read();
            return sells;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SellsServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(SellsServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }
    
}
