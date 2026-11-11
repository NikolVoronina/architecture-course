package mypackage.calculation;

import mypackage.model.Employee;

/** What the service needs from calculation — nothing more (ISP). */
public interface PensionCalculator {

    double calculate(Employee employee);
}
