package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // Method to check Feet equality
    public static boolean areFeetEqual(double v1, double v2) {
        return new Feet(v1).equals(new Feet(v2));
    }

    // Method to check Inch equality
    public static boolean areInchesEqual(double v1, double v2) {
        return new Inch(v1).equals(new Inch(v2));
    }

    public static void main(String[] args) {

        System.out.println("Feet Equality: " + areFeetEqual(1.0, 1.0));
        System.out.println("Feet Equality: " + areFeetEqual(1.0, 2.0));

        System.out.println("Inch Equality: " + areInchesEqual(1.0, 1.0));
        System.out.println("Inch Equality: " + areInchesEqual(1.0, 2.0));
    }
}