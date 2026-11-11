package mypackage.persistence;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** Alternative implementation — useful for tests and demos; swapping it in requires no service changes. */
public final class InMemoryPensionRepository implements PensionRepository {

    private final Map<String, Double> store = new LinkedHashMap<>();

    @Override
    public void save(String employeeName, double pension) {
        store.put(employeeName, pension);
    }

    public Map<String, Double> findAll() {
        return Collections.unmodifiableMap(store);
    }
}
