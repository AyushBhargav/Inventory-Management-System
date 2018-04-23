package serviceLayer;

import serviceLayer.interfaces.LogisticRegressionInterface;

public class LogisticRegressionImplementation implements LogisticRegressionInterface{

	@Override
	public double getProbability(double[] beta, double[] x) {
		double fx = 0.0d;
		for(int i = 0; i < beta.length; i++) {
			fx += beta[i]*x[i];
		}
		double ex = Math.exp(-1 * fx);
		double denominator = 1 + ex;
		double probability = (double)1 / denominator;
		return probability;
	}

}
