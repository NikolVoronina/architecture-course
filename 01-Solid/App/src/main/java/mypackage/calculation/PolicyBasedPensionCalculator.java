package mypackage.calculation;

import mypackage.model.Employee;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Picks the right {@link PensionPolicy} by employee type. Closed for
 * modification: new types are registered from outside (OCP).
 */
public final class PolicyBasedPensionCalculator implements PensionCalculator {

    private final Map<String, PensionPolicy> policies;

    public PolicyBasedPensionCalculator(Collection<? extends PensionPolicy> policies) {
        this.policies = policies.stream()
                .collect(Collectors.toUnmodifiableMap(PensionPolicy::type, Function.identity()));
    }

    @Override
    public double calculate(Employee employee) {
        PensionPolicy policy = policies.get(employee.type());
        if (policy == null) {
            throw new IllegalArgumentException("No pension policy for type: " + employee.type());
        }
        return policy.calculate(employee);
    }
}
