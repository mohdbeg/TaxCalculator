/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.calctax;

import java.util.Scanner;

/**
 *
 * @author Mohammed Beg
 */
public class CalcTax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Select the employee either as a local staff (true) or international/other staff (false): ");
            if (scanner.hasNextBoolean()) {
                boolean localEmployee = scanner.nextBoolean();
                scanner.nextLine(); // Consume the newline character
                
            System.out.print("Enter the amount of Salary per year: $");
            if (scanner.hasNextDouble()) {
                double amountSalary = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character

                    double taxAmount = computeIncomeTax(amountSalary, localEmployee);

                    if (taxAmount == -1) {
                        System.out.println("-1 : Error");
                    } else {
                        System.out.println("Tax Amount: $" + taxAmount);
                    }

                    System.out.print("Do you want to compute another tax? (yes or enter any other key to quit): ");
                    String anotherCalculation = scanner.nextLine().toLowerCase();
                    if (!anotherCalculation.equals("yes")) {
                        break; // Exit the loop if the user doesn't want to compute another tax
                    }
                } else {
                    System.out.println("\nError: -1. \n.");
                    scanner.nextLine(); // Consume the invalid input
                }
            } else {
                System.out.println("\nError: -1 . \n\nPlease enter true or false for employee type below.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        scanner.close();
    }

    public static double computeIncomeTax(double amountSalary, boolean localEmployee) {
        if (amountSalary < 0) {
            return -1; // Invalid input
        }

        double taxAmount = 0;

        if (localEmployee) {
            if (amountSalary < 18000) {
                taxAmount = 0;
            } else if (amountSalary >= 18000 && amountSalary <= 30000) {
                taxAmount = amountSalary * 0.10;
            } else if (amountSalary > 30000 && amountSalary <= 50000) {
                taxAmount = 2000 + (amountSalary - 30000) * 0.18;
            } else if (amountSalary > 50000 && amountSalary <= 100000) {
                taxAmount = 5000 + (amountSalary - 50000) * 0.20;
            } else {
                taxAmount = 10000 + (amountSalary - 100000) * 0.30;
            }
        } else {
            if (amountSalary < 18000) {
                taxAmount = amountSalary * 0.10;
            } else if (amountSalary >= 18000 && amountSalary <= 30000) {
                taxAmount = amountSalary * 0.15;
            } else if (amountSalary > 30000 && amountSalary <= 50000) {
                taxAmount = 4000 + (amountSalary - 30000) * 0.20;
            } else if (amountSalary > 50000 && amountSalary <= 100000) {
                taxAmount = 10000 + (amountSalary - 50000) * 0.25;
            } else {
                taxAmount = 20000 + (amountSalary - 100000) * 0.35;
            }
        }

        return taxAmount;
    }
}

