import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    public static ExtentReports getExtentReports() {
        if (extentReports == null) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
        }
        return extentReports;
    }

    public static ExtentTest createTest(String testName) {
        extentTest = getExtentReports().createTest(testName);
        return extentTest;
    }

    public static ExtentTest getExtentTest() {
        return extentTest;
    }
}
