package serviceLayer.interfaces;

public interface LogisticRegressionInterface {
	
	//x[0] = 1 always.
	public double getProbability(double[] beta, double[] x);
}
