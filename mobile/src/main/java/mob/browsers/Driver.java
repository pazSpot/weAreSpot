package mob.browsers;

import configurations.AutomationSystemProperties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static mob.pages.BasicPage.setDimensions;

public class Driver {
    public static DesiredCapabilities capabilities;
    public static IOSDriver<IOSElement> driverIos;
    public static AndroidDriver<AndroidElement> androidDriver;
    public static WebDriver Instance = null;
    public static URL url;
    //public static String Node = "http://selenium.spotim.vpc:4444/wd/hub";


    public static void Initialize() throws Exception {
        if (Instance == null) {
            System.out.println("Initializing Driver");
            if (AutomationSystemProperties.BROWSER_LOCATION.equals("LOCAL")) {
                Instance = getDriverInstance();
                setDimensions(fed.browsers.Driver.Instance, Integer.parseInt(AutomationSystemProperties.SCREEN_SIZE));
            } else if (AutomationSystemProperties.BROWSER_LOCATION.equals("REMOTE")) {
                Instance = getBrowserStackInstance();
                setDimensions(fed.browsers.Driver.Instance, Integer.parseInt(AutomationSystemProperties.SCREEN_SIZE));
            } else if (AutomationSystemProperties.BROWSER_LOCATION.equals("APPIUM")) {
                Instance = getAppiumMobileInstance();
            } else if (AutomationSystemProperties.BROWSER_LOCATION.equals("REMOTEPC")) {
                Instance = getRemotePcInstance();
            }
        }
        Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Instance.manage().window().maximize();
    }

    public static void close() {
        System.out.println("Closing Browser");
        Instance.close();
        Instance = null;
    }

    public static void quit() {
        System.out.println("Quiting Browser");
        Instance.quit();
        Instance = null;
    }

    public static File takeScreenshot() {
        return ((TakesScreenshot) fed.browsers.Driver.Instance).getScreenshotAs(OutputType.FILE);
    }

    public static WebDriver getBrowserStackInstance() throws MalformedURLException {
        String browserTypeStr = AutomationSystemProperties.BROWSER_TYPE;
        return getBrowserStackInstance(BrowserType.forName(browserTypeStr));
    }

    public static WebDriver getBrowserStackInstance(BrowserType browserType) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", browserType.name());
        switch (browserType) {
            case SAFARI:
                caps.setCapability("os", "OS X");
                caps.setCapability("os_version", "High Sierra");
                caps.setCapability("browser", "Safari");
                caps.setCapability("browser_version", "11.0");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.5.2");
                break;

            case CHROME:
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "62.0");
                caps.setCapability("resolution", "1920x1200");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.5.2");
                break;

