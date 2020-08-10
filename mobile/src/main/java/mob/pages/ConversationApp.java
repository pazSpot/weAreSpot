package mob.pages;

import mob.browsers.Driver;
import mob.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConversationApp extends BasicPage {

    @FindBy(id = "tvPreConvWriteComment")
    @CacheLookup
    WebElement commentYnetAndroid;

    @FindBy(xpath = "//*[@id='הוספת תגובה']")
    @CacheLookup
    WebElement commentYnetIos;

    @FindBy(xpath = "//*[@text='YnetSpot']")
    @CacheLookup
    WebElement ynetAppIos;

    @FindBy(xpath = "//*[@id='הוספת תגובה']")
    @CacheLookup
    WebElement userNameYnetIos;

    @FindBy(xpath = "//*[@text='הוספת תגובה']")
    @CacheLookup
    WebElement userCommentYnetIos;

    @FindBy(xpath = "//*[@text='הגב']")
    @CacheLookup
    WebElement postCommentButtonIos;

    @FindBy(xpath = "//*[@id='etUserName']")
    @CacheLookup
    WebElement userNameYnet;

    @FindBy(xpath = "//*[@id='הוספת תגובה']")
    @CacheLookup
    WebElement userCommentYnet;

    @FindBy(xpath = "//*[@id='btnPost']")
    @CacheLookup
    WebElement postCommentButton;


    public ConversationApp() {
        super();
        PageFactory.initElements(driver, this);
    }

    @Override
    public By getPageIdentifier() {
        return null;
    }

    public void clickOnCommentAndroid() {
        Log.info("Clicking on create comment");
        try {
            Thread.sleep(2000);
            WebElement conversationComment = commentYnetAndroid;
            conversationComment.click();
        } catch (Exception e) {
            Log.info("Error clicking on create comment button");
        }
    }

    public void openYnetAppIos() {
        Log.info("Clicking on Ynet app");
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            Thread.sleep(2000);
            WebElement conversationComment = ynetAppIos;
            conversationComment.click();
        } catch (Exception e) {
            Log.info("Error clicking on ynet app button");
        }
    }

    public void chooseArticleAndroid() {
        Log.info("Clicking on ynet article");
        try {
            List<WebElement> articlesYnetApp = Driver.Instance.findElements(By.id("cvArticle"));
            int size = articlesYnetApp.size();
            Log.info("size of articles = " + size);
            for (int i = 0; i < size; i++) {
                String article = articlesYnetApp.get(i).getText();
                Log.info(article);
                articlesYnetApp.get(i).click();
                break;
            }
        } catch (Exception e) {
            Log.info("Error clicking on one of ynet article ");
        }
    }

    public void scrollDown() {
        Log.info("Scrolling down ");
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            Thread.sleep(3000);
            for (int i = 0; i < 4; i++) {
                JavascriptExecutor js = (JavascriptExecutor) Driver.Instance;
                HashMap<String, String> scrollObject = new HashMap<String, String>();
                scrollObject.put("direction", "down");
                js.executeScript("mobile: scroll", scrollObject);
                i++;
            }
        } catch (Exception e) {
            Log.info("Error: Scrolling down the app");
        }
    }

    public void clickOnUserName() {
        Log.info("Clicking on user name ");
        try {
            WebElement conversationName = userNameYnet;
            conversationName.click();
        } catch (Exception e) {
            Log.info("Error clicking on user name");
        }
    }

    public void insertUserNameAndroid(String userName) {
        Log.info("Entering user Name - Ynet app");
        try {
            WebElement conversationName = userNameYnet;
            conversationName.sendKeys(userName);
        } catch (Exception e) {
            Log.info("Error Entering user name - Ynet app");
        }
    }

    public void clickingOnCommentIos() {
        Log.info("Clicking on comment - Ynet app");
        try {
            WebElement conversationComment = userCommentYnet;
            conversationComment.click();
        } catch (Exception e) {
            Log.info("Error Entering user password - Times of London");
        }
    }

    public void insertUserCommentIos(String comment) throws Exception {
//        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Log.info("Entering user comment : " + comment);
        try {
            WebElement conversationComment = userCommentYnet;
            conversationComment.sendKeys(comment);
        } catch (Exception e) {
            Log.info("Error Entering user comment - Ynet app");
        }
    }

    public void clickOnUserNameIos() {
        Log.info("Clicking on user name ");
        try {
            WebElement conversationName = userNameYnetIos;
            conversationName.click();
        } catch (Exception e) {
            Log.info("Error clicking on user name");
        }
    }

    public void insertUserNameIos(String userName) {
        Log.info("Entering user Name - Ynet app");
        try {
            WebElement conversationName = userNameYnetIos;
            conversationName.sendKeys(userName);
        } catch (Exception e) {
            Log.info("Error Entering user name - Ynet app");
        }
    }

    public void clickingOnComment() {
        Log.info("Clicking on comment - Ynet app");
        try {
            WebElement conversationComment = userCommentYnet;
            conversationComment.click();
        } catch (Exception e) {
            Log.info("Error Entering user password - Times of London");
        }
    }

    public void insertUserComment(String comment) {
        Log.info("Entering user comment : " + comment);
        try {
            WebElement conversationComment = userCommentYnet;
            conversationComment.sendKeys(comment);
        } catch (Exception e) {
            Log.info("Error Entering user comment - Ynet app");
        }
    }

    public void clickOnPostCommentIos() throws Exception {
//        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Log.info("Clicking on post comment - Ynet app");
        try {
            WebElement submit = postCommentButtonIos;
            submit.click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            Thread.sleep(2000);
        } catch (Exception e) {
            Log.info("Error clicking on post comment - Ynet app");
        }
    }

    public void chooseArticleIos() throws Exception {
//        Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Log.info("Clicking on one of ynet articles");
        try {
            List<WebElement> articlesYnetApp = Driver.Instance.findElements(By.xpath("//*[@class='UIAView']"));
            int size = articlesYnetApp.size();
            Log.info("size of ynet articles: " + size);
            for (int i = 0; i < size; i++) {
                String article = articlesYnetApp.get(i).getText();
                Log.info("The article is: " + article);
                articlesYnetApp.get(i).click();
                break;
            }
        } catch (Exception e) {
            Log.info("Error clicking on one of ynet article ");
        }
    }

    public void clickOnCommentIos() {
        Log.info("Clicking on create comment");
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            Thread.sleep(2000);
            WebElement conversationComment = commentYnetIos;
            conversationComment.click();
        } catch (Exception e) {
            Log.info("Error: Clicking on create comment button");
        }
    }
}