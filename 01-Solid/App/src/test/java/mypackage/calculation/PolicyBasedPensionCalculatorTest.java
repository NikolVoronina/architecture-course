package mypackage.calculation;

import mypackage.model.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PolicyBasedPensionCalculatorTest {

    private final PensionCalculator calculator = new PolicyBasedPensionCalculator(
            List.of(new RegularPensionPolicy(), new ExecutivePensionPolicy()));

    @Test
    void regularIsFivePercent() {
        assertEquals(5_000, calculator.calculate(new Employee("A", 40, 100_000, "REGULAR")), 1e-9);
    }

    @Test
    void executiveIsTenPercentPlusBonus() {
        assertEquals(11_000, calculator.calculate(new Employee("B", 50, 100_000, "EXECUTIVE")), 1e-9);
    }

    @Test
    void unknownTypeFailsLoudly() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(new Employee("C", 30, 100_000, "INTERN")));
    }

    @Test
    void newTypeCanBeAddedWithoutModifyingExistingCode() {
        PensionPolicy contractor = new PensionPolicy() {
            public String type() { return "CONTRACTOR"; }
            public double calculate(Employee e) { return 0; }
        };
        PensionCalculator extended = new PolicyBasedPensionCalculator(
                List.of(new RegularPensionPolicy(), contractor));
        assertEquals(0, extended.calculate(new Employee("D", 30, 100_000, "CONTRACTOR")));
    }
}
