package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength f1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength f2 = new QuantityLength(2.0, LengthUnit.FEET);

        QuantityLength inch = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength cm = new QuantityLength(2.54, LengthUnit.CENTIMETER);

        // 🔹 Same unit addition
        System.out.println("1 ft + 2 ft = " + f1.add(f2));

        // 🔹 Cross unit addition
        System.out.println("1 ft + 12 in = " + f1.add(inch));

        // 🔹 Reverse (unit changes)
        System.out.println("12 in + 1 ft = " + inch.add(f1));

        // 🔹 Yard example
        System.out.println("1 yard + 3 ft = " + yard.add(new QuantityLength(3.0, LengthUnit.FEET)));

        // 🔹 CM + Inch
        System.out.println("2.54 cm + 1 inch = " + cm.add(new QuantityLength(1.0, LengthUnit.INCH)));

        // 🔹 Static API
        System.out.println("Static add → " +
                QuantityLength.add(f1, inch, LengthUnit.FEET));
    }
}