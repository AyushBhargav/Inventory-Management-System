/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import serviceLayer.CategoryServiceImplementation;
import serviceLayer.ItemServiceImplementation;
import serviceLayer.SellsServiceImplementation;
import serviceLayer.interfaces.CategoryService;
import serviceLayer.interfaces.ItemService;
import serviceLayer.interfaces.SellsService;

/**
 *
 * @author AYUSH
 */
public class GraphProfitWindow extends ApplicationFrame{
    public GraphProfitWindow( String title ) 
   {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   private static PieDataset createDataset( ) 
   {
      DefaultPieDataset dataset = new DefaultPieDataset();
      CategoryService cs = new CategoryServiceImplementation();
      String[] categoryName = cs.getCatNames();
      
      double[] profit = new double[categoryName.length];
      for(int i = 0; i < categoryName.length; i++) {
          ItemService is = new ItemServiceImplementation();
          int catId = cs.getId(categoryName[i]);
          String[] itemName = is.getItemNameWithStock(catId);
          System.out.println(itemName.length);
          double[] prices = new double[itemName.length];
          for(int j = 0; j < prices.length; j++) {
              prices[j] = is.getPrice(itemName[j]);
              System.out.println(prices[j]);
          }
          SellsService ss= new SellsServiceImplementation();
          for(int j = 0; j < itemName.length; j++) {
              int itemId = is.getId(itemName[j]);
              int num = ss.getNum(catId,itemId);
              
              profit[i] += prices[j] * num;
          }
      }
      for(int i = 0; i < categoryName.length; i++) {
          dataset.setValue(categoryName[i], profit[i]);
      }  
      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Total Profit",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   public static JPanel createDemoPanel( )
   {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
}
