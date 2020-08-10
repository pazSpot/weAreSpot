package mob.utilities;

import fed.utilities.Log;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class General {
    WebDriver driver;

    public General(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static String generateBullshit() {
        String[] verbs = new String[]{"aggregate", "architect", "benchmark", "brand", "cultivate", "deliver", "deploy", "disintermediate", "drive", "e-enable", "embrace", "empower", "enable", "engage", "engineer", "enhance", "envisioneer", "evolve"};
        String[] adjectives = new String[]{"24/365", "24/7", "B2B", "B2C", "back-end", "best-of-breed", "bleeding-edge", "bricks-and-clicks", "clicks-and-mortar", "collaborative", "compelling", "cross-platform", "cross-media", "customized", "cutting-edge"};

        String[] nouns = new String[]{"action-items", "applications", "architectures", "bandwidth", "channels", "communities", "content", "convergence", "deliverables", "e-business", "e-commerce", "e-markets", "e-services", "e-tailers", "experiences"};

        return buildSentences(verbs, adjectives, nouns);
    }

    public static String generateCapsLockBullshit() {
        String[] verbs = new String[]{"CONVERSATION", "LOVE", "LIKE", "ADMIRE", "DRIVE", "EMBRACE", "EMPOWER", "ENABLE", "ENGAGE", "EVOLVE", "CHEAT", "envisioneer", "evolve"};
        String[] adjectives = new String[]{"AMAZING", "MEMORABLE", "LITTLE", "BIG", "HEALTHY", "COLD", "SARCASTIC", "UNAWARE", "ENTHUSIASTIC"};
        String[] nouns = new String[]{"PONY", "HORSE", "RICHARD", "GREY", "PILOT", "KIDS", "SHMEL", "DOG", "SPOT", "STARK", "CONTENT", "MARRIAGE", "EUROPE", "BUSINESS", "SERVICE", "EXPERIENCE", "TAIL", "THRONES", "SNOW", "SAND", "RIVER"};

        return buildSentences(verbs, adjectives, nouns);
    }

    private static String buildSentences(String[] verbs, String[] adjectives, String[] nouns) {
        String verb = verbs[(int) Math.floor(Math.random() * verbs.length)];
        String adjective = adjectives[(int) Math.floor(Math.random() * adjectives.length)];
        String noun = nouns[(int) Math.floor(Math.random() * nouns.length)];

        String bullshit = verb + ' ' + adjective + ' ' + noun;
        return bullshit;
    }

    //Like the bullshit function just with random
    public static String addRandomToBullshit(int num) {
        return generateBullshit() + " " + RandomStringUtils.randomAlphabetic(num);
    }

    public static Color rgbaToColor(String rgbaFormat) {
        int red = Integer.valueOf(rgbaFormat.substring(rgbaFormat.indexOf("(") + 1, rgbaFormat.indexOf(",")));
        String remaining = rgbaFormat.substring(rgbaFormat.indexOf(",") + 1);
        int green = Integer.valueOf(remaining.substring(1, remaining.indexOf(",")));
        remaining = remaining.substring(remaining.indexOf(",") + 1);
        int blue = Integer.valueOf(remaining.substring(1, remaining.indexOf(",")));
        return new Color(red, green, blue);
    }

    public static String randomName() {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    /**
     * Create a random Number
     */
    public static int createRandNumber(int minimum, int maximum) throws Exception {
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;
        return randomNum;
    }

    public static String randString(int min, int max) {
        Random r = new Random();
        return String.valueOf(r.nextInt((max - min) + 1) + min);
    }

    public static int randInt(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void changeTab(int whatWindowYouNeed) throws Exception {
        fed.utilities.Log.info("Changing to tab " + whatWindowYouNeed);
        ArrayList<String> tabs = null;
        try {
            Thread.sleep(2000);
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(whatWindowYouNeed));
        } catch (Exception e) {
            Assert.assertTrue(false, "Was not able to change tab. found " + tabs.size() + " tabs.");
        }
    }

    public void changeWindow(int whatWindowYouNeed) throws Exception {
        fed.utilities.Log.info("Changing to window " + whatWindowYouNeed);
        try {
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
        } catch (Exception e) {
            Assert.assertTrue(false, "Was not able to change window. ");
        }
    }

    public void scrollIntoObjectView(WebElement element) throws Exception {
        fed.utilities.Log.info("Scrolling to view object on page");
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(1000);
        } catch (Exception e) {
            Assert.assertTrue(false, "Error: Scrolling to view object on page - failed. " + e);
        }
    }

    public void scrollIntoObjectView(By by) throws Exception {
        fed.utilities.Log.info("Scrolling to view object on page");
        WebElement element = driver.findElement(by);
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(1000);
        } catch (Exception e) {
            Assert.assertTrue(false, "Error: Scrolling to view object on page - failed. " + e);
        }
    }

    /**
     * Scroll up: negative number
     * Scroll down: positive number
     *
     * @param pixels
     * @throws Exception
     */
    public void scrollPage(String pixels) throws Exception {
        Log.info("Scrolling " + pixels + " on page");
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0," + pixels + ")");
            Thread.sleep(1000);
        } catch (Exception e) {
            Assert.assertTrue(false, "Error: Scrolling on page - failed. " + e);
        }
    }
}