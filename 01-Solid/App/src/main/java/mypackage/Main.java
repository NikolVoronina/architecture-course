package mypackage;

import mypackage.calculation.*;
import mypackage.model.Employee;
import mypackage.persistence.PensionRepository;
import mypackage.persistence.RdbmsPensionRepository;
import mypackage.reporting.ConsoleReportGenerator;
import mypackage.reporting.ReportGenerator;
import mypackage.service.PensionService;

import java.util.List;

/** Composition root: the only place that knows the concrete classes (DIP). */
public class Main {

    public static void main(String[] args) {
        PensionCalculator calculator = new PolicyBasedPensionCalculator(List.of(
                new RegularPensionPolicy(),
                new ExecutivePensionPolicy(),
                new InternPensionPolicy()
                // OCP: add e.g. new ContractorPensionPolicy() here — nothing else changes
        ));
        PensionRepository repository = new RdbmsPensionRepository();
        ReportGenerator reports = new ConsoleReportGenerator();

        PensionService service = new PensionService(calculator, repository);

        List<Employee> employees = List.of(
                new Employee("Alice", 40, 500_000, "REGULAR"),
                new Employee("Bob", 55, 1_200_000, "EXECUTIVE"),
                new Employee("Nikol", 22, 430_000, "INTERN"));

        for (Employee e : employees) {
            double pension = service.processEmployee(e);
            System.out.println(e.type() + " pension for " + e.name() + ": " + pension);
            reports.generateReport(e.name());
        }
    }
}
