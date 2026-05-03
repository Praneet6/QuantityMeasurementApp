package com.apps.quantitymeasurement;

import java.util.Objects;

/**
 * UC6: QuantityLength - Supports equality, conversion, and addition of length units.
 *
 * Features:
 * - Unit conversion (UC5)
 * - Cross-unit equality (UC3/UC4)
 * - Addition of two lengths (UC6)
 */
public class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // ===============================
    // 🔁 Convert to base (FEET)
    // ===============================
    private double toBaseUnit() {
        return unit.toFeet(value);
    }

    // ===============================
    // 🔥 UC5: Conversion API
    // ===============================
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        if (source == target) {
            return value;
        }

        double valueInFeet = source.toFeet(value);
        return target.fromFeet(valueInFeet);
    }

    public double convertTo(LengthUnit targetUnit) {
        return convert(this.value, this.unit, targetUnit);
    }

    public QuantityLength convertToQuantity(LengthUnit targetUnit) {
        return new QuantityLength(convertTo(targetUnit), targetUnit);
    }

    // ===============================
    // 🔥 UC6: ADDITION
    // ===============================
    public QuantityLength add(QuantityLength other) {

        if (other == null) {
            throw new IllegalArgumentException("Other length cannot be null");
        }

        // Step 1: convert both to base unit (feet)
        double thisInFeet = this.toBaseUnit();
        double otherInFeet = other.toBaseUnit();

        // Step 2: add
        double sumInFeet = thisInFeet + otherInFeet;

        // Step 3: convert back to this unit
        double resultValue = this.unit.fromFeet(sumInFeet);

        return new QuantityLength(resultValue, this.unit);
    }

    // Static version (optional but good API)
    public static QuantityLength add(QuantityLength l1, QuantityLength l2, LengthUnit targetUnit) {

        if (l1 == null || l2 == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sumInFeet = l1.toBaseUnit() + l2.toBaseUnit();
        double resultValue = targetUnit.fromFeet(sumInFeet);

        return new QuantityLength(resultValue, targetUnit);
    }

    // ===============================
    // Equality
    // ===============================
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityLength other = (QuantityLength) obj;

        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toBaseUnit());
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}