//package fed.utilities;
//
//
//import configurations.AutomationSystemProperties;
//import fed.browsers.Driver;
//import org.apache.commons.io.FileUtils;
//import org.testng.Reporter;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
//import org.testng.reporters.SuiteHTMLReporter;
//import org.testng.reporters.TestHTMLReporter;
//import org.testng.reporters.XMLReporter;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
//
//@Listeners({
//        XMLReporter.class,                  // Native TestNG+XML reporter
//        SuiteHTMLReporter.class,            // Native
//        TestHTMLReporter.class,             // Native
//})
//
//public class BaseTests {
//
//    public String getTestedURL() {
//        return AutomationSystemProperties.WEB_HOST;
//    }
//
//    @BeforeMethod
//    public void beforeMethod() throws Exception {
//        Log.startLog("Test is starting");
//        Driver.Initialize();
//    }
//
//    @AfterMethod
//    public void afterTests() {
//        Log.endLog("Test is ending");
//
////        System.out.println("================== CONSOLE LOGS =======================");
////        LogEntries logEntries = Driver.Instance.manage().logs().get(LogType.BROWSER);
////        List<LogEntry> errorLogs = logEntries.filter(Level.SEVERE);
////        if (errorLogs.size() != 0) {
////            for (LogEntry logEntry : logEntries) {
////                System.out.println("Found error in logs: " + logEntry.getMessage());
////            }
////        }
////        System.out.println("================== CONSOLE LOGS =======================");
//
//        Driver.quit();
//    }
//
//    public void failed() throws IOException {
//        if (Driver.Instance != null) {
//            String timeStamp;
//            File localPage;
//            String filePath;
//            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//            filePath = System.getenv("JOB_URL") + "/" + System.getenv("BUILD_NUMBER") + "/" + "execution/node/3/ws/target/Screenshots/" + timeStamp + ".png";
//            localPage = new File(System.getenv("WORKSPACE") + "/target/Screenshots/" + timeStamp + ".png");
//            FileUtils.copyFile(Driver.takeScreenshot(), localPage);
//            Reporter.log("<br><img src='" + filePath + "' height='300' width='300'/><br>");
//        }
//    }
//}
