//package fed.browsers;
//
//import configurations.AutomationSystemProperties;
//import fed.pages.BasicPage;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.logging.LogType;
//import org.openqa.selenium.logging.LoggingPreferences;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.safari.SafariDriver;
//import org.testng.annotations.Parameters;
//
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//
//import static fed.pages.BasicPage.setDimensions;
//
//public class Driver  {
//
//    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
//
//
//    public static void quit() {
//        System.out.println("Quiting Browser");
//        driver.get().quit();
//    }
//
//
//
//        String gridURL = "http://localhost:4444/wd/hub";
//
//            case CHROME:
//
//                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//                System.setProperty("webdriver.chrome.driver", "/Users/pazezrati/Desktop/weAreSpot/frontEnd/chromedriver");
//                capabilities.setBrowserName("chrome");
//                capabilities.setPlatform(Platform.WINDOWS);
//                LoggingPreferences logPrefs = new LoggingPreferences();
//                logPrefs.enable(LogType.BROWSER, Level.ALL);
//
////                driver.set(new RemoteWebDriver(new URL(gridURL),capabilities));
//                break;
//            default:
//                throw new IllegalArgumentException("Only Firefox, Chrome, Safari and IE are currently supported!");
//        }
//        return driver.get();
//
//    }
//}