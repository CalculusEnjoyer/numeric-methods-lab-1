package calculation;

public class Task2 implements EquationsSolver, IterationCalculator {

  private double accuracy;
  private double startValue;
  private double left = 0.5;
  private double right = 1.5;
  private double maxOfFirstDerivative = 2.25;
  private double minDerivative = 9.526;
  private double tao;
  private double q;


  public Task2(double accuracy, double startValue) {
    this.accuracy = accuracy;
    this.startValue = startValue;
    calculateQ();
  }

  @Override
  public double findSolution() {
    double result = startValue;
    for (int i = 0; i < calculateNumberOfIterations(); i++) {
      result = recursiveStep(result);
      System.out.println("Value at " + (1 + i) + " step: " + result);
    }
    return result;
  }

  @Override
  public int calculateNumberOfIterations() {
    return 1 + (int) Math.floor(Math.log(Math.log(Math.abs(right - left) / accuracy)) / Math.log(1 / q) / Math.log(2) + 1);
  }

  private double recursiveStep(double x) {
    return x - function(x) / derivativeOfFunction(startValue);
  }

  private double function(double x) {
    return Math.pow(x, 3) + 3 * Math.pow(x, 2) - x - 3;
  }

  private double derivativeOfFunction(double x) {
    return 3 * Math.pow(x, 2) + 6 * x - 1;
  }

  private void calculateQ() {
    q = maxOfFirstDerivative * Math.abs(right - left) / (2 * minDerivative);
  }
}
