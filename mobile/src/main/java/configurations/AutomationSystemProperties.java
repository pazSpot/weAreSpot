package configurations;

public class AutomationSystemProperties {

    public static final String WEB_HOST = System.getProperty("tests.ui.webHost", "http://www.spotim.name/liastaging/post1.html");
    public static final String CP_HOST = System.getProperty("tests.ui.cpHost", "http://cpv2.spotim.name/gossip");
    public static final String CHROME_DRIVER_PATH = System.getProperty("tests.ui.chrome.driver", "chromedriver");
    public static final String FIREFOX_DRIVER_PATH = System.getProperty("tests.ui.firefox.driver", "geckodriver");
    public static final String IE_DRIVER_PATH = System.getProperty("tests.ui.ie.driver", "/usr/local/bin/geckodriver");
    public static final String BROWSER_LOCATION = System.getProperty("tests.ui.browserLocation", "APPIUM");
    // Options are: LOCAL/REMOTE/APPIUM/REMOTEPC
    public static final String BROWSER_TYPE = System.getProperty("tests.ui.browserType", "YNETAPP");
    //Options are: CHROME/IE/SAFARI/FIREFOX/YNETAPP/IOS/ANDROID
    public static final String DEVICE_TYPE = System.getProperty("tests.ui.deviceType", "Galaxy");
    //Options are: iPhone/Galaxy
    public static final String ENV_TYPE = System.getProperty("tests.general.envType", "PROD");
    //Options are: PROD/STG
    public static final String SCREEN_SIZE = System.getProperty("tests.general.screenSize", "5");
    // 0/1/2/3/4/5/6
    public static final String SERVER_BASE_URI = System.getProperty("tests.be.server.url", "https://" + getBaseURI() + "/api");
    public static final String API_GW_BASE_URI = System.getProperty("tests.be.api.gw.url", "https://api-2-0.spot.im/v1.0.0");
    public static final String CP_BASE_URI = System.getProperty("tests.be.cp.url", "https://staging-cpv2.socialconv.com");
    public static final String CP_SPOXY_BASE_URI = System.getProperty("tests.be.cp.url", "https://community-spoxy.spot.im");
    public static final String API_BASE_URI = System.getProperty("tests.be.api.url", "https://community-api.staging-spot.im");
    public static final String INIT_URI = System.getProperty("tests.open.api.url", "https://init.staging-spot.im");
    public static final String OPEN_API_URI = System.getProperty("tests.open.api.url", "https://open-api.staging-spot.im");
    public static final String MOBILE_GW_API_URI = System.getProperty("tests.mobile.gw.url", "https://mobile-gw.spot.im");
    public static final String PS_BASE_URI = System.getProperty("tests.ps.api.url", "https://ps." + getEnvBase() + "spot.im");
    public static final String HOST_PANEL_V2_URI = System.getProperty("tests.hp.v2.url", "https://host-panel-v2.spot.im");
    public static final String SPOT_ID = System.getProperty("tests.general.spotId", "sp_Yl8sVhVg");
    public static final String POST_ID = System.getProperty("tests.general.postId", "post1");
    public static final String CP_SPOT_ID = System.getProperty("tests.generl.cpSpotID", "sp_aKCoH5o4");
    public static final String TOPIC_ID = System.getProperty("tests.general.topicID", "top_IlqS8QPvzQSb");
    public static final String TOPIC_NAME = System.getProperty("tests.general.topicName", "gossip");
    public static final String NETWORK_ID = System.getProperty("tests.general.networkID", "net_celebritynewsnossostaging");
    // Configuration For BrowserStack Selenium Grid
    public static final String USERNAME = "pazezrati1";
    public static final String AUTOMATE_KEY = "Jr9tqH48u7Au1Up5kdqB";
    public static final String BS_GRID_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static final String SPOT_GRID_URL = "http://selenium.spotim.vpc:4444/wd/hub";
    public static final String PRACTITEST_URI = "https://api.practitest.com/api/v2/projects/11462";
    public static final String PT_MAIL = "lia@spot.im";
    public static final String PT_TOKEN = "df2ea7f0e44331e07dc44ece35a82975df8c60a3";
    public static final String ORIGIN = getOrigin();

    public static String getBaseURI() {
        if (ENV_TYPE.equals("STG")) {
            return "v2.staging-spot.im";
        } else
            return "www.spot.im";
    }

    public static String getEnvBase() {
        if (ENV_TYPE.equals("STG")) {
            return "staging-";
        } else
            return "";
    }

    public static String getOrigin() {
        if (ENV_TYPE.equals("STG")) {
            return "https://spoxy.staging-spot.im";
        } else
            return "http://www.spotim.name";
    }
}
