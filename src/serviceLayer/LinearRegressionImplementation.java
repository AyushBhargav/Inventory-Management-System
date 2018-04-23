package serviceLayer;

import Jama.Matrix;
import serviceLayer.interfaces.LinearRegressionInterface;

public class LinearRegressionImplementation implements LinearRegressionInterface{
	
	public Matrix getBeta(Matrix x, Matrix y) {
		Matrix xdash = x.transpose(); // X'
		Matrix xdashX = xdash.times(x); //X'X
                if(xdashX.det()== 0) {
                    System.out.println("I am here!!!");
                    double[][] dx = new double[xdashX.getRowDimension()][xdashX.getColumnDimension()];
                    for(int i = 0; i < xdashX.getRowDimension(); i++) {
                        for(int j = 0; j < xdashX.getColumnDimension(); j++) {
                            dx[i][j] += Math.random() * 0.1;
                        }
                    }
                    Matrix temp = new Matrix(dx);
                    xdashX = xdashX.plus(temp);
                }
		Matrix xdashXInverse = xdashX.inverse(); //(X'X)^-1
		Matrix beta = xdashXInverse.times(xdash).times(y); //(X'X)^-1X'Y
		return beta;
	}
	
	public double getPrediction(Matrix x, Matrix y, double[] xi) {
		double[] beta = getBeta(x,y).getColumnPackedCopy();
		double yi = 0.0d;
		for(int i = 0; i < beta.length; i++) {
			yi += xi[i] * beta[i];
		}
		return yi;
	}
}
