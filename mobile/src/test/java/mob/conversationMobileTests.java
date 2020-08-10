package mob;

import mob.pages.ConversationApp;
import mob.utilities.BaseTests;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

public class conversationMobileTests extends BaseTests {

    @Description("YNET APP - Post comments as a guest - Android")
    @Test(groups = {"MobileAndroid"}, alwaysRun = true, dataProvider = "postCommentOnArticle", dataProviderClass = DataForTests.class)
    public void postCommentAsGuestYnetConversationAndroid(String userName, String userComment) {
        ConversationApp conversationApp = new ConversationApp();

        conversationApp.chooseArticleAndroid();
        conversationApp.scrollDown();

        conversationApp.clickOnCommentAndroid();
        conversationApp.clickOnUserName();
        conversationApp.insertUserNameAndroid(userName);

        conversationApp.clickingOnComment();
        conversationApp.insertUserComment(userComment);
        conversationApp.clickingOnComment();
    }

    @Description("YNET APP - Post comments as a guest - IOS")
    @Test(groups = {"MobileIos"}, alwaysRun = true, dataProvider = "postCommentOnArticle", dataProviderClass = DataForTests.class)
    public void postCommentAsGuestYnetConversationIos(String userName, String userComment) throws Exception {
        ConversationApp conversationApp = new ConversationApp();

        conversationApp.openYnetAppIos();
        conversationApp.chooseArticleIos();
        conversationApp.scrollDown();
        conversationApp.clickOnCommentIos();

        conversationApp.clickOnCommentIos();
        conversationApp.insertUserCommentIos(userComment);
        conversationApp.clickOnPostCommentIos();

    }
}