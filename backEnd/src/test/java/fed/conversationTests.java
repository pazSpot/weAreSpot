//package fed;
//
//
//import fed.browsers.Driver;
//import fed.pages.ConversationPage;
//import fed.utilities.BaseTests;
//import fed.utilities.UiUtilities;
//
//import org.springframework.context.annotation.Description;
//import org.testng.annotations.Test;
//
//
//
//public class conversationTests extends BaseTests {
//
//    @Description("Post comments as a guest")
//    @Test(groups = { "noIE" }, alwaysRun = true, dataProvider = "conversation", dataProviderClass = DataForTests.class)
//    public void postCommentAsGuestConversation(String userType, String nickName, String comment, String actualName) throws Exception {
//        ConversationPage conversationPage = new ConversationPage();
//        UiUtilities ui = new UiUtilities();
//
//
//
//        ui.openBrandHomePage("conversation");
//
//        conversationPage.clickOnNickName();
//        conversationPage.enterNickName(nickName);
//        conversationPage.enterComment(userType, comment);
//
//        conversationPage.clickOnPost();
//
//    }
//
//    @Description("Post hierarchy replay comment as login user")
//    @Test(groups = {"withIE"}, alwaysRun = true, dataProvider = "replyCommentAsUser", dataProviderClass = DataForTests.class)
//    public void postHierarchyReplayCommentAsLoginUserConversation(String userType, String email, String password, String actualName, String comment, String replyPlaceholder, String reply) throws Exception {
//        ConversationPage conversationPage = new ConversationPage();
//        UiUtilities ui = new UiUtilities();
//        ui.openBrandHomePage("conversation");
//
//        conversationPage.clickOnLogInHomePageButton();
//        conversationPage.insertUserEmail(email);
//        conversationPage.insertUserPassword(password);
//        conversationPage.clickOnLoginButton();
//
//        conversationPage.enterComment(userType, comment);
//
//
//        conversationPage.clickOnPost();
//
//    }
//
//
//}
