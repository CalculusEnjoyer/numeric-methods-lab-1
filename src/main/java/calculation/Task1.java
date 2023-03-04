package calculation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task1 implements EquationsSolver, IterationCalculator {

  private double accuracy;
  private double startValue;
  private double left = -0.5;
  private double right = -1.5;
  private double maxDerivative = 29.75;
  private double minDerivative = 7.25;
  private double tao;
  private double q;



  public Task1(double accuracy, double startValue) {
    this.accuracy = accuracy;
    this.startValue = startValue;
    calculateTao();
    calculateQ();
  }

  @Override
  public double findSolution() {
    double x = startValue;
    calculateTao();
    for (int i = 0; i < calculateNumberOfIterations(); i++) {
      x = recursiveStep(x);
      System.out.println("Value at " + (1 + i) + " step: " + x);
    }
    return x;
  }

  @Override
  public int calculateNumberOfIterations() {
    return 1 + (int) Math.floor(Math.log(Math.abs(startValue)/accuracy) / Math.log(1/q));
  }

  private double recursiveStep(double x) {
    return x - tao * (Math.pow(x, 3) - 6 * Math.pow(x, 2) + 5 * x + 12);
  }

  private void calculateTao() {
    tao = 2.0 / (minDerivative + maxDerivative);
  }

  private void calculateQ() {
    q = (maxDerivative - minDerivative)/(maxDerivative + minDerivative);
  }
}
