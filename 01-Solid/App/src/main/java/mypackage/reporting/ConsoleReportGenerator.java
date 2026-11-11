package mypackage.reporting;

public final class ConsoleReportGenerator implements ReportGenerator {

    @Override
    public void generateReport(String employeeName) {
        System.out.println("Generating report for... " + employeeName);
    }
}
