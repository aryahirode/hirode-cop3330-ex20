/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Arya Hirode
 */
package base;

import java.util.Scanner;

public class TaxCalculator_v2 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        TaxCalculator_v2 myApp = new TaxCalculator_v2();
        myApp.output();
    }

    private int amtPrompt() {
        System.out.print("What is the order amount? ");
        return Integer.parseInt(in.nextLine());
    }

    private String statePrompt() {
        System.out.print("What state do you live in? ");
        return in.nextLine();
    }

    private String countyPrompt() {
        System.out.print("What county do you live in? ");
        return in.nextLine();
    }

    private double tax(double amt, String state, String county) {
        double stateTax = 0;
        double countyTax = 0;
        if (state.equals("Wisconsin")) {
            stateTax = amt * .05;
            if (county.equals("Eau Claire")) {
                countyTax = amt * .005;
            }
            else if (county.equals("Dunn")) {
                countyTax = amt * .004;
            }
        }
        if (state.equals("Illinois")) {
            stateTax = amt * .08;
        }
        return stateTax + countyTax;
    }

    private void output() {
        double amt = amtPrompt();
        String state = statePrompt();
        String county = countyPrompt();
        String taxStr = tax(amt, state, county) == 0 ? "" : "The tax is $%.2f.\n";
        String totalStr = "The total is $%.2f.\n";
        double printfArg = tax(amt, state, county) == 0 ? amt : tax(amt, state, county);
        System.out.printf(taxStr + totalStr, printfArg, amt + tax(amt, state, county));
    }
}
