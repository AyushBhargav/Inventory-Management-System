/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceLayer;

import Jama.Matrix;
import dao.interfaces.SellsDAO;
import dao.modal.Sells;
import downLayer.SellsJDBC;
import exception.DatabaseError;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import serviceLayer.interfaces.ItemService;
import serviceLayer.interfaces.LinearRegressionInterface;
import serviceLayer.interfaces.PredictionService;

/**
 *
 * @author AYUSH
 */
public class PredictionServiceImplementation implements PredictionService{

    @Override
    public double calculateProfit(double[] x1) {
        SellsDAO dao = new SellsJDBC();
        try {
            Sells[] collect = dao.read();
            double[][] matrix = new double[collect.length][6];
            double[][] profit = new double[collect.length][1];
            ItemService is = new ItemServiceImplementation();
            for(int i = 0; i < collect.length; i++) {
                matrix[i][0] = 1; // For offset.
                matrix[i][1] = collect[i].getCat_id();
                matrix[i][2] = collect[i].getItem_id();
                matrix[i][3] = collect[i].getSell_num();
                // Getting information from Item Service
                double price = is.getPrice(collect[i].getItem_id());
                matrix[i][4] = price;
                int frequency = is.getFrequency(collect[i].getItem_id());
                matrix[i][5] = frequency;
                // Getting profit for Y
                profit[i][0] = price * collect[i].getSell_num();
            }
            Matrix x = new Matrix(matrix);
            
            Matrix y = new Matrix(profit);
            LinearRegressionInterface lri = new LinearRegressionImplementation();
            System.out.println(profit[0][0]);
            double y1 = lri.getPrediction(x, y, x1);
            return y1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PredictionServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        } catch (SQLException ex) {
            Logger.getLogger(PredictionServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseError();
        }
    }
    
}
