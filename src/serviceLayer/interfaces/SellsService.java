/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer.interfaces;

import dao.modal.Sells;
import java.sql.Date;

/**
 *
 * @author AYUSH
 */
public interface SellsService {
    public void addToDb(int catId, int itemId, int sellNum, int sellId);
    public int getSellsId();
    public int getNum(int catId, int itemId);
    public int getNum(int itemId, Date date);
    public Sells[] getSells();
}
