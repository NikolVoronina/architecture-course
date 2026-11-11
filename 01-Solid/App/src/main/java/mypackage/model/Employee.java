package mypackage.model;

/**
 * Immutable data about an employee. Holds data only — no calculation,
 * persistence or reporting logic (SRP).
 */
public record Employee(String name, int age, double salary, String type) {

    public Employee {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        if (age < 0) throw new IllegalArgumentException("age must be >= 0");
        if (salary < 0) throw new IllegalArgumentException("salary must be >= 0");
        if (type == null || type.isBlank()) throw new IllegalArgumentException("type is required");
    }
}
