package mob;

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

    @DataProvider(name = "postCommentOnArticle")
    public static Object[][] postCommentOnArticle() throws Exception {
        return new Object[][]{
                {"My Name Is QA", "My Comment Is This: Aa1!"},
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

}

