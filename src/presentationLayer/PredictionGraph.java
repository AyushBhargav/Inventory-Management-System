/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import dao.interfaces.SellsDAO;
import dao.modal.Item;
import dao.modal.Sells;
import downLayer.SellsJDBC;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import serviceLayer.ItemServiceImplementation;
import serviceLayer.SellsServiceImplementation;
import serviceLayer.interfaces.ItemService;
import serviceLayer.interfaces.SellsService;

/**
 *
 * @author AYUSH
 */
public class PredictionGraph extends ApplicationFrame{
    private double y1;
    private int id;
    public PredictionGraph( String applicationTitle , String chartTitle ,double y, int i) {
      super(applicationTitle);
      y1 = y;
      id = i;
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Order","Rs.",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
      
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }
    
    private DefaultCategoryDataset createDataset( )
   {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      SellsDAO dao = new SellsJDBC();
      ItemService is = new ItemServiceImplementation();
      System.out.println(id);
      double price = is.getPrice(id);
        try {
            Sells[] sells = dao.read();
            int count = 1;
            for(int i = 0; i < sells.length; i++) {
                if(sells[i].getItem_id() == id) {
                    double profit = price * sells[i].getSell_num();
                    String str = String.valueOf(count++);
                    dataset.addValue( profit , "Orders" , str);
                }
            }
            dataset.addValue( y1 , "Orders" , "(Predicated)" );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PredictionGraph.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PredictionGraph.class.getName()).log(Level.SEVERE, null, ex);
        }
      return dataset;
   }
}
