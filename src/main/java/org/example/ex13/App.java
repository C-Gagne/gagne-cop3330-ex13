/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Crystal Gagne
 */

package org.example.ex13;

import java.util.Scanner;

/*
This code specifically does COMPOUND interest.
*/

public class App {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App mainApp = new App();

        double principle = mainApp.getPrinciple();
        double interest = mainApp.getInterestRate();
        int years = mainApp.getYears();
        int timesCompoundedPerYear = mainApp.getTimesCompoundedPerYear();


        String outputString = genOutputString(principle, interest, years, timesCompoundedPerYear);
        System.out.println(outputString);
    }

    public Double getPrinciple()
    {
        System.out.println("What is the principle?");
        return in.nextDouble();
    }

    public Double getInterestRate()
    {
        System.out.println("What is the rate?");
        return in.nextDouble();
    }

    public Integer getYears()
    {
        System.out.println("What is the number of years?");

        // Read and return an integer.
        return in.nextInt();
    }

    public Integer getTimesCompoundedPerYear()
    {
        System.out.println("What is the number of times the interest is compounded per year?");

        // Read and return an integer.
        return in.nextInt();
    }

    public static String genOutputString(double principle, double interest, int years, int timesCompoundedPerYear)
    {
        /*
        The formula for compound interest A = P(1 + r/n)^(n*t) where
            P is the principal amount.
            r is the annual rate of interest.
            t is the number of years the amount is invested.
            n is the number of times the interest is compounded per year.
            A is the amount at the end of the investment.

                baseValue = (1 + r/n)
                exponent = (n * t)
         */

        double exponent = (timesCompoundedPerYear * years);
        double baseValue = (1 + ((interest/100) / timesCompoundedPerYear));
        double finalValue = Math.ceil(principle * Math.pow(baseValue, exponent) * 100)/100;
        return String.format("$%.2f invested at %.3f%% for %d years compounded %d times per year is $%.2f", principle, interest, years, timesCompoundedPerYear, finalValue);
    }
}

