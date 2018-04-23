/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer.interfaces;

import dao.modal.CatItem;

/**
 *
 * @author AYUSH
 */
public interface CatItemService {
    public void addToDb(CatItem cati);
    public int[] getItemId(int catId);
}
