package org.example;

import calculation.Task1;
import calculation.Task2;
import calculation.Task3;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {
    Task1 task1 = new Task1(Math.pow(10, -5), -0.5);
    System.out.println("Apriori number of iterations: " + task1.calculateNumberOfIterations());
    double result = task1.findSolution();

    Task2 task2 = new Task2(Math.pow(10, -8), 0.75);
    System.out.println("Apriori number of iterations: " + task2.calculateNumberOfIterations());
    result = task2.findSolution();

    Task3 task3 = new Task3(Math.pow(10, -8), 1.5);
    System.out.println("Apriori number of iterations: " + task3.calculateNumberOfIterations());
    result = task3.findSolution();
  }
}
