/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import dao.interfaces.CatItemDAO;
import dao.interfaces.ItemDAO;
import dao.modal.CatItem;
import dao.modal.Category;
import dao.modal.Item;
import downLayer.CatItemJDBC;
import downLayer.ItemJDBC;
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
public class ItemServiceImplementation implements ItemService{

    @Override
    public Item[] getItems() {
       ItemDAO idao = new ItemJDBC();
        try {
            Item[] itemCollect = idao.read();
            return itemCollect;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public String[] getItemNameWithStock(String catName) {
        Item[] itemCollect = getItems();
        ArrayList<Item> ia = new ArrayList<>();
        CategoryService cs = new CategoryServiceImplementation();
        Category[] catCollect;
        catCollect = cs.getCategory();
        ArrayList<String> itemName = new ArrayList<>();
        try {
            CatItem[] ci = (new CatItemJDBC()).read();
            for(int i = 0; i < catCollect.length; i++) {
                if(catCollect[i].getName() == catName) {
                    for(int j = 0; j < ci.length; j++) {
                        if(ci[j].getCat_id() == catCollect[i].getId()) {
                            for(int k = 0; k < itemCollect.length; k++) {
                                if(itemCollect[k].getId() == ci[j].getItem_id() && itemCollect[k].getStock() > 0) {
                                    itemName.add(itemCollect[k].getName());
                                } 
                            }
                        }
                    }
                }
            
            }
            String[] names = new String[itemName.size()];
            for(int i = 0; i < names.length; i ++) {
                names[i] = itemName.get(i);
            }
            return names;
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }
    
    @Override
    public int getId() {
        ItemDAO dao = new ItemJDBC();
        try {
            int id = dao.getMaxId() + 1;
            return id;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public void addToDb(Item item) {
        ItemDAO dao = new ItemJDBC();
        try {
            dao.write(item);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public double getPrice(String name) {
        ItemDAO dao = new ItemJDBC();
        try {
            Item[] collect = dao.read();
            for(int i = 0; i < collect.length; i++) {
                if(collect[i].getName().equals(name))
                    return collect[i].getPrice();
            }
            throw new DatabaseError();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
        
    }

    @Override
    public int getId(String name) {
        ItemDAO dao = new ItemJDBC();
        try {
            Item[] collect = dao.read();
            for(int i = 0; i < collect.length; i++) {
                System.out.println(collect[i].getName());
                if(collect[i].getName().equals(name))
                    return collect[i].getId();
            }
            throw new DatabaseError();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
        
    }

    @Override
    public int getSells(String name) {
        ItemDAO dao = new ItemJDBC();
        try {
            Item[] collect = dao.read();
            for(int i = 0; i < collect.length; i++) {
                if(collect[i].getName().equals(name))
                    return collect[i].getFrequency();
            }
            throw new DatabaseError();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public int getStock(String name) {
        ItemDAO dao = new ItemJDBC();
        try {
            Item[] collect = dao.read();
            for(int i = 0; i < collect.length; i++) {
                if(collect[i].getName().equals(name))
                    return collect[i].getStock();
            }
            throw new DatabaseError();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public void updateToDb(Item item) {
        ItemDAO dao = new ItemJDBC();
        try {
            dao.update(item.getId(), item);
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public String[] getItemNameWithStock(int catId) {
        ItemDAO idao = new ItemJDBC();
        CatItemDAO cidao = new CatItemJDBC();
        ArrayList<Integer> itemId = new ArrayList<>();
        CatItem[] catItem;
        try {
            catItem = cidao.read();
            for(int i = 0 ; i < catItem.length; i++) {
                if(catItem[i].getCat_id() == catId)
                    itemId.add(catItem[i].getItem_id());
            }
            String[] names = new String[itemId.size()];
            for(int i = 0; i < names.length; i++) {
                names[i] = idao.getName(itemId.get(i));
            }
            return names;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
        
    }

    @Override
    public double getPrice(int id) {
        ItemDAO dao = new ItemJDBC();
        try {
            Item[] collect = dao.read();
            for(int i = 0; i < collect.length; i++) {
                if(collect[i].getId() == id)
                    return collect[i].getPrice();
            }
            throw new DatabaseError();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
        
    }

    @Override
    public int getFrequency(int id) {
        ItemDAO dao = new ItemJDBC();
        try {
            Item[] collect = dao.read();
            for(int i = 0; i < collect.length; i++) {
                if(collect[i].getId() == id)
                    return collect[i].getFrequency();
            }
            throw new DatabaseError();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public String[] getItemName(String catName) {
        CategoryService cs = new CategoryServiceImplementation();
        int catId = cs.getId(catName);
        ItemDAO idao = new ItemJDBC();
        CatItemDAO cidao = new CatItemJDBC();
        ArrayList<Integer> itemId = new ArrayList<>();
        CatItem[] catItem;
        try {
            catItem = cidao.read();
            for(int i = 0 ; i < catItem.length; i++) {
                if(catItem[i].getCat_id() == catId)
                    itemId.add(catItem[i].getItem_id());
            }
            String[] names = new String[itemId.size()];
            for(int i = 0; i < names.length; i++) {
                names[i] = idao.getName(itemId.get(i));
            }
            return names;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }

    @Override
    public String[] getItemNameWithOutStock() {
        ItemDAO dao = new ItemJDBC();
        try {
            Item[] item = dao.read();
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < item.length; i++) {
                if(item[i].getStock() == 0) {
                    list.add(item[i].getName());
                }
            }
            String[] str = new String[list.size()];
            for(int i = 0; i < str.length; i++) {
                str[i] = list.get(i);
            }
            return str;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
        
    }

    @Override
    public String getItemName(int id) {
        ItemDAO dao = new ItemJDBC();
        try {
            Item[] arr = dao.read();
            for(int i = 0 ; i < arr.length; i++) {
                if(arr[i].getId() == id)
                    return arr[i].getName();
            }
            throw new DatabaseError();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }
}
