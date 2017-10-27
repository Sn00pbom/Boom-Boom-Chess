package me.sn00pbom.boomboomchess.util;

import java.util.Scanner;

public class Inputs {
    private static Scanner scnr = new Scanner(System.in);
    public static double getDouble(String prompt) {
        double d = 0;
        while (true) {
            System.out.println(prompt);
            try {
                d = Double.parseDouble(scnr.nextLine());
                return d;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input! Please only type numbers.");
            }
        }
    }

    public static String getString(String prompt) {
        String input = null;
        do{
            System.out.println(prompt);
            input = scnr.nextLine();
            if(input.equals("")){
                System.out.println("Error: cannot be a blank string");
            }
        }while(input.equals(""));
        return input;
    }

    public static int getInt(String prompt) {
        int i = 0;
        while (true) {
            System.out.println(prompt);
            try {
                i = Integer.parseInt(scnr.nextLine());
                return i;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input! Please only type numbers.");
            }
        }
    }
    public static int getInt(String prompt,boolean canNegative) {//TODO finish this
        int i = 0;
        while (true) {
            System.out.println(prompt);
            try {
                i = Integer.parseInt(scnr.nextLine());
                return i;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input! Please only type numbers.");
            }
        }
    }
}