package downLayer;

import Jama.Matrix;
import java.sql.SQLException;
import serviceLayer.LinearRegressionImplementation;
import serviceLayer.LogisticRegressionImplementation;
import serviceLayer.interfaces.LinearRegressionInterface;
import serviceLayer.interfaces.LogisticRegressionInterface;


public class Tester {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*Company com = new Company(3,"JAVA");
		DataWriter dw = new DataWriter();
		dw.write(com); */
		//LogisticRegressionInterface i = new LogisticRegressionImplementation();
		/*double[] beta = {};
		double[][] x = {{0},{0.5},{0.75},{1},{1.25},{1.5},{1.75},{1.75},{2.00},{2.25},{2.5},{2.75},{3},{3.25},{4.00},{4.25},{4.50},{4.75},{5.00},{5.50}};
		Matrix X = new Matrix(x);
		LinearRegressionInterface i2 = new LinearRegressionImplementation();
		double[][] y = {{0},{0},{0},{0},{0},{0},{0},{1},{0},{1},{0},{1},{0},{1},{0},{1},{1},{1},{1},{1}};
		Matrix Y = new Matrix(y);
		beta = i2.getBeta(X, Y).getColumnPackedCopy();
		System.out.println(beta[0]); */
	/*
		double[][] x = {{1,0},{1,4},{1,9},{1,10},{1,14},{1,4},{1,7},{1,12},{1,22},{1,1},{1,3},{1,8},{1,11},{1,5},{1,6},{1,10},{1,11},{1,16},{1,13},{1,13},{1,10}};
		//double[][] x = {{0},{4},{9},{10},{14},{4},{7},{12},{22},{1},{3},{8},{11},{5},{6},{10},{11},{16},{13},{13},{10}};
		double[][] y = {{0},{0},{0},{1},{1},{0},{0},{1},{1},{0},{0},{0},{1},{0},{0},{1},{1},{1},{1},{1},{1}};
		Matrix X = new Matrix(x);
		Matrix Y = new Matrix(y);
		double[] dx = {1,22};
		//Matrix xi = new Matrix(dx);
		double yi = i2.getPrediction(X, Y, dx);
		double[] beta = i2.getBeta(X, Y).getColumnPackedCopy();
		double[] xi = {1,22};
		LogisticRegressionInterface i1 = new LogisticRegressionImplementation();
		System.out.println(beta.length);
		//System.out.println(i1.getProbability(beta, xi));*/
                //CategoryDAO dao = new CategoryJDBC();
                //int id = dao.getMaxCatId();
                //Category[] cat = dao.();
                //System.out.println(cat[2].getName()); */
                LinearRegressionInterface i2 = new LinearRegressionImplementation();
                
               // double[][] x = {}
	}

}
