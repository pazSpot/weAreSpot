//package fed.utilities;
//
//
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.util.concurrent.TimeUnit;
//
//
//public class UiUtilities extends BaseTests {
//    RemoteWebDriver driver;
//    private static String pageUrl;
//
//    public void openBrandHomePage(String brand) throws Exception {
//
//        String brandName = chooseBrand(brand);
//        if (brandName.equals("conversation")) {
//            pageUrl = ("http://www.spotim.name/lia-username/lia1.html");
//        } else if (brandName.equals("conversationRedesignLight")) {
//            pageUrl = ("http://www.spotim.name/bd-playground/redesign.html");
//        } else if (brandName.equals("conversationRedesignDark")) {
//            pageUrl = ("http://www.spotim.name/bd-playground/redesign.html?darkMode=1");
//        } else if (brandName.equals("conversationFoxNewsProduction")) {
//            pageUrl = ("https://www.foxnews.com/");
//        } else if (brandName.equals("conversationAolProduction")) {
//            pageUrl = ("https://www.aol.com/");
//        } else if (brandName.equals("conversationTimesProduction")) {
//            pageUrl = ("https://www.thetimes.co.uk/");
//        } else if (brandName.equals("moderation")) {
//            pageUrl = ("https://admin.spot.im/");
//        } else if (brandName.equals("liveBlog")) {
//            pageUrl = ("http://www.spotim.name/lia-playground/liveBlog.html ");
//        } else if (brandName.equals("starReviews")) {
//            pageUrl = ("https://s3.amazonaws.com/www.spotim.name/bd-playground/social-reviews.html ");
//        } else if (brandName.equals("recirculation")) {
//            pageUrl = ("https://s3.amazonaws.com/www.spotim.name/lia-playground/pitc-test.html ");
//        } else if (brandName.equals("spotlightComment")) {
//            pageUrl = ("http://www.spotim.name/lia-playground/lia2.html ");
//        } else if (brandName.equals("spotlightEmail")) {
//            pageUrl = ("http://www.spotim.name/silo/automation2.html ");
//        } else if (brandName.equals("spotlightEmailTop")) {
//            pageUrl = ("http://www.spotim.name/bd-playground/spotlightTop.html ");
//        } else if (brandName.equals("spotlightBD")) {
//            pageUrl = ("http://www.spotim.name/bd-playground/spotlight.html ");
//        } else if (brandName.equals("messageCountWidget")) {
//            pageUrl = ("http://www.spotim.name/bd-playground/messages-count.html ");
//        } else if (brandName.equals("liaPlayground5")) {
//            pageUrl = ("https://s3.amazonaws.com/www.spotim.name/lia-playground/lia5.html ");
//        } else if (brandName.equals("pazPlayground1")) {
//            pageUrl = ("http://www.spotim.name/paz-playground/paz1.html ");
//        } else if (brandName.equals("conversationRCPProduction")) {
//            pageUrl = ("https://www.realclearpolitics.com/articles/2019/09/25/trump_attacks_globalism_and_urges_action_on_iran_at_un_141338.html ");
//        } else if (brandName.equals("liaPlayground1")) {
//            pageUrl = ("http://www.spotim.name/lia-playground/lia1.html ");
//        } else if (brandName.equals("messageCount")) {
//            pageUrl = ("http://www.spotim.name/bd-playground/messages-count.html");
//        } else if (brandName.equals("fedEvents")) {
//            pageUrl = ("http://www.spotim.name/bd-playground/events.html ");
//        } else if (brandName.equals("liveBlog2")) {
//            pageUrl = ("http://www.spotim.name/lia-playground/liveBlog2.html ");
//        } else if (brandName.equals("liveBlogZero")) {
//            pageUrl = ("http://www.spotim.name/lia-playground/liveBlog3.html ");
//        } else if (brandName.equals("liveBlogNoReplies")) {
//            pageUrl = ("http://www.spotim.name/lia-playground/liveBlogNoReplies.html ");
//        } else if (brandName.equals("starReviewsLia")) {
//            pageUrl = ("http://www.spotim.name/lia-playground/social-reviews.html ");
//        } else if (brandName.equals("conversationBD1")) {
//            pageUrl = ("http://www.spotim.name/bd-playground/post1.html ");
//        } else if (brandName.equals("starReviews2")) {
//            pageUrl = ("https://s3.amazonaws.com/www.spotim.name/lia-playground/social-reviews2.html ");
//        } else if (brandName.equals("siloSample")) {
//            pageUrl = ("http://www.spotim.name/silo/automation.html ");
//        }else if (brandName.equals("liaPlayground3")) {
//            pageUrl = ("http://www.spotim.name/lia-playground/lia3.html ");
//        }
//
//
//
//        driver.get(pageUrl);
//
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        //JavascriptExecutor jse = (JavascriptExecutor) driver;
//        driver.manage().deleteAllCookies();
//        //jse.executeScript("javascript:localStorage.clear();");
//        Thread.sleep(100);
//        //jse.executeScript("sessionStorage.setItem('CURRENT_LOCATION','{}');");
//        System.out.println("*************************************************************");
//        System.out.println("Brand name = " + brandName);
//        System.out.println("*************************************************************");
//
//        System.out.println(brand + "home page Opened successfully.");
//    }
//}
