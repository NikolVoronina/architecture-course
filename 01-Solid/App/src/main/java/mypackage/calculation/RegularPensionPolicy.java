package mypackage.calculation;

import mypackage.model.Employee;

public final class RegularPensionPolicy implements PensionPolicy {

    private static final double RATE = 0.05;

    @Override
    public String type() {
        return "REGULAR";
    }

    @Override
    public double calculate(Employee employee) {
        return employee.salary() * RATE;
    }
}
