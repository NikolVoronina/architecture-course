package mypackage.persistence;

/** Storage abstraction. The service does not know whether it is an RDBMS, a file or memory (DIP). */
public interface PensionRepository {

    void save(String employeeName, double pension);
}
