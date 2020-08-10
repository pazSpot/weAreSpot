package mob.utilities;

import configurations.AutomationSystemProperties;
import fed.browsers.Driver;
import fed.utilities.BaseTests;
import fed.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class ElementWait extends BaseTests {
    protected static int time = 30;

    public ElementWait() {
        super();
    }

    public boolean waitForElementToAppear_xpath(String xpathElement, int time) throws Exception {
        WebDriverWait wait = new WebDriverWait(Driver.Instance, time);
        boolean isExists;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathElement)));
        fed.utilities.Log.info("Waiting - Done.");
        isExists = true;
        Assert.assertTrue(isExists, "Waited " + time + " seconds to " + xpathElement + " element, without success...");
        return isExists;
    }

    public boolean waitForWebElementToAppearXpath(int zeroForClickableOneForVisible, WebElement xpathElement, int time) throws Exception {
        WebDriverWait wait = new WebDriverWait(Driver.Instance, time);
        try {
            switch (zeroForClickableOneForVisible) {
                case 0: {
                    wait.until(ExpectedConditions.elementToBeClickable(xpathElement));
                    fed.utilities.Log.info("Clickable element was found - Done.");
                    break;
                }
                case 1: {
                    wait.until(ExpectedConditions.visibilityOf(xpathElement));
                    fed.utilities.Log.info("Visible element was found - Done.");
                    break;
                }
            }
        } catch (Exception e) {
            fed.utilities.Log.info("Waiting " + time + " sec for webElement on page  - Failed.");
            return false;
        }
        return true;
    }

    public void waitForElementToDisappear_xpath(String xpathElement, int time) throws
            Exception {
        boolean isOk;
        try {
            Boolean isPresent = true;
            int counter = 0;
            while ((isPresent) || (counter < time)) {
                Thread.sleep(1000);
                if (counter > time) {
                    fed.utilities.Log.info("Taking screen shot:");
                    isOk = false;
                    Assert.assertTrue(isOk, "Error: Waited for element " + counter + " seconds. ");
                }
                try {
                    Driver.Instance.findElement(By.xpath(xpathElement));
                } catch (Exception e) {
                    break;
                }
                fed.utilities.Log.info("Waiting for element: " + xpathElement + " to disappear...");
                counter = counter + 1;
            }
            isOk = true;
        } catch (Exception e) {
            fed.utilities.Log.info("Taking screen shot:");
            isOk = false;
        }
        Assert.assertTrue(isOk, "Error: Waiting for element: " + xpathElement + " to disappear - failed");
    }

    public void waitForElementToAppear_xpth(String xpathElement, int time) throws
            Exception {
        Boolean isExist = false;
        int counter = 0;
        while (!isExist || counter < time) {
            Thread.sleep(1000);
            if (counter > time) {
                fed.utilities.Log.info("Could not find xpath element ('" + xpathElement + "') after " + time + " seconds...");
                throw new SkipException("Could not find id element ('" + xpathElement + "') after " + time + " seconds...");
            }
            isExist = isElementPresent_xpath(xpathElement);
            if (isExist) {
                //isExist == true -> element found. stop.
                break;
            } else {
                //isExist == false -> element was not found, trying again...
                fed.utilities.Log.info("Waiting for element: " + xpathElement + "...");
                counter = counter + 1;
            }
        }
    }

    public void waitForElementToAppear_id(String idElement, int time) throws
            Exception {
        Boolean isExist = false;
        int counter = 0;
        while (!isExist || counter < time) {
            Thread.sleep(1000);
            if (counter > time) {
                fed.utilities.Log.info("Could not find id element ('" + idElement + "') after " + time + " seconds...");
                throw new Exception("Could not find id element ('" + idElement + "') after " + time + " seconds...");
            }
            isExist = isElementPresent_id(idElement);
            if (isExist) {
                //isExist == true -> element found. stop.
                break;
            } else {
                //isExist == false -> element was not found, trying again...
                fed.utilities.Log.info("Waiting for element: " + idElement + "...");
                counter = counter + 1;
            }
        }
    }

    public void waitForElementToDisappear_id(WebElement idElement, int time) throws
            Exception {
        Boolean isPresent = true;
        int counter = 0;
        while ((isPresent) || (counter < time)) {
            Thread.sleep(1000);
            if (counter > time) {
                fed.utilities.Log.info("id element ('" + idElement + "') did not disappeared after " + time + " seconds...");
                throw new Exception("id element ('" + idElement + "') did not disappeared after " + time + " seconds...");
            }
            try {
                idElement.isDisplayed();
            } catch (Exception e) {
                break;
            }
            fed.utilities.Log.info("Waiting for element: " + idElement + " to disappear...");
            counter = counter + 1;
        }
    }

    public void waitForElementToAppear_css(String cssElement, int time) throws
            Exception {
        Boolean isOk = true;
        Boolean isExist = false;
        int counter = 0;
        while (!isExist || counter < time) {
            Thread.sleep(1000);
            if (counter > time) {
                isOk = false;
                fed.utilities.Log.info("Could not find css element ('" + cssElement + "') after " + time + " seconds...");
                Assert.assertTrue(isOk, "Could not find css element ('" + cssElement + "') after " + time + " seconds...");
            }
            isExist = isElementPresent_css(cssElement);
            if (isExist) {
                //isExist == true -> element found. stop.
                Assert.assertTrue(isOk, "Could not find css element ('" + cssElement + "') after " + time + " seconds...");
                break;
            } else {
                //isExist == false -> element was not found, trying again...
                isOk = false;
                fed.utilities.Log.info("Could not find css element ('" + cssElement + "') after " + time + " seconds...");
                Assert.assertTrue(isOk, "Could not find css element ('" + cssElement + "') after " + time + " seconds...");
                counter = counter + 1;
            }
        }
    }

    public boolean isElementPresent_xpath(String xpathElement) throws Exception {
        boolean isExists = false;
        int counter = 0;
        while ((!isExists) && (counter < 10)) {
            Thread.sleep(1000);
            fed.utilities.Log.info("Waiting 10 sec for element " + xpathElement + " to appear ");
            isExists = Driver.Instance.findElement(By.xpath(xpathElement)).getSize().height > 0;
            if (isExists) {
                fed.utilities.Log.info("Element " + xpathElement + " was found.");
                return true;
            }
            counter = counter + 1;
        }
        fed.utilities.Log.info("Element " + xpathElement + " was not found.");
        return false;
    }

    public boolean isElementPresent_partialLinkText(String partialLinkText) {
        try {
            Driver.Instance.findElement(By.partialLinkText(partialLinkText));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent_id(String idElement) {
        try {
            Driver.Instance.findElement(By.id(idElement));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent_className(String classNameElement) {
        try {
            Driver.Instance.findElement(By.xpath(classNameElement));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresent_css(String cssElement) {
        try {
            Driver.Instance.findElement(By.xpath(cssElement));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * This is the right method to use!!!
     *
     * @param xpath
     * @param time
     * @return
     * @throws Exception
     */
    public boolean verifyingElementExistsOnPage(WebElement xpath, int time, String elementDescription) throws Exception {
        boolean isExists = false;
        if (AutomationSystemProperties.BROWSER_TYPE.equals("IE")) {
            ((JavascriptExecutor) Driver.Instance).executeScript("arguments[0].scrollIntoView();", xpath);
        }
        isExists = false;
        int counter = 0;
        while (!isExists) {
            Thread.sleep(1000);
            if (counter >= time) {
                fed.utilities.Log.info("Element " + elementDescription + " not found...");
                return isExists;
            } else {
                try {
                    Driver.Instance.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
                    isExists = xpath.getSize().height != 0;
                    Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
                    counter = counter + 1;
                } catch (Exception e) {
                    counter = counter + 1;
                }
                if (isExists) {
                    fed.utilities.Log.info("Element " + elementDescription + " found.");
                    return isExists;
                }
            }
        }
        fed.utilities.Log.info("Element " + elementDescription + " not found...");
        return isExists;
    }

    public boolean waitForUrlToAppear_contains(String partOfUrl, int time) throws Exception {
        try {
            new WebDriverWait(Driver.Instance, time).until(urlContains(partOfUrl));
            fed.utilities.Log.info(partOfUrl + " - was found in URL.");
        } catch (Exception e) {
            Log.info(partOfUrl + " - was not found in URL after " + time + " sec.");
            Assert.assertTrue(false, "(URL: " + Driver.Instance.getCurrentUrl() + "), " + partOfUrl + " - was not found on URL after " + time + " sec.");
        }
        return true;
    }
}