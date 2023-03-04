package calculation;

public class Task3 implements EquationsSolver, IterationCalculator {

  private double accuracy;
  private double startValue;
  private double left = 1.5;
  private double right = 2.5;
  private double q;


  public Task3(double accuracy, double startValue) {
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
    return 1 + (int) Math.floor(
        Math.log(Math.log(Math.abs(right - left) / ((1-q)*accuracy)) / Math.log(1 / q)));
  }

  private double recursiveStep(double x) {
    return Math.pow(-Math.pow(x, 2) + 4 * x + 4, 1.0 / 3);
  }

  private void calculateQ() {
    q = 0.169;
  }
}
