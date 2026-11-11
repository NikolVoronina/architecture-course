package mypackage.calculation;

import mypackage.model.Employee;

public final class InternPensionPolicy implements PensionPolicy {

    @Override
    public String type() {
        return "INTERN" ;
    }

    @Override
    public double calculate(Employee employee) {
         return employee.salary() * 0.02;
    }
}
