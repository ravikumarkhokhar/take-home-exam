package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	private static ExtentReports extentReports;
	
	 public static ExtentReports getInstance() {
	        if (extentReports == null)
	            createExtentReportInstance();
	        return extentReports;
	    }

	public static ExtentReports createExtentReportInstance() {
		if (extentReports == null) {
			extentReports = new ExtentReports();

			String reportDir = System.getProperty("user.dir").concat("\\reports");
			ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportDir);
			extentSparkReporter.config().setReportName("Combyne Application Reports");
			extentSparkReporter.config().setDocumentTitle("Combyne Application");
			extentSparkReporter.config().setTheme(Theme.STANDARD);
			extentSparkReporter.config().setEncoding("UTF-8");
			extentReports.attachReporter(extentSparkReporter);
		}
		return extentReports;
	}
}
