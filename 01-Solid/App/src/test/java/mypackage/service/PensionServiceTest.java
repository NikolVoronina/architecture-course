package mypackage.service;

import mypackage.model.Employee;
import mypackage.persistence.InMemoryPensionRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** DIP payoff: the service is tested with a stub calculator and an in-memory repository — no DB, no console. */
class PensionServiceTest {

    @Test
    void calculatesAndSaves() {
        InMemoryPensionRepository repo = new InMemoryPensionRepository();
        PensionService service = new PensionService(e -> 42.0, repo);

        double result = service.processEmployee(new Employee("Alice", 40, 1, "ANY"));

        assertEquals(42.0, result);
        assertEquals(42.0, repo.findAll().get("Alice"));
    }
}
