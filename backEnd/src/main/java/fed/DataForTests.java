package fed;

import org.testng.annotations.DataProvider;

import java.util.Random;
import java.util.stream.Collectors;

public class DataForTests {

    public static String random() {
        int length = 6;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789";
        String str = new Random().ints(length, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());
        return str;
    }

    public DataForTests() throws Exception {

    }

    @DataProvider(name = "data")
    public static Object[][] data() throws Exception {
        return new Object[][]{
                {"F_" + random(), "L_" + random(), "050555555555", "Aut" + random() + "@gmail.com", "Aa123456789"},
                {"F_" + random(), "L_" + random(), "050555555555", "Aut" + random() + "@gmail.com", "Aa123456789"},
        };
    }

    @DataProvider(name = "users")
    public static Object[][] users() throws Exception {
        return new Object[][]{
                {"email_RDF7SPNq@gmail.com", "Aa123456789"},
                {"email_x3r1ixN0@gmail.com", "Aa123456789"},
        };
    }

    @DataProvider(name = "conversation")
    public static Object[][] conversation() throws Exception {
        return new Object[][]{
                {"Guest", "my name is : spoti !", "Hello World !!!", "my name is : sp"},
                {"Guest", "my name is : QA !", "Hello World !!!", "my name is : QA"},
                {"Guest", "my name is : Automation !", "Hello World !!!", "my name is : Au"},
        };
    }

    @DataProvider(name = "restrictedWords")
    public static Object[][] restrictedWords() throws Exception {
        return new Object[][]{
                {"Guest", "rejected ", "Your post violated our policy."},
                {"Guest", "none ", "Your post violated our policy."},
                {"Guest", "arnon ", "Your post violated our policy."},
        };
    }

    @DataProvider(name = "createProfileConversation")
    public static Object[][] createProfileConversation() throws Exception {
        return new Object[][]{
                {"Guest", "my name is : spoti !", "Hello World !!!", "my name is : sp", "Create your profile", "automation", "Your email...", "Aut_" + random() + "@spot.im", "1q2w#E$R"},
                {"Guest", "my name is : QA !", "Hello World !!!", "my name is : QA", "Create your profile", "automation", "Your email...", "Aut_" + random() + "@spot.im", "1q2w#E$R"},
                {"Guest", "my name is : Automation !", "Hello World !!!", "my name is : Au", "Create your profile", "automation", "Your email...", "Aut_" + random() + "@spot.im", "1q2w#E$R"},
        };
    }

    @DataProvider(name = "commentAsUser")
    public static Object[][] commentAsUser() throws Exception {
        return new Object[][]{
                {"User", "automation_tsK@spot.im", "Abc123456789!", "Automation_Rkl", "Hello World !!!"},
                {"User", "automation_tsK@spot.im", "Abc123456789!", "Automation_Rkl", "Hello Spot IM"},
        };
    }

    @DataProvider(name = "replyCommentAsUser")
    public static Object[][] replyCommentAsUser() throws Exception {
        return new Object[][]{
//                {"User", "automation_yu9@spot.im", "Abc123456789!", "Automation_J4N", "Hello World !!!","Reply to","I'm replying to you!!!"},
                {"User", "automation_tsK@spot.im", "Abc123456789!", "Automation_Rkl", "Hello World !!!", "Reply to", "I'm replying to you!!!"},
//                {"User", "automation_PGB@spot.im", "Abc123456789!", "Automation_pQT", "Hello Spot IM","Reply to"},
//                {"User", "automation_tsK@spot.im", "Abc123456789!", "Automation_tsK", "Hello Spot IM","Reply to"},
        };
    }

    @DataProvider(name = "conversationLogin")
    public static Object[][] conversationLogin() throws Exception {
        return new Object[][]{
                {"automation_tsK@spot.im", "Abc123456789!", "Automation_Rkl"},
                {"automation_gas@spot.im", "Abc123456789!", "Automation_OPV"},
                {"automation_hGr@spot.im", "Abc123456789!", "Automation_faV"},
        };
    }

    @DataProvider(name = "userOptions")
    public static Object[][] userOptions() throws Exception {
        return new Object[][]{
                {"automation_tsK@spot.im", "Abc123456789!", "Automation_Rkl", "Profile", "My Activity"},
                {"automation_gas@spot.im", "Abc123456789!", "Automation_OPV", "Settings", "My Settings"},
                {"automation_hGr@spot.im", "Abc123456789!", "Automation_faV", "Privacy", "My Privacy"},
//                {"automation_hGr@spot.im", "Abc123456789!", "Automation_faV","Log Out",""},
        };
    }

    @DataProvider(name = "conversationSignUp")
    public static Object[][] conversationSignUp() throws Exception {
        return new Object[][]{
                {"F_" + random(), "Aut_" + random() + "@spot.im", "Abc123456789!"},
                // due to ip block
//                {"F_" + random(), "Aut_" + random() + "@spot.im", "Abc123456789!"},
//                {"F_" + random(), "Aut_" + random() + "@spot.im", "Abc123456789!"},
//                {"F_" + random(), "Aut_" + random() + "@spot.im", "Abc123456789!"},
        };
    }

    @DataProvider(name = "forgotPassword")
    public static Object[][] forgotPassword() throws Exception {
        return new Object[][]{
                {"Aut_" + random() + "@spot.im", "Okay, we sent you an email with a reset link. If you don’t receive it within a few minutes, please try again."},
                {"Aut_" + random() + "@spot.im", "Okay, we sent you an email with a reset link. If you don’t receive it within a few minutes, please try again."},
                {"Aut_" + random() + "@spot.im", "Okay, we sent you an email with a reset link. If you don’t receive it within a few minutes, please try again."},
                {"Aut_" + random() + "@spot.im", "Okay, we sent you an email with a reset link. If you don’t receive it within a few minutes, please try again."},
                {"Aut_" + random() + "@spot.im", "Okay, we sent you an email with a reset link. If you don’t receive it within a few minutes, please try again."},
        };
    }

    @DataProvider(name = "fullStarRating")
    public static Object[][] fullStarRating() throws Exception {
        return new Object[][]{
                {1},
                {2},
                {3},
                {4},
                {5},
        };
    }

    @DataProvider(name = "sortList")
    public static Object[][] sortList() throws Exception {
        return new Object[][]{
                {"Oldest"},
                {"Best"},
                {"Newest"},
        };
    }


    @DataProvider(name = "spotlightEmail")
    public static Object[][] spotlightEmail() throws Exception {
        return new Object[][]{
                {"pass", "lia@troll.com", "Thanks! Keep an eye on your inbox for more details."},
                {"fail", "aa@aa", "This email address is invalid"},
        };
    }
}

