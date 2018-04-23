/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dao.interfaces.CatItemDAO;
import dao.modal.CatItem;
import downLayer.CatItemJDBC;
import exception.DatabaseError;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import serviceLayer.interfaces.CatItemService;

/**
 *
 * @author AYUSH
 */
public class CatItemServiceImplementation implements CatItemService{

    @Override
    public void addToDb(CatItem cati) {
        CatItemDAO dao = new CatItemJDBC();
        try {
            dao.write(cati);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CatItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(CatItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public int[] getItemId(int catId) {
        CatItemDAO dao = new CatItemJDBC();
        try {
            CatItem[] collect = dao.read();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < collect.length; i++) {
                if(collect[i].getCat_id() == catId) {
                    list.add(collect[i].getItem_id());
                }
            }
            int[] arr = new int[collect.length];
            for(int i = 0; i < collect.length; i++) {
                arr[i] = list.get(i);
            }
            return arr;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CatItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(CatItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
        }
        
}
    

