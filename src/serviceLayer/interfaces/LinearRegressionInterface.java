package serviceLayer.interfaces;

import Jama.Matrix;

public interface LinearRegressionInterface {
	public double getPrediction(Matrix X,Matrix Y,double[] xi);
	public Matrix getBeta(Matrix x, Matrix y);
}
