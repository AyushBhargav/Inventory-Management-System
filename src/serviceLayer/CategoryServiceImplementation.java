/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dao.interfaces.CatItemDAO;
import dao.interfaces.CategoryDAO;
import dao.modal.CatItem;
import dao.modal.Category;
import downLayer.CatItemJDBC;
import downLayer.CategoryJDBC;
import exception.DatabaseError;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import serviceLayer.interfaces.CategoryService;
import serviceLayer.interfaces.ItemService;

/**
 *
 * @author AYUSH
 */
public class CategoryServiceImplementation implements CategoryService{

    @Override
    public Category[] getCategory() {
        CategoryDAO catdao = new CategoryJDBC();
        try {
            Category[] collect = catdao.read();
            ArrayList<Category> al = new ArrayList<>();
            for(int i = 0; i > collect.length; i++) {
                if(collect[i].getStock() > 0)
                    al.add(collect[i]);
            }
            Category[] catArr = new Category[al.size()];
            for(int i = 0; i < al.size(); i++) {
                catArr[i] = (Category)al.get(i);
            }
            return catArr;
        } catch(Exception e) {
            throw new DatabaseError();
        }
    }

    @Override
    public String[] getCatNamesWithStock() {
        CategoryDAO catdao = new CategoryJDBC();
        try {
            Category[] collect = catdao.read();
            ArrayList<String> al = new ArrayList<>();
            for(int i = 0; i < collect.length; i++) {
                if(collect[i].getStock() > 0)
                    al.add(collect[i].getName());
            }
            String[] str = new String[al.size()];
            for(int i = 0; i < al.size(); i++) {
                str[i] = al.get(i);
            }
            return str;
        } catch(Exception e) {
            throw new DatabaseError();
        }
    }
    
    public int getId() {
        CategoryDAO catdao = new CategoryJDBC();
        int id;
        try {
            id = catdao.getMaxCatId() + 1;
            return id;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }
    
    public void addToDb(Category cat) {
        CategoryDAO dao = new CategoryJDBC();
        try {
            dao.write(cat);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }
    
    public int getId(String name) {
        CategoryDAO dao = new CategoryJDBC();
        try {
            Category[] collect = dao.read();
            int id = -1;
            for(int i = 0; i < collect.length; i++) {
                if(collect[i].getName().equals(name)) {
                    id = collect[i].getId();
                }
            }
            // only for precaution, will never happen
            if(id == -1) {
                throw new DatabaseError();
            }
            
            return id;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }
    
    public int getFrequency(int id) {
        CategoryDAO dao = new CategoryJDBC();
        try {
            Category[] collect = dao.read();
            for(int i = 0; i < collect.length; i++) {
                if(collect[i].getId() == id) 
                    return collect[i].getFrequency();
            }
                throw new DatabaseError();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }
    
    public int getStock(int id) {
        CategoryDAO dao = new CategoryJDBC();
        try {
            Category[] collect = dao.read();
            for(int i = 0; i < collect.length; i++) {
                if(collect[i].getId() == id) 
                    return collect[i].getStock();
            }
                throw new DatabaseError();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }
    
    public void updateToDb(Category cat) {
        CategoryDAO dao = new CategoryJDBC();
        try {
            dao.update(cat.getId(), cat);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public String[] getCatNames() {
        CategoryDAO catdao = new CategoryJDBC();
        try {
            Category[] collect = catdao.read();
            ArrayList<String> al = new ArrayList<>();
            for(int i = 0; i < collect.length; i++) {
                    al.add(collect[i].getName());
            }
            String[] str = new String[al.size()];
            for(int i = 0; i < al.size(); i++) {
                str[i] = al.get(i);
            }
            return str;
        } catch(Exception e) {
            throw new DatabaseError();
        }
    }

    
    
    
    @Override
    public String[] getCatNames(String[] itemName) {
        CatItemDAO cidao = new CatItemJDBC();
        try {
            CatItem[] ci = cidao.read();
            ItemService is = new ItemServiceImplementation();
            ArrayList<String> al = new ArrayList<>();
            CategoryService cs = new CategoryServiceImplementation();
            CategoryDAO cdao = new CategoryJDBC();
            Category[] cat = cdao.read();
            for(int i = 0 ; i < itemName.length; i++) {
                int id = is.getId(itemName[i]);
                int catId;
                for(int j = 0; j < ci.length; j++) {
                    if(ci[j].getItem_id() == id) {
                        for(int k = 0; k < cat.length; k++) {
                            if(cat[k].getId() == ci[j].getCat_id()) {
                                al.add(cat[k].getName());
                            }
                        }
                    }
                }
            }
            String[] str = new String[al.size()];
            for(int i = 0; i < str.length; i++) {
                str[i] = al.get(i);
            }
            return str;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
        
    }

    @Override
    public String getCatName(int catId) {
        CategoryDAO catdao = new CategoryJDBC();
        try {
            Category[] collect = catdao.read();
            for(int i = 0; i < collect.length; i++) {
                    if(catId == collect[i].getId())
                        return collect[i].getName();
            }
            throw new DatabaseError();
        } catch(Exception e) {
            throw new DatabaseError();
        }
    }
}
