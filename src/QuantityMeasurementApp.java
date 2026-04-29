package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

        QuantityLength q3 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q4 = new QuantityLength(1.0, LengthUnit.INCH);

        System.out.println("1 ft == 12 inch ? " + q1.equals(q2)); // true
        System.out.println("1 inch == 1 inch ? " + q3.equals(q4)); // true
    }
}