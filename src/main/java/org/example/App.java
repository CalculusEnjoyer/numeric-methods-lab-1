package org.example;

import calculation.Task1;
import calculation.Task2;
import calculation.Task3;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {
    System.out.println("Method of relaxation:");
    Task1 task1 = new Task1(Math.pow(10, -3), -0.5);
    System.out.println("Apriori number of iterations: " + task1.calculateNumberOfIterations());
    System.out.println("------------------------------------------------------------------");
    double result = task1.findSolution();
    System.out.println("================================================================");

    System.out.println("Newton's method:");
    Task2 task2 = new Task2(Math.pow(10, -3), 0.75);
    System.out.println("Apriori number of iterations: " + task2.calculateNumberOfIterations());
    System.out.println("------------------------------------------------------------------");
    result = task2.findSolution();
    System.out.println("================================================================");

    System.out.println("Method of simple iteration:");
    Task3 task3 = new Task3(Math.pow(10, -3), 1.5);
    System.out.println("Apriori number of iterations: " + task3.calculateNumberOfIterations());
    System.out.println("------------------------------------------------------------------");
    result = task3.findSolution();
    System.out.println("================================================================");
  }
}
