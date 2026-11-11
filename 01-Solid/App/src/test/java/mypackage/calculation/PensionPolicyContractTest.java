package mypackage.calculation;

import mypackage.model.Employee;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/** LSP: every PensionPolicy must pass the same contract tests. Add new policies to {@link #policies()}. */
class PensionPolicyContractTest {

    static Stream<PensionPolicy> policies() {
        return Stream.of(new RegularPensionPolicy(), new ExecutivePensionPolicy());
    }

    @ParameterizedTest
    @MethodSource("policies")
    void hasNonBlankType(PensionPolicy policy) {
        assertFalse(policy.type().isBlank());
    }

    @ParameterizedTest
    @MethodSource("policies")
    void returnsNonNegativeForAnyValidEmployee(PensionPolicy policy) {
        for (double salary : new double[]{0, 1, 500_000, 10_000_000}) {
            Employee e = new Employee("X", 30, salary, policy.type());
            assertTrue(policy.calculate(e) >= 0);
        }
    }
}
