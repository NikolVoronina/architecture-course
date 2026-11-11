package mypackage.calculation;

import mypackage.model.Employee;

/**
 * One pension rule per employee type (OCP: add a new type by adding a new
 * implementation, not by editing an if/else chain).
 *
 * <p>Contract every implementation must honour (LSP):
 * <ul>
 *   <li>{@link #type()} returns a non-blank, unique key.</li>
 *   <li>{@link #calculate(Employee)} accepts any valid {@link Employee}
 *       and returns a non-negative amount — it must not throw
 *       UnsupportedOperationException or demand extra preconditions.</li>
 *   <li>No side effects (no printing, no saving).</li>
 * </ul>
 */
public interface PensionPolicy {

    String type();

    double calculate(Employee employee);
}
