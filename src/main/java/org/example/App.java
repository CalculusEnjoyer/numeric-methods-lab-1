package org.example;

import calculation.Task1;
import calculation.Task2;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {
    Task1 task1 = new Task1(Math.pow(10, -5), -0.5);
    System.out.println(task1.calculateNumberOfIterations());
    double result = task1.findSolution();

    Task2 task2 = new Task2(Math.pow(10, -5), 1.2);
    System.out.println(task2.calculateNumberOfIterations());
    result = task2.findSolution();
  }
}
