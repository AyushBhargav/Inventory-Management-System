/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims;

import presentationLayer.LogWindow;

/**
 *
 * @author AYUSH
 */
public class IMS {

    
    public static void main(String[] args) {
        LogWindow app;
        app = new LogWindow();
        app.show();
        app.setVisible(true);
        app.setResizable(false);
    }
    
}
