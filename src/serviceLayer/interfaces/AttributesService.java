/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer.interfaces;

import dao.modal.Attributes;

/**
 *
 * @author AYUSH
 */
public interface AttributesService {
    public void addToDb(Attributes attr);
    public int getAttrValue(int id);
    public String[] getAttributeNames(int id);
}
