package mypackage.service;

import mypackage.calculation.PensionCalculator;
import mypackage.model.Employee;
import mypackage.persistence.PensionRepository;

import java.util.Objects;

/**
 * Orchestrates one use case: process an employee's pension.
 * <ul>
 *   <li>SRP — only coordinates; calculation and storage live elsewhere.</li>
 *   <li>OCP — no type switch; new employee types need no change here.</li>
 *   <li>DIP — depends on abstractions, injected via the constructor.</li>
 * </ul>
 */
public final class PensionService {

    private final PensionCalculator calculator;
    private final PensionRepository repository;

    public PensionService(PensionCalculator calculator, PensionRepository repository) {
        this.calculator = Objects.requireNonNull(calculator);
        this.repository = Objects.requireNonNull(repository);
    }

    public double processEmployee(Employee employee) {
        double pension = calculator.calculate(employee);
        repository.save(employee.name(), pension);
        return pension;
    }
}
