public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength q3 = new QuantityLength(1.0, LengthUnit.CENTIMETER);
        QuantityLength q4 = new QuantityLength(0.393701, LengthUnit.INCH);

        System.out.println("1 yard == 3 feet ? " + q1.equals(q2)); // true
        System.out.println("1 cm == 0.393701 inch ? " + q3.equals(q4)); // true
    }
}