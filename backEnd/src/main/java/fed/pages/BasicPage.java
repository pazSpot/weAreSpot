//package fed.pages;
//
//
//import fed.utilities.Log;
//import org.openqa.selenium.*;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//
//public class BasicPage {
//    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
//    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
//    public CapabilityFactory capabilityFactory = new CapabilityFactory();
//
//    @BeforeMethod
//    @Parameters(value={"browser"})
//    public void setup (String browser) throws MalformedURLException {
//        //Set Browser to ThreadLocalMap
//        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilityFactory.getCapabilities()));
//    }
//
//
//    public WebDriver getDriver() {
//        //Get driver from ThreadLocalMap
//        return driver.get();
//    }
//
//
//
//    public String getElementBackgroundColor(WebElement webElement) {
//        if (webElement != null) {
//            return webElement.getCssValue("background-color");
//        }
//        return null;
//    }
//
//
//
//    public static String chooseBrand(String brand) {
//        if (brand.equals("conversation") || brand.equals("conversationTimesProduction") || brand.equals("conversationRedesignLight")
//                || brand.equals("conversationRedesignDark") || brand.equals("conversationAolProduction")
//                || brand.equals("conversationFoxNewsProduction") || brand.equals("moderation")
//                || brand.equals("liveBlog") || brand.equals("starReviews") ||
//                brand.equals("recirculation") || brand.equals("spotlightComment") || brand.equals("spotlightEmail") || brand.equals("messageCountWidget")
//                || brand.equals("conversationBD1")|| brand.equals("siloSample") || brand.equals("liaPlayground3")
//                || brand.equals("liaPlayground5") || brand.equals("pazPlayground1") || brand.equals("conversationRCPProduction") || brand.equals("liaPlayground1") ||
//                brand.equals("messageCount") || brand.equals("fedEvents") || brand.equals("liveBlog2") || brand.equals("liveBlogZero") || brand.equals("liveBlogNoReplies") || brand.equals("starReviewsLia") || brand.equals("spotlightEmailTop") || brand.equals("spotlightBD")|| brand.equals("starReviews2")) {
//            return brand;
//        }
//        return null;
//    }
//
//    public static void setDimensions(WebDriver driver, int dimension) {
//        switch (dimension) {
//            case 0:
//                //smallest - mobile
//                Dimension a = new Dimension(320, 568);
//                driver.manage().window().setSize(a);
//                Log.info("Screen size is : " + a);
//                break;
//            case 1:
//                //small - mobile
//                Dimension b = new Dimension(600, 960);
//                driver.manage().window().setSize(b);
//                Log.info("Screen size is : " + b);
//                break;
//            case 2:
//                //large - tablet
//                Dimension c = new Dimension(800, 1280);
//                driver.manage().window().setSize(c);
//                Log.info("Screen size is : " + c);
//                break;
//            case 3:
//                Dimension d = new Dimension(1070, 970);
//                driver.manage().window().setSize(d);
//                Log.info("Screen size is : " + d);
//                break;
//            case 4:
//                Dimension e = new Dimension(1366, 768);
//                driver.manage().window().setSize(e);
//                Log.info("Screen size is : " + e);
//                break;
//            case 5:
//                //biggest - desktop
//                Dimension f = new Dimension(1920, 1080);
//                driver.manage().window().setSize(f);
//                Log.info("Screen size is : " + f);
//                break;
//            case 6:
//                //biggest - desktop
//                Dimension g = new Dimension(2048, 1536);
//                driver.manage().window().setSize(g);
//                Log.info("Screen size is : " + g);
//                break;
//        }
//    }
//}
