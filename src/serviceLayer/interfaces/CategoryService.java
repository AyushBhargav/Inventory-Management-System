/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer.interfaces;

import dao.modal.Category;

/**
 *
 * @author AYUSH
 */
public interface CategoryService {
    public Category[] getCategory();
    public String[] getCatNamesWithStock();
    public int getId();
    public void addToDb(Category cat);
    public int getId(String name);
    public int getFrequency(int id);
    public int getStock(int id);
    public void updateToDb(Category cat);
    public String[] getCatNames();
    public String[] getCatNames(String[] itemName);
    public String getCatName(int catId);
}
