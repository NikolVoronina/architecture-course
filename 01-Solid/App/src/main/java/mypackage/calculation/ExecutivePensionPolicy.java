package mypackage.calculation;

import mypackage.model.Employee;

/**
 * Deliberately implements {@link PensionPolicy} directly instead of
 * extending {@link RegularPensionPolicy}: an executive is not a "special
 * regular" — inheriting and overriding would be fragile and invite LSP
 * violations.
 */
public final class ExecutivePensionPolicy implements PensionPolicy {

    private static final double RATE = 0.10;
    private static final double BONUS = 1000;

    @Override
    public String type() {
        return "EXECUTIVE";
    }

    @Override
    public double calculate(Employee employee) {
        return employee.salary() * RATE + BONUS;
    }
}
