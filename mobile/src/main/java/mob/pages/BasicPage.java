package mob.pages;

import mob.browsers.Driver;
import mob.utilities.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;

public abstract class BasicPage {
    WebDriver driver;
    Actions actions;

    BasicPage() {
        this.driver = Driver.Instance;
        this.actions = new Actions(driver);
    }

    public BasicPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


    public void setActions(Actions act) {
        this.actions = act;
    }

    public void refresh() {
        Log.info("Refreshing the page");
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(getPageIdentifier()));
    }

    public String getElementBackgroundColor(WebElement webElement) {
        if (webElement != null) {
            return webElement.getCssValue("background-color");
        }
        return null;
    }

    public String analyzeLog() {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        LogEntries logEntries = driver.manage().logs().get("browser");
        return logEntries.getAll().toString();
    }

    public void scrollToPageIdentifier() {
        WebElement identifier = driver.findElement(getPageIdentifier());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", identifier);
        actions.moveToElement(identifier).build().perform();
    }

    public abstract By getPageIdentifier();

    public static String chooseBrand(String brand) {
        if (brand.equals("conversation") || brand.equals("conversationTimesProduction") || brand.equals("conversationRedesignLight") || brand.equals("conversationRedesignDark") || brand.equals("conversationAolProduction") || brand.equals("conversationFoxNewsProduction") || brand.equals("moderation") || brand.equals("liveBlog") || brand.equals("starReviews") ||
                brand.equals("recirculation") || brand.equals("spotlightComment") || brand.equals("spotlightEmail") || brand.equals("messageCountWidget")
                || brand.equals("conversationBD1")
                || brand.equals("liaPlayground5") || brand.equals("pazPlayground1") || brand.equals("conversationRCPProduction") || brand.equals("liaPlayground1") ||
                brand.equals("messageCount") || brand.equals("fedEvents") || brand.equals("liveBlog2") || brand.equals("liveBlogZero") || brand.equals("liveBlogNoReplies") || brand.equals("starReviewsLia") || brand.equals("spotlightEmailTop") || brand.equals("spotlightBD")) {
            return brand;
        }
        return null;
    }

    public static void setDimensions(WebDriver driver, int dimension) {
        switch (dimension) {
            case 0:
                //smallest - mobile
                Dimension a = new Dimension(320, 568);
                driver.manage().window().setSize(a);
                Log.info("Screen size is : " + a);
                break;
            case 1:
                //small - mobile
                Dimension b = new Dimension(600, 960);
                driver.manage().window().setSize(b);
                Log.info("Screen size is : " + b);
                break;
            case 2:
                //large - tablet
                Dimension c = new Dimension(800, 1280);
                driver.manage().window().setSize(c);
                Log.info("Screen size is : " + c);
                break;
            case 3:
                Dimension d = new Dimension(1070, 970);
                driver.manage().window().setSize(d);
                Log.info("Screen size is : " + d);
                break;
            case 4:
                Dimension e = new Dimension(1366, 768);
                driver.manage().window().setSize(e);
                Log.info("Screen size is : " + e);
                break;
            case 5:
                //biggest - desktop
                Dimension f = new Dimension(1920, 1080);
                driver.manage().window().setSize(f);
                Log.info("Screen size is : " + f);
                break;
            case 6:
                //biggest - desktop
                Dimension g = new Dimension(2048, 1536);
                driver.manage().window().setSize(g);
                Log.info("Screen size is : " + g);
                break;
        }
    }
}
