package mypackage.reporting;

/**
 * Reporting is its own small interface (ISP): a client that only needs
 * reports no longer depends on calculation or persistence methods.
 */
public interface ReportGenerator {

    void generateReport(String employeeName);
}
