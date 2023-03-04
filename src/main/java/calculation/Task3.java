package calculation;

public class Task3 implements EquationsSolver, IterationCalculator {

  private double accuracy;
  private double startValue;
  private double left = 1.5;
  private double right = 2.5;
  private double minOfFirstDerivative = 5.1875;
  private double maxOfSecondDerivative = 13.5;
  private double q;


  public Task3(double accuracy, double startValue) {
    this.accuracy = accuracy;
    this.startValue = startValue;
    calculateQ();
  }

  @Override
  public double findSolution() {
    double result = startValue;
    for (int i = 0; i < 20; i++) {
      result = recursiveStep(result);
      System.out.println("Value at " + (1 + i) + " step: " + result);
    }
    return result;
  }

  @Override
  public int calculateNumberOfIterations() {
    return 1 + (int) Math.floor(
        Math.log(Math.log(Math.abs(right - left) / accuracy) / Math.log(1 / q) + 1) / Math.log(2));
  }

  private double recursiveStep(double x) {
    return Math.pow(-Math.pow(x, 2) + 4 * x + 4, 1.0 / 3);
  }

  private void calculateQ() {
    q = maxOfSecondDerivative * Math.abs(right - left) / (2 * minOfFirstDerivative);
  }
}
