/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dao.interfaces.AttributeDAO;
import dao.modal.Attributes;
import downLayer.AttributeJDBC;
import exception.DatabaseError;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import serviceLayer.interfaces.AttributesService;

/**
 *
 * @author AYUSH
 */
public class AttributesServiceImplementation implements AttributesService{

    @Override
    public void addToDb(Attributes attr) {
        AttributeDAO dao = new AttributeJDBC();
        try {
            dao.write(attr);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttributesServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(AttributesServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }
    
    public int getAttrValue(int id) {
        AttributeDAO dao = new AttributeJDBC();
        try {
            int attrValue = dao.getMaxAttrValue(id) + 1;
            return attrValue;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttributesServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(AttributesServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
        
    }

    @Override
    public String[] getAttributeNames(int id) {
        AttributeDAO dao = new AttributeJDBC();
        try {
            Attributes[] collect = dao.read();
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < collect.length; i++) {
                if(collect[i].getItem_id() == id)
                    list.add(collect[i].getName());
            }
            String[] names = new String[list.size()];
            for(int i = 0; i < names.length; i++) {
                names[i] = list.get(i);
            }
            return names;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttributesServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(AttributesServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
        
    }
    
}
