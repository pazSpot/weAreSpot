package configurations.config.reporting;//package com.dps.qa.config.reporting;
//
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import org.testng.*;
//import org.testng.xml.XmlSuite;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//


//public class ExtentTestNGIReporterListener implements IReporter {
//
//    private static final String OUTPUT_FOLDER = "test-output/";
//    private static final String FILE_NAME = "Extent.html";
//
//    private ExtentReports extent;
//
//    @Override
//    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
//                               String outputDirectory) {
//        init();
//
//        for (ISuite suite : suites) {
//            Map result = suite.getResults();
//
//            for (ISuiteResult suiteResult : suite.getResults().values()) {
//                ITestContext context = suiteResult.getTestContext();
//
//                buildTestNodes(context.getFailedTests(), Status.FAIL);
//                buildTestNodes(context.getSkippedTests(), Status.SKIP);
//                buildTestNodes(context.getPassedTests(), Status.PASS);
//
//            }
//        }
//
//        for (String s : Reporter.getOutput()) {
//            extent.setTestRunnerOutput(s);
//        }
//
//        extent.flush();
//    }
//
//    private void init() {
//        String reportName = null;
//        if (System.getProperty("testType").equals("NOC_WEB")) {
//            reportName = "NOC MONITORING";
//        }
//        else if(System.getProperty("environment").equals("www")){
//            reportName = "PRODUCTION";
//        }
//        else if(System.getProperty("environment").equals("qa")){
//            reportName = "QA";
//        }
//        else if(System.getProperty("environment").equals("stage")){
//            reportName = "STAGE";
//        }
//        else if(System.getProperty("environment").equals("dev")){
//            reportName = "DEV";
//        }
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
//        htmlReporter.config().setDocumentTitle("LMT B2C - Automation report (WEB UI) - " + reportName);
//        htmlReporter.config().setReportName("LMT B2C - Automation report (WEB UI) - " + reportName);
//        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
//        htmlReporter.config().setTheme(Theme.DARK);
//
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//        extent.setReportUsesManualConfiguration(true);
//    }
//
//    private void buildTestNodes(IResultMap tests, Status status) {
//        ExtentTest test;
//
//        if (tests.size() > 0) {
//            for (ITestResult result : tests.getAllResults()) {
//                test = extent.createTest(result.getMethod().getMethodName());
//
//                for (String group : result.getMethod().getGroups())
//                    test.assignCategory(group);
//
//                if (result.getThrowable() != null) {
//                    test.log(status, result.getThrowable());
//                }
//                else {
//                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
//                }
//                test.getModel().setStartTime(getTime(result.getStartMillis()));
//                test.getModel().setEndTime(getTime(result.getEndMillis()));
//            }
//        }
//    }
//
//    private Date getTime(long millis) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(millis);
//        return calendar.getTime();
//    }
//}
