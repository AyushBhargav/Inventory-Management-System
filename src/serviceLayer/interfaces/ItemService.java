/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer.interfaces;

import dao.modal.Item;

/**
 *
 * @author AYUSH
 */
public interface ItemService {
    public Item[] getItems();
    public String[] getItemNameWithStock(String catName);
    public String[] getItemName(String catName);
    public int getId();
    public void addToDb(Item item);
    public double getPrice(String name);
    public int getId(String name);
    public int getSells(String name);
    public int getStock(String name);
    public void updateToDb(Item item);
    public String[] getItemNameWithStock(int catId);
    public double getPrice(int id);
    public int getFrequency(int id);
    public String[] getItemNameWithOutStock();
    public String getItemName(int id);
}
