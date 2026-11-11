package mypackage.persistence;

public final class RdbmsPensionRepository implements PensionRepository {

    @Override
    public void save(String employeeName, double pension) {
        System.out.println("Saving to RDBMS: " + employeeName + " -> " + pension);
    }
}