            case FIREFOX:
                caps.setCapability("os", "OS X");
                caps.setCapability("os_version", "Sierra");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "66.0");
                caps.setCapability("resolution", "1600x1200");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "3.10.0");
                break;

            case IE:
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "IE");
                caps.setCapability("browser_version", "11.0");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "2.53.0");
                break;

            case IOS:
                caps.setCapability("os_version", "13");
                caps.setCapability("device", "iPhone XS");
                caps.setCapability("real_mobile", "true");
                caps.setCapability("browserstack.local", "false");
                break;

            case ANDROID:
                caps.setCapability("os_version", "4.4");
                caps.setCapability("device", "Samsung Galaxy S5");
                caps.setCapability("real_mobile", "false");
                caps.setCapability("browserstack.local", "false");
                break;
        }

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        caps.setCapability("browserstack.console", "info");
        caps.setCapability("browserstack.networkLogs", "true");
        return new RemoteWebDriver(new URL(AutomationSystemProperties.BS_GRID_URL), caps);
    }

    public static WebDriver getDriverInstance() {
        String browserTypeStr = AutomationSystemProperties.BROWSER_TYPE;
        WebDriver driver;

        switch (BrowserType.forName(browserTypeStr)) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", AutomationSystemProperties.FIREFOX_DRIVER_PATH);
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", AutomationSystemProperties.CHROME_DRIVER_PATH);
                ChromeOptions options = new ChromeOptions();
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(LogType.BROWSER, Level.ALL);
                options.setCapability("goog:loggingPrefs", logPrefs);
                driver = new ChromeDriver(options);
                break;
            case IE:
                System.setProperty("webdriver.ie.driver", AutomationSystemProperties.IE_DRIVER_PATH);
                driver = new InternetExplorerDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Only Firefox, Chrome, Safari and IE are currently supported!");
        }
        return driver;
    }

    public static WebDriver getAppiumMobileInstance() throws MalformedURLException {
        String browserTypeStr = AutomationSystemProperties.BROWSER_TYPE;
        String deviceTypeStr = AutomationSystemProperties.DEVICE_TYPE;

        IOSDriver<IOSElement> driverIos = null;
        AndroidDriver<AndroidElement> driverAndroid = null ;
        WebDriver driver = null;

        String reportDirectory = "reports";
        String reportFormat = "xml";
        String testName = "Untitled";

        final String URL_STRING = "http://0.0.0.0:4723/wd/hub";
        url = new URL(URL_STRING);

        if (deviceTypeStr.equals("Galaxy")) {
            switch (BrowserType.forName(browserTypeStr)) {
                case YNETAPP:
                    DesiredCapabilities dc = new DesiredCapabilities();
                    dc.setCapability("reportDirectory", reportDirectory);
                    dc.setCapability("reportFormat", reportFormat);
                    dc.setCapability("testName", testName);
                    dc.setCapability(MobileCapabilityType.UDID, "RF8M70BV4VP");
                    dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "im.spot.sdk.ynet.ynet");
                    dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.publishersampleapp.YnetArticlesActivity");

                    driverAndroid = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
                    driverAndroid.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                    break;
                default:
                    throw new IllegalArgumentException("Only iPhone and Galaxy are currently supported!");
            }
            return driverAndroid;
        }
        else if (deviceTypeStr.equals("iPhone")) {
            switch (BrowserType.forName(browserTypeStr)) {
                case YNETAPP:
                    DesiredCapabilities dc = new DesiredCapabilities();
                    dc.setCapability("reportDirectory", reportDirectory);
                    dc.setCapability("reportFormat", reportFormat);
                    dc.setCapability("testName", testName);
                    dc.setCapability(MobileCapabilityType.UDID, "5A481C35-8E87-4C51-9D9E-92562E27C159");

                    driverIos = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
                    driverIos.setLogLevel(Level.INFO);
                    driverIos.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                    break;
                default:
                    throw new IllegalArgumentException("Only iPhone and Galaxy are currently supported!");
            }
            return driverIos;
        }
        return driver;
    }

    public static WebDriver getRemotePcInstance() throws MalformedURLException {
        String browserTypeStr = AutomationSystemProperties.BROWSER_TYPE;
        WebDriver driver;
        String gridURL = null;
        gridURL = "http://192.168.10.30:5559/wd/hub";
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        switch (BrowserType.forName(browserTypeStr)) {
            case FIREFOX:
                DesiredCapabilities firefox = DesiredCapabilities.firefox();
                capability.setBrowserName("firefox");
                capability.setPlatform(Platform.WIN10);
                driver = new RemoteWebDriver(new URL(gridURL), firefox);
                break;
            case CHROME:
                capability.setBrowserName("chrome");
                capability.setPlatform(Platform.WIN10);
                capability = DesiredCapabilities.chrome();
                driver = new RemoteWebDriver(new URL(gridURL), capability);
                break;
            case IE:
                DesiredCapabilities d = DesiredCapabilities.internetExplorer();
                d.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
                d.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                d.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
                d.setCapability("nativeEvents", false);
                d.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                d.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
                driver = new RemoteWebDriver(new URL(gridURL), d);
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Only Firefox, Chrome, Safari and IE are currently supported!");
        }
        return driver;
    }


//    Paz when you will come back to Mobile check if Android driver and IOS driver are working toghter if not - this is the code with the remoteDriver that will work.

//    public static WebDriver getAppiumMobileInstance() throws MalformedURLException {
//        String browserTypeStr = AutomationSystemProperties.BROWSER_TYPE;
//        String deviceTypeStr = AutomationSystemProperties.DEVICE_TYPE;
//        WebDriver driver = null;
//        String reportDirectory = "reports";
//        String reportFormat = "xml";
//        String testName = "Untitled";
//        final String URL_STRING = "http://0.0.0.0:4723/wd/hub";
//        url = new URL(URL_STRING);
//        if (deviceTypeStr.equals("Galaxy")) {
//            switch (BrowserType.forName(browserTypeStr)) {
//                case YNETAPP:
//                    DesiredCapabilities dc = new DesiredCapabilities();
//                    dc.setCapability("reportDirectory", reportDirectory);
//                    dc.setCapability("reportFormat", reportFormat);
//                    dc.setCapability("testName", testName);
//                    dc.setCapability(MobileCapabilityType.UDID, "RF8M70BV4VP");
//                    dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "im.spot.sdk.ynet.ynet");
//                    dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.publishersampleapp.YnetArticlesActivity");
//                    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
//                    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//                    break;
//                default:
//                    throw new IllegalArgumentException("Only Firefox, Chrome, Safari and IE are currently supported!");
//            }
//            return driver;
//        } else if (deviceTypeStr.equals("iPhone")) {
//            switch (BrowserType.forName(browserTypeStr)) {
//                case YNETAPP:
//                    DesiredCapabilities dc = new DesiredCapabilities();
//                    dc.setCapability("reportDirectory", reportDirectory);
//                    dc.setCapability("reportFormat", reportFormat);
//                    dc.setCapability("testName", testName);
//                    dc.setCapability(MobileCapabilityType.UDID, "");
//                    dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "im.spot.sdk.ynet.ynet");
//                    dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.example.publishersampleapp.YnetArticlesActivity");
//                    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
//                    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//                    break;
//                default:
//                    throw new IllegalArgumentException("Only Firefox, Chrome, Safari and IE are currently supported!");
//            }
//        }
//        return driver;
//    }
}