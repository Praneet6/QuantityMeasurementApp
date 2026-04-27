public class QuantityMeasurementAppUC1 {

    // Inner class to represent Feet measurement
    public static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        // Getter (optional, but good practice)
        public double getValue() {
            return value;
        }

        /**
         * Override equals() method to compare two Feet objects
         */
        @Override
        public boolean equals(Object obj) {

            // 1. Reference check
            if (this == obj) {
                return true;
            }

            // 2. Null check
            if (obj == null) {
                return false;
            }

            // 3. Type check
            if (getClass() != obj.getClass()) {
                return false;
            }

            // 4. Cast and compare values
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        // (Recommended) Override hashCode when equals is overridden
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Main method to test UC1
    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        Feet f3 = new Feet(2.0);

        System.out.println("1.0 ft == 1.0 ft ? " + f1.equals(f2)); // true
        System.out.println("1.0 ft == 2.0 ft ? " + f1.equals(f3)); // false
        System.out.println("1.0 ft == null ? " + f1.equals(null)); // false
        System.out.println("Same reference ? " + f1.equals(f1));   // true
    }
