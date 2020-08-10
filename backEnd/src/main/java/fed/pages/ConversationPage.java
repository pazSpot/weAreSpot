//package fed.pages;
//
//import configurations.AutomationSystemProperties;
//import fed.utilities.Log;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class ConversationPage extends BasicPage {
//    protected final static By MODAL_FRAME = By.id("spot-im-frame-modal-iframe");
//    protected final static By MODALS_SECTION = By.id("spot-im-frame-modal");
//
//    protected final static By COMMENTS_SECTION = By.cssSelector("div[data-spot-im-class='conversation-root']");
//    protected final static By LIKES_COUNT = By.className("spcv_up-votes");
//    protected final static By GREY_AVATAR = By.className("spcv_avatar-grey");
//    protected final static By DISQUS_CLAIM = By.className("spcv_disqus");
//    protected final static By SHOW_MORE_REPLIES = By.className("spcv_show-more-replies-button");
//    protected final static By SORT_BY = By.className("spcv_sort-by");
//    protected final static By RTE_BAR = By.className("spcv_format-button");
//    protected final static By SP_LOGIN_BUTTON = By.className("spcv_login-button");
//    protected final static By NOTIFICATION_BELL = By.className("spcv_notifications");
//    protected final static By SAY_CONTROL = By.className("spcv_simple-editor");
//    protected final static By COMMENT_EDITOR = By.className("spcv_editor");
//    protected final static By TEXT_FIELD = By.className("spcv_text-field");
//    protected final static By DROP_LIST = By.className("spcv_droplist-container");
//    protected final static By LIKERS_TOOLTIP = By.cssSelector("spcv_votes-summary-tooltip");
//    protected final static By DISLIKES_COUNT = By.className("spcv_down-votes");
//    protected final static By DISABLED_POST_BUTTON = By.className("spcv_disabled");
//    protected final static By PROFILE_PICTURE = By.className("spcv_user-image");
//    protected final static By SIGN_UP_WIZARD = By.className("spcv_signup-wizard");
//    protected final static By NEWSFEED_TITLE = By.className("spnf_label");
//    protected final static By NEWSFEED_BUTTON = By.className("spnf_button-wrap");
//    protected final static By NEWSFEED_GUEST_MESSAGE = By.className("spnf_details");
//    protected final static By NEWSFEED_SPOT_NAME = By.cssSelector("span.spnf_spot-name.brand-color");
//    protected final static By CONVERSATION_HEADER = By.cssSelector("[data-spot-im-class=\"header-text\"] > span[class=\"spcv_header-text\"]");
//    protected final static By DELETED_COMMENT = By.className("spcv_is-deleted");
//    protected final static By REJECTED_COMMENT = By.className("spcv_is-rejected");
//    protected final static By MESSAGE_STATUS = By.className("spcv_message-status");
//    protected final static By SAY_CONTROL_EXPANDED = By.className("spcv_expanded");
//    protected final static By MESSAGE_WRAPPER = By.className("spcv_message-data-wrapper");
//    protected final static By EXIT_MODAL = By.cssSelector("a[class^=\"CloseButton__Wrapper\"]");
//    protected final static By MESSAGE_COUNT = By.cssSelector("span[data-spotim-module=\"messages-count\"]");
//    protected final static By COMMENTS_COUNT = By.cssSelector("span[data-spot-im-class=\"comments-count\"]");
//    protected final static By REPLIES_COUNT = By.className("spot-im-replies-count");
//    protected final static By RICH_EDITOR_CONTAINER = By.className("spcv_rich-editor-container");
//    protected final static By RICH_EDITOR_INPUT = By.className("spcv_input-wrapper");
//    protected final static By REPLY_SELECTOR = By.cssSelector("li[aria-label='Comment reply']");
//    protected final static By MAIN_MODAL = By.cssSelector("a[class^=\"CloseButton__Wrapper\"]");
//    protected final static By COMMENT_USERNAME = By.className("spcv_username");
//    protected final static By USER_PROFILE_MODAL = By.cssSelector("div[data-testid=\"user-profile-modal\"]");
//    protected final static String LEVEL_REPLY = "spcv_depth-";
//    protected final static By EXIT_GUIDE_MODAL = By.cssSelector("div[class^='modal__ConfirmationButton']");
//    protected final static By ACTION_MODAL = By.className("dialog-modal");
//    protected final static By COMMENTS_COUNTER = By.xpath("//span[@data-spot-im-class='comments-count']");
//    protected final static By COMMENTS_SEND = By.cssSelector("button[data-spot-im-class='rich-editor-send-button']");
//    protected final static By COMMENTS_RTE = By.xpath("//div[@data-spot-im-class='rich-bar']");
//    protected final static By COMMENTS_GIPHY = By.xpath("//div[@data-spot-im-class='gif-button']");
//    protected final static By COMMENTS_EDITOR = By.className("ql-editor");
//    protected final static By NICKNAME_SECTION = By.className("spcv_display-name-input");
//    protected final static By NICKNAME_EDITOR = By.xpath("//div[@data-spot-im-class='rich-editor-input']/div/input");
//    protected final static By COMMENTS_FRAME = By.xpath("//iframe[@data-conversation-id]");
//    protected final static By COMMENT_SELECTOR = By.cssSelector("div[data-spot-im-class='rich-editor-input']");
//    protected final static By COMMENT_SELECTOR2 = By.cssSelector("div[data-spot-im-class='message-text']");
//    protected final static By USER_MENU = By.cssSelector("div[data-spot-im-class='current-user-menu']");
//    protected final static By PROFILE_ITEM = By.cssSelector("span[data-spot-im-class='profile-item']");
//    protected final static By SETTINGS_ITEM = By.cssSelector("span[data-spot-im-class='settings-item']");
//    protected final static By PRIVACY_ITEM = By.cssSelector("span[data-spot-im-class='privacy-item']");
//    protected final static By LOGOUT_ITEM = By.cssSelector("span[data-spot-im-class='logout-item']");
//    protected final static By TOP_MESSAGE = By.cssSelector("div[data-spot-im-class='message-view']");
//    protected final static By TOP_REPLY = By.cssSelector("div[data-message-depth='1']");
//    protected final static String COMMENT_LOCATOR_BY_VALUE = "//*[contains(text(), \"%s\") and @data-spot-im-class=\"message-text\"]";
//    protected final static String COMMENT_LOCATOR_BY_ID = "//div[@data-message-id = ''{0}'']";
//    protected final static String COMMENT_DEPTH = "data-message-depth";
//    protected final static By COMMENTER_BADGE = By.xpath("//span[@data-spot-im-class='user-badge']");
//    protected final static By UP_VOTE = By.cssSelector("div[data-spot-im-class='animated-vote-up']");
//    protected final static By DOWN_VOTE = By.xpath("//div[@data-spot-im-class='animated-vote-down']");
//    protected final static By LOGIN_MODAL = By.className("login-selector-modal");
//    protected final static By PAGE_TITLE = By.xpath("//meta[@property='og:title']");
//    protected final static By CONTEXT_MENU = By.cssSelector("div[data-spot-im-class=\"context-menu\"]:nth-of-type(1)");
//    protected final static By COMMENT_EDIT = By.cssSelector("span[data-spot-im-class='context-menu-item-edit']");
//    protected final static By COMMENT_REJECT = By.cssSelector("span[data-spot-im-class='context-menu-item-reject']");
//    protected final static By COMMENT_DELETE = By.cssSelector("span[data-spot-im-class='context-menu-item-delete']");
//    protected final static By COMMENT_ANONYMIZE = By.cssSelector("span[data-spot-im-class='context-menu-item-anonymize']");
//    protected final static By COMMENT_UPDATE = By.xpath("*//button[@data-spot-im-class='rich-editor-update-button']");
//    protected final static By COMMENT_CANCEL = By.xpath("*//button[@data-spot-im-class='rich-editor-cancel-button']");
//    protected final static By EMAIL_CONNECT = By.className("email");
//    protected final static By EMAIL_INPUT = By.cssSelector("div.text-field.large");
//    protected final static By PASSWORD_INPUT = By.className("password-input");
//    protected final static By LOGIN_BUTTON = By.className("button-action-regular");
//    protected final static By USERNAME_INPUT = By.className("add-username-field");
//    protected final static By LOGIN_MODAL_V2 = By.cssSelector("div[data-testid=\"registration-modal\"]");
//    protected final static By EMAIL_INPUT_V2 = By.cssSelector("input[name='email']");
//    protected final static By USERNAME_INPUT_V2 = By.cssSelector("input[data-testid=\"input-username\"]");
//    protected final static By PASSWORD_INPUT_V2 = By.cssSelector("input[data-testid=\"input-password\"]");
//    protected final static By LOGIN_BUTTON_V2 = By.cssSelector("input[data-testid=\"big-button\"]");
//    public final static By SHOW_MORE_COMMENTS = By.cssSelector("div[data-spot-im-class='load-more-messages']");
//    protected final static By COMMENTS_HEADER = By.xpath("//span[@data-spot-im-class='header-text']/span");
//    protected final static By SORT_BY_BEST = By.cssSelector("div[data-spmark=\"best\"]");
//    protected final static By SORT_BY_NEWEST = By.cssSelector("div[data-spmark=\"newest\"]");
//    protected final static By SORT_BY_OLDEST = By.cssSelector("div[data-spmark=\"oldest\"]");
//    protected final static By REPLY_BUTTON = By.cssSelector("span[data-spot-im-class='message-reply']");
//    protected final static By SHARE_BUTTON = By.cssSelector("span[data-spot-im-class='message-share']");
//    protected final static By APPROVE_BUTTON = By.cssSelector("button.button.primary");
//    protected final static By CANCEL_BUTTON = By.cssSelector("button.button.secondary");
//    protected final static By SPOT_IM_LINK1 = By.cssSelector("a[href=\"https://www.spot.im\"]");
//    protected final static By SPOT_IM_LINK2 = By.cssSelector("a.sppre_modal-link-text.sppre_spot-im");
//    protected final static By SPOT_IM_PRIVACY_LINK = By.cssSelector("a[href^=\"https://www.spot.im/privacy\"]");
//    protected final static By COMMUNITY_GUIDLINES_LINK = By.id("community-guidelines");
//    protected final static By ARTICLE_LINK_PROFILE = By.className("activity-item-link");
//    protected final static By FLAG_REPORT = By.cssSelector("svg[class^=\"indexmsn__ReportFlag\"]");
//    protected final static By MSN_EMAIL_INPUT = By.id("i0116");
//    protected final static By MSN_PASSWORD_INPUT = By.id("i0118");
//    protected final static By MSN_BUTTON = By.id("idSIButton9");
//    protected final static By MSN_PROFILE = By.id("loginHeader");
//    protected final static By MSN_OPTION = By.className("microsoft");
//    protected final static By POST_SIGN_UP = By.cssSelector("div.sppre_add-username.sppre_expanded");
//    protected final static By POST_INPUT = By.cssSelector("div[class='sppre_text-field sppre_regular']>input");
//    protected final static By POST_PASSWORD = By.cssSelector("div[class='sppre_text-field sppre_password-input sppre_regular'] > input");
//    protected final static By GREEN_BUTTON = By.className("sppre_button-green-medium");
//    protected final static String COMMENT_ID_ATTR = "data-message-id";
//    protected final static By JOIN_BUTTON = By.cssSelector("a[data-testid='chevronButton']");
//    protected final static By SIGN_UP_BUTTON = By.className("button-action-regular");
//    protected final static By SIGN_UP_TAB = By.className("nav-item");
//    protected final static String COMMENT_DELETED_BY_ID = "//div[@data-message-id = ''{0}'']//*[@class=''sppre_is-deleted'']";
//    protected final static String REPORTED_PLACEHOLDER = "This message was reported.";
//    protected final static By REC_MESSAGE_SECTION = By.cssSelector("div[data-spmark=\"message-text\"]");
//    protected final static By USER_BADGE = By.cssSelector("span[data-spot-im-class='user-badge']");
//    protected final static By FACE_LIST = By.cssSelector("div[data-spot-im-class='faces-list']");
//    protected final static By SHOW_MORE = By.cssSelector("span[data-spot-im-class=\"see-more\"]");
//    protected final static By PHOTO_ICON_BUTTON = By.cssSelector("div[data-spot-im-class=\"rich-editor-upload-image-button\"]");
//    protected final static By STICKY = By.className("spot-im-sticky");
//    protected final static By REPORT_MESSAGE = By.cssSelector("span[data-spot-im-class='message-report']");
//    protected final static By REGISTRATION_BUTTONS = By.className("sppre_registration-buttons");
//    protected final static By TIMESTAMP = By.className("spcv_posted-at");
//
//
//    @FindBy(css = "div[data-spot-im-class='conversation-header']")
//    @CacheLookup
//    WebElement spotImHeaderCss;
//
//    @FindBy(id = "trc_header_64636")
//    @CacheLookup
//    WebElement foxNewsSponsored;
//
//    //    @FindBy(xpath = "//*[@class=\"spcv_sort-by\"]/span")
//    @FindBy(xpath = "//*[@data-spot-im-class=\"sort-menu\"]/span[2]/span")
//    //*[@data-spot-im-class="sort-menu"]/a/span
//    @CacheLookup
//    WebElement sortByMenu;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"sort-menu\"]/a/span")
//    @CacheLookup
//    WebElement sortByMenuRedesign;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"sort-menu\"]/span[1]")
//    @CacheLookup
//    WebElement sortByTitle;
//
//    @FindBy(xpath = "//*[@class=\"spcv_sort-menu\"]/span[1]\n")
//    @CacheLookup
//    WebElement sortByTitleRedesign;
//
//    @FindBy(xpath = "//*[@id=\"top\"]/div[6]/div/div[3]/a[1]")
//    @CacheLookup
//    WebElement logInTimesOfLondon;
//
//    @FindBy(xpath = "//input[@id=\"1-email\"]")
//    @CacheLookup
//    WebElement emailTimesOfLondon;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"load-more-messages\"]")
//    @CacheLookup
//    WebElement showMoreMessageFrame;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"load-more-messages\"]")
//    @CacheLookup
//    WebElement showMoreMessageTitle;
//
//    @FindBy(xpath = "//input[@name=\"password\"]")
//    @CacheLookup
//    WebElement passwordTimesOfLondon;
//
//    @FindBy(xpath = "//button[@name=\"submit\"]")
//    @CacheLookup
//    WebElement confirmLogInTimesOfLondon;
//
//    @FindBy(xpath = "//*[@data-testid=\"close-button\"]")
//    @CacheLookup
//    WebElement createYourProfileCloseButton;
//
//    @FindBy(xpath = "//*[@data-testid=\"username-input\"]")
//    @CacheLookup
//    WebElement createYourProfileUsernameInput;
//
//    @FindBy(xpath = "//*[@data-testid=\"close-button\"]")
//    @CacheLookup
//    WebElement createYourProfileNextButton;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"message-timestamp\"]")
//    @CacheLookup
//    WebElement commentsTimeStamp;
//
//    @FindBy(xpath = "class=\"spcv_droplist\"")
//    @CacheLookup
//    WebElement sortByList;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"rich-editor-input\"]/div/input")
//    @CacheLookup
//    WebElement nickName;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"rich-editor-input\"]/textarea")
//    @CacheLookup
//    WebElement nameIE;
//
//    //    @FindBy(xpath = "//*[@data-spot-im-class=\"rich-editor-wrapper\"]/div[2]/div/div[2]/div[1]/div[1]/p")
//    @FindBy(className = "ql-editor")
//    @CacheLookup
//    WebElement addCommentGuest;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"rich-editor-input\"]")
//    @CacheLookup
//    WebElement clickCommentUser;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"rich-editor-input\"]/div/div[1]/div[1]")
//    @CacheLookup
//    WebElement addCommentUser;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"rich-editor-panel\"]/div/span/div[2]/button")
//    @CacheLookup
//    WebElement gifButton;
//
//    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/div[2]/div[2]/div[2]/div/span/div[1]")
//    @CacheLookup
//    WebElement photoButton;
//
//    @FindBy(xpath = "//input[@class=\"spcv_file-input\"]")
//    @CacheLookup
//    WebElement photoUpload;
//
//    @FindBy(xpath = "//*[@class=\"spcv_entity\"]/a")
//    @CacheLookup
//    WebElement picUpload;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"rich-editor-panel\"]/div/div/button")
//    @CacheLookup
//    WebElement postButton;
//
//    @FindBy(xpath = "//*[@class=\"spcv_entity-area\"]/div[2]/span")
//    @CacheLookup
//    WebElement removePicButton;
//
//    @FindBy(xpath = "//*[@class='spcv_login-button']")
//    @CacheLookup
//    WebElement logInHomePageButton;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"registration-buttons\"]/span/span")
//    @CacheLookup
//    WebElement logInHomePageTitle;
//
//    @FindBy(xpath = "//*[@data-testid='input-email']")
//    @CacheLookup
//    WebElement userEmailForm;
//
//    @FindBy(xpath = "//*[@data-testid='input-password']")
//    @CacheLookup
//    WebElement userPasswordForm;
//
//    @FindBy(xpath = "//*[@data-testid='input-username']")
//    @CacheLookup
//    WebElement userNameForm;
//
//    @FindBy(xpath = "//*[@data-testid='big-button']")
//    @CacheLookup
//    WebElement loginFormButton;
//
//    @FindBy(xpath = "//*[@data-testid='chevronButton']")
//    @CacheLookup
//    WebElement joinButton;
//
//    @FindBy(xpath = "//*[@data-spot-im-class='handler']/span")
//    @CacheLookup
//    WebElement userNameAfterLogin;
//
//    @FindBy(xpath = "//*[@data-testid=\"button\"]")
//    @CacheLookup
//    WebElement forgotPassword;
//
//    @FindBy(xpath = "//*[@data-testid=\"registration-modal\"]")
//    @CacheLookup
//    WebElement integrationBox;
//
//    @FindBy(xpath = "//*[@class=\"sc-cLQEGU gRGlKa\"]")
//    @CacheLookup
//    WebElement forgotPasswordSuccess;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"handler\"]")
//    @CacheLookup
//    WebElement handlerAfterLogin;
//
//    @FindBy(xpath = "//*[@class='styles__Header-sc-1wa2pv7-2 eYhViq']")
//    @CacheLookup
//    WebElement headerFromProfileForm;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"rich-editor-input\"]/div/div[1]/div[1]")
//    @CacheLookup
//    WebElement commentPlaceholder;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"message-view\"]/div/div/div/div[2]/div[1]")
//    @CacheLookup
//    WebElement allOnlyComments;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"message-view\"]/div/div/div/div[2]/div[2]")
//    @CacheLookup
//    WebElement allOnlyPicGifComments;
//
//    @FindBy(xpath = "//*[@class=\"spcv_title\"]")
//    @CacheLookup
//    WebElement createYourProfileTitle;
//
//    @FindBy(xpath = "//*[@class=\"spcv_droplist-container\"]/ul/li")
//    @CacheLookup
//    WebElement suggestionNameList;
//
//    @FindBy(xpath = "//input[@data-testid=\"username-input\"]")
//    @CacheLookup
//    WebElement userNameSuggestionInput;
//
//    @FindBy(xpath = "//input[@data-testid=\"email-input\"]")
//    @CacheLookup
//    WebElement createProfileEmailInput;
//
//    @FindBy(xpath = "//*[@id=\"spcv_conversation\"]/div/div[2]/ul/li[2]/div[2]/article/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]")
//    @CacheLookup
//    WebElement replyToPlaceholder;
//
//    @FindBy(xpath = "//*[@data-spot-im-class='header-text']")
//    @CacheLookup
//    WebElement spotConversationHeader;
//
//    @FindBy(xpath = "//*[@class=\"close\"]")
//    @CacheLookup
//    WebElement foxClosePopUp;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"conversation-root\"]")
//    @CacheLookup
//    WebElement conversationRoot;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"message-username\"]\n")
//    @CacheLookup
//    WebElement userNameTitle;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"message-text\"]")
//    @CacheLookup
//    WebElement allComments;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"message-reply\"]")
//    @CacheLookup
//    WebElement messageReply;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"message-share\"]")
//    @CacheLookup
//    WebElement messageShare;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"context-menu-share-post\"]/span")
//    @CacheLookup
//    WebElement messageShareRedesign;
//
//    @FindBy(xpath = "//*[@class=\"spcv_indicator\"]")
//    @CacheLookup
//    WebElement bellIndicator;
//
//    @FindBy(id = "spcv_conversation")
//    @CacheLookup
//    WebElement spotIdElement;
//
//    @FindBy(id = "spotim-specific")
//    @CacheLookup
//    WebElement spotIdRedesignElement;
//
//    @FindBy(xpath = "//*[@data-spot-im-class=\"user-badge\"]/span")
//    @CacheLookup
//    WebElement userBadge;
//
//    @FindBy(xpath = "//*[@data-post-url]")
//    @CacheLookup
//    WebElement dataPostUrl;
//
//
//    public ConversationPage() {
//        super();
//        PageFactory.initElements(driver.get(), this);
//    }
//
//    public By getCommentSectionSelector() {
//        return COMMENTS_SECTION;
//    }
//
//
//    public static By getTopMessageLocator() {
//        return TOP_MESSAGE;
//    }
//
//    public By getMessageCountLocator() {
//        return MESSAGE_COUNT;
//    }
//
//    public By getCommentEditorLocator() {
//        return SAY_CONTROL;
//    }
//
//    protected By getUpVoteCountSelector() {
//        return LIKES_COUNT;
//    }
//
//    protected By getCommentUserNameSelector() {
//        return COMMENT_USERNAME;
//    }
//
//    public By getUpVoteSelector() {
//        return UP_VOTE;
//    }
//
//    public static By getDownVoteSelector() {
//        return DOWN_VOTE;
//    }
//
//    protected By getNotificationBellLocator() {
//        return NOTIFICATION_BELL;
//    }
//
//    public WebElement getCommentSelector() {
//        return addCommentGuest;
//    }
//
//    public By enterCommentSelector() {
//        return COMMENTS_EDITOR;
//    }
//
//
//    public void clickOnLogInHomePageButton() {
//        Log.info("Clicking on Login Home page button");
//        try {
//            logInHomePageButton.click();
//        } catch (Exception e) {
//            Log.info("Error clicking on login Home page button");
//        }
//    }
//
//    public void clickOnShowMoreMessageButton() {
//        Log.info("Clicking on show more message button");
//        try {
//            logInHomePageButton.click();
//        } catch (Exception e) {
//            Log.info("Error clicking on show more message button");
//        }
//    }
//
//
//
//    public void clickOnHandlerAfterLogin() {
//        Log.info("Clicking on handler After Login button");
//        try {
//            handlerAfterLogin.click();
//        } catch (Exception e) {
//            Log.info("Error clicking on handler After Login button");
//        }
//    }
//
//
//
//    public void clickOnLoginButton() {
//        Log.info("Clicking on Login button");
//        try {
//            loginFormButton.click();
//        } catch (Exception e) {
//            Log.info("Error clicking on login button");
//        }
//    }
//
//    public void clickOnNickName() {
//        Log.info("Clicking on Nick Name");
//        try {
//            nickName.click();
//        } catch (Exception e) {
//            Log.info("Error clicking on nick name");
//        }
//    }
//
//    public void clickOnCreateYourProfileCloseButton() {
//        Log.info("Clicking on create your profile close Button");
//        try {
//            createYourProfileCloseButton.click();
//        } catch (Exception e) {
//            Log.info("Error clicking on create your profile close Button");
//        }
//    }
//
//    public void clickOnGifButton() {
//        Log.info("Clicking on GIF Button");
//        try {
//            gifButton.click();
//        } catch (Exception e) {
//            Log.info("Error clicking on GIF Button");
//        }
//    }
//
//    public void clickConfirmLogInTTL() {
//        Log.info("Clicking on submit log in - times of london ");
//        try {
//            confirmLogInTimesOfLondon.click();
//        } catch (Exception e) {
//            Log.info("Error Clicking on submit log in - times of london");
//        }
//    }
//
//    public void insertUserEmail(String userEmail) {
//        Log.info("Entering user email " + userEmail);
//        try {
//            userEmailForm.sendKeys(userEmail);
//        } catch (Exception e) {
//            Log.info("Error Entering user email");
//        }
//    }
//
//    public void insertUserEmailTTL(String userEmail) {
//        Log.info("Entering user email " + userEmail + " Times of London");
//        try {
//            emailTimesOfLondon.sendKeys(userEmail);
//        } catch (Exception e) {
//            Log.info("Error Entering user email - Times of London");
//        }
//    }
//
//    public void insertUserPasswordTTL(String userPassword) {
//        Log.info("Entering user password " + userPassword + " Times of London");
//        try {
//            passwordTimesOfLondon.sendKeys(userPassword);
//        } catch (Exception e) {
//            Log.info("Error Entering user password - Times of London");
//        }
//    }
//
//
//    public void insertUserPassword(String userPassword) {
//        Log.info("Entering user password " + userPassword);
//        try {
//            userPasswordForm.sendKeys(userPassword);
//        } catch (Exception e) {
//            Log.info("Error Entering user password");
//        }
//    }
//
//    public void enterNickName(String myNickName) {
//        Log.info("Entering nick name " + myNickName);
//        try {
//            nickName.sendKeys(myNickName);
//        } catch (Exception e) {
//            Log.info("Error Entering first name");
//        }
//    }
//
//    public void sendPhoto(String path) {
//        Log.info("Entering photo");
//        try {
//            photoUpload.sendKeys(path);
//        } catch (Exception e) {
//            Log.info("Error Entering photo");
//        }
//    }
//
//    public void createYourProfileUserNameInput(String userName) {
//        Log.info("Insert user name photo - create you profile");
//        try {
//            createYourProfileUsernameInput.sendKeys(userName);
//        } catch (Exception e) {
//            Log.info("Error Insert user name photo - create you profile");
//        }
//    }
//
//    public void createYourProfileUserEmailInput(String userName) {
//        Log.info("Insert user email - create you profile");
//        try {
//            createYourProfileUsernameInput.sendKeys(userName);
//        } catch (Exception e) {
//            Log.info("Error Insert email - create you profile");
//        }
//    }
//
//
//
//    public String isLightOrDarkMode() {
//        String darkOrLight = null;
//        try {
//            Log.info("Clicking on Comment");
//            String css = conversationRoot.getAttribute("class");
//            if (css.contains("light")) {
//                Log.info("we are in light mode");
//                darkOrLight = "light";
//            } else if (css.contains("dark")) {
//                Log.info("we are in dark mode");
//                darkOrLight = "dark";
//            }
//        } catch (Exception e) {
//            Log.info("Error checking if dark or light mode");
//        }
//        return darkOrLight;
//    }
//
//    public void clickOnPost() {
//        Log.info("Clicking on Post");
//        try {
//            postButton.click();
//        } catch (Exception e) {
//            Log.info("Error clicking on Post");
//        }
//    }
//
//    public void clickOnRemovePic() {
//        Log.info("Clicking on Remove pic");
//        try {
//            removePicButton.click();
//        } catch (Exception e) {
//            Log.info("Error clicking on Remove pic");
//        }
//    }
//
//    public void enterCommentIE(String myComment) throws InterruptedException {
//        Log.info("Entering Comment");
//        try {
//            driver.get().findElement(SAY_CONTROL).sendKeys(myComment);
//        } catch (Exception e) {
//            Log.info("Error Entering Comment");
//        }
//    }
//
//    public void enterComment(String userType, String myComment) throws InterruptedException {
//        Log.info("Entering Comment");
//        try {
//            if (AutomationSystemProperties.BROWSER_TYPE.equals("IE")) {
//                driver.get().findElement(SAY_CONTROL).sendKeys(myComment);
//            } else {
//
//                if (userType.equals("Guest")) {
//                    addCommentGuest.sendKeys(myComment);
//                } else if (userType.equals("User")) {
//                    addCommentUser.sendKeys(myComment);
//                }
//            }
//        } catch (Exception e) {
//            Log.info("Error Entering Comment");
//        }
//    }
//
//
//    public void enterCommentFox(String myComment) throws InterruptedException {
//        Log.info("Entering Comment");
//        try {
//            addCommentUser.sendKeys(myComment);
//        } catch (Exception e) {
//            Log.info("Error Entering Comment");
//        }
//    }
//
//
//
//    public String checkAllCommentsCssFontAlignment() {
//        String allCommentsFontAlign = null;
//        try {
//            allCommentsFontAlign = allComments.getCssValue("text-align");
//            Log.info("Comments font alignment from css is: " + allCommentsFontAlign);
//        } catch (Exception e) {
//            Log.info("Error while checking Comments font alignment");
//        }
//        return allCommentsFontAlign;
//    }
//
//    public String checkReplyCssFontSize() {
//        String replySize = null;
//        try {
//            replySize = messageReply.getCssValue("font-size");
//            Log.info("Reply font size from css is: " + replySize);
//        } catch (Exception e) {
//            Log.info("Error while checking Reply font size");
//        }
//        return replySize;
//    }
//
//    public String checkReplyCssFontColor() {
//        String replyColor = null;
//        try {
//            replyColor = messageReply.getCssValue("color");
//            Log.info("Reply font color from css is: " + replyColor);
//        } catch (Exception e) {
//            Log.info("Error while checking Reply font color");
//        }
//        return replyColor;
//    }
//
//    public String checkReplyCssFontType() {
//        String replyType = null;
//        try {
//            replyType = messageReply.getCssValue("font-family");
//            Log.info("Reply font type from css is: " + replyType);
//        } catch (Exception e) {
//            Log.info("Error while checking Reply font type");
//        }
//        return replyType;
//    }
//
//    public String checkReplyCssFontAlignment() {
//        String replyFontAlign = null;
//        try {
//            replyFontAlign = messageReply.getCssValue("text-align");
//            Log.info("Reply font alignment from css is: " + replyFontAlign);
//        } catch (Exception e) {
//            Log.info("Error while checking Reply font alignment");
//        }
//        return replyFontAlign;
//    }
//
//    public String checkShareCssFontSize() {
//        String shareSize = null;
//        try {
//            shareSize = messageShare.getCssValue("font-size");
//            Log.info("Share font size from css is: " + shareSize);
//        } catch (Exception e) {
//            Log.info("Error while checking Share font size");
//        }
//        return shareSize;
//    }
//
//    public String checkShareRedesignCssFontSize() {
//        String shareSize = null;
//        try {
//            shareSize = messageShareRedesign.getCssValue("font-size");
//            Log.info("Share font size from css is: " + shareSize);
//        } catch (Exception e) {
//            Log.info("Error while checking Share font size");
//        }
//        return shareSize;
//    }
//
//    public String checkShareRedesignCssFontColor() {
//        String shareColor = null;
//        try {
//            shareColor = messageShareRedesign.getCssValue("color");
//            Log.info("Share font color from css is: " + shareColor);
//        } catch (Exception e) {
//            Log.info("Error while checking Share font color");
//        }
//        return shareColor;
//    }
//
//    public String checkShareRedesignCssFontType() {
//        String shareType = null;
//        try {
//            shareType = messageShareRedesign.getCssValue("font-family");
//            Log.info("Share font type from css is: " + shareType);
//        } catch (Exception e) {
//            Log.info("Error while checking Share font type");
//        }
//        return shareType;
//    }
//
//    public String checkShareRedesignCssFontAlignment() {
//        String shareFontAlign = null;
//        try {
//            shareFontAlign = messageShareRedesign.getCssValue("text-align");
//            Log.info("Share font alignment from css is: " + shareFontAlign);
//        } catch (Exception e) {
//            Log.info("Error while checking Share font alignment");
//        }
//        return shareFontAlign;
//    }
//
//    public String checkShareCssFontColor() {
//        String shareColor = null;
//        try {
//            shareColor = messageShare.getCssValue("color");
//            Log.info("Share font color from css is: " + shareColor);
//        } catch (Exception e) {
//            Log.info("Error while checking Share font color");
//        }
//        return shareColor;
//    }
//
//    public String checkShareCssFontType() {
//        String shareType = null;
//        try {
//            shareType = messageShare.getCssValue("font-family");
//            Log.info("Share font type from css is: " + shareType);
//        } catch (Exception e) {
//            Log.info("Error while checking Share font type");
//        }
//        return shareType;
//    }
//
//    public String checkShareCssFontAlignment() {
//        String shareFontAlign = null;
//        try {
//            shareFontAlign = messageShare.getCssValue("text-align");
//            Log.info("Share font alignment from css is: " + shareFontAlign);
//        } catch (Exception e) {
//            Log.info("Error while checking Share font alignment");
//        }
//        return shareFontAlign;
//    }
//
//    public String checkSortByTitleCssFontSize() {
//        String sortByTitleSize = null;
//        try {
//            sortByTitleSize = sortByTitle.getCssValue("font-size");
//            Log.info("Sort by title font size from css is: " + sortByTitleSize);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by title font size");
//        }
//        return sortByTitleSize;
//    }
//
//    public String checkSortByTitleCssFontColor() {
//        String sortByTitleColor = null;
//        try {
//            sortByTitleColor = sortByTitle.getCssValue("color");
//            Log.info("Sort by title font color from css is: " + sortByTitleColor);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by title font color");
//        }
//        return sortByTitleColor;
//    }
//
//    public String checkSortByTitleCssFontType() {
//        String sortByTitleType = null;
//        try {
//            sortByTitleType = sortByTitle.getCssValue("font-family");
//            Log.info("Sort by title font type from css is: " + sortByTitleType);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by title font type");
//        }
//        return sortByTitleType;
//    }
//
//    public String checkSortByTitleCssFontAlignment() {
//        String sortByTitleFontAlign = null;
//        try {
//            sortByTitleFontAlign = sortByTitle.getCssValue("text-align");
//            Log.info("Sort by title font alignment from css is: " + sortByTitleFontAlign);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by title font alignment");
//        }
//        return sortByTitleFontAlign;
//    }
//
//    public String checkSortByTitleRedesignCssFontSize() {
//        String sortByTitleSize = null;
//        try {
//            sortByTitleSize = sortByTitleRedesign.getCssValue("font-size");
//            Log.info("Sort by title font size from css is: " + sortByTitleSize);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by title font size");
//        }
//        return sortByTitleSize;
//    }
//
//    public String checkSortByTitleRedesignCssFontColor() {
//        String sortByTitleColor = null;
//        try {
//            sortByTitleColor = sortByTitleRedesign.getCssValue("color");
//            Log.info("Sort by title font color from css is: " + sortByTitleColor);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by title font color");
//        }
//        return sortByTitleColor;
//    }
//
//    public String checkSortByTitleRedesignCssFontType() {
//        String sortByTitleType = null;
//        try {
//            sortByTitleType = sortByTitleRedesign.getCssValue("font-family");
//            Log.info("Sort by title font type from css is: " + sortByTitleType);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by title font type");
//        }
//        return sortByTitleType;
//    }
//
//    public String checkSortByTitleRedesignCssFontAlignment() {
//        String sortByTitleFontAlign = null;
//        try {
//            sortByTitleFontAlign = sortByTitleRedesign.getCssValue("text-align");
//            Log.info("Sort by title font alignment from css is: " + sortByTitleFontAlign);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by title font alignment");
//        }
//        return sortByTitleFontAlign;
//    }
//
//    public String checkSortByMenuCssFontSize() {
//        String sortByMenuSize = null;
//        try {
//            sortByMenuSize = sortByMenu.getCssValue("font-size");
//            Log.info("Sort by Menu font size from css is: " + sortByMenuSize);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by Menu font size");
//        }
//        return sortByMenuSize;
//    }
//
//    public String checkSortByMenuCssFontColor() {
//        String sortByMenuColor = null;
//        try {
//            sortByMenuColor = sortByMenu.getCssValue("color");
//            Log.info("Sort by Menu font color from css is: " + sortByMenuColor);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by Menu font color");
//        }
//        return sortByMenuColor;
//    }
//
//    public String checkSortByMenuCssFontType() {
//        String sortByMenuType = null;
//        try {
//            sortByMenuType = sortByMenu.getCssValue("font-family");
//            Log.info("Sort by Menu font type from css is: " + sortByMenuType);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by Menu font type");
//        }
//        return sortByMenuType;
//    }
//
//    public String checkSortByMenuCssFontAlignment() {
//        String sortByMenuFontAlign = null;
//        try {
//            sortByMenuFontAlign = sortByMenu.getCssValue("text-align");
//            Log.info("Sort by Menu font alignment from css is: " + sortByMenuFontAlign);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by Menu font alignment");
//        }
//        return sortByMenuFontAlign;
//    }
//
//    public String checkSortByMenuRedesignCssFontSize() {
//        String sortByMenuSize = null;
//        try {
//            sortByMenuSize = sortByMenuRedesign.getCssValue("font-size");
//            Log.info("Sort by Menu font size from css is: " + sortByMenuSize);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by Menu font size");
//        }
//        return sortByMenuSize;
//    }
//
//    public String checkSortByMenuRedesignCssFontColor() {
//        String sortByMenuColor = null;
//        try {
//            sortByMenuColor = sortByMenuRedesign.getCssValue("color");
//            Log.info("Sort by Menu font color from css is: " + sortByMenuColor);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by Menu font color");
//        }
//        return sortByMenuColor;
//    }
//
//    public String checkSortByMenuRedesignCssFontType() {
//        String sortByMenuType = null;
//        try {
//            sortByMenuType = sortByMenuRedesign.getCssValue("font-family");
//            Log.info("Sort by Menu font type from css is: " + sortByMenuType);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by Menu font type");
//        }
//        return sortByMenuType;
//    }
//
//    public String checkSortByMenuRedesignCssFontAlignment() {
//        String sortByMenuFontAlign = null;
//        try {
//            sortByMenuFontAlign = sortByMenuRedesign.getCssValue("text-align");
//            Log.info("Sort by Menu font alignment from css is: " + sortByMenuFontAlign);
//        } catch (Exception e) {
//            Log.info("Error while checking Sort by Menu font alignment");
//        }
//        return sortByMenuFontAlign;
//    }
//
//    public String checkUserLogInHomePageTitleCssFontSize() {
//        String userLogInHomePageTitleSize = null;
//        try {
//            userLogInHomePageTitleSize = logInHomePageTitle.getCssValue("font-size");
//            Log.info("user LogIn HomePage Title font size from css is: " + userLogInHomePageTitleSize);
//        } catch (Exception e) {
//            Log.info("Error while checking user LogIn HomePage Title font size");
//        }
//        return userLogInHomePageTitleSize;
//    }
//
//    public String checkUserLogInHomePageTitleCssFontColor() {
//        String userLogInHomePageTitleColor = null;
//        try {
//            userLogInHomePageTitleColor = logInHomePageTitle.getCssValue("color");
//            Log.info("user LogIn HomePage Title font color from css is: " + userLogInHomePageTitleColor);
//        } catch (Exception e) {
//            Log.info("Error while checking user LogIn HomePage Title font color");
//        }
//        return userLogInHomePageTitleColor;
//    }
//
//    public String checkUserLogInHomePageTitleCssFontType() {
//        String userLogInHomePageTitleType = null;
//        try {
//            userLogInHomePageTitleType = logInHomePageTitle.getCssValue("font-family");
//            Log.info("user LogIn HomePage Title font type from css is: " + userLogInHomePageTitleType);
//        } catch (Exception e) {
//            Log.info("Error while checking user LogIn HomePage Title font type");
//        }
//        return userLogInHomePageTitleType;
//    }
//
//    public String checkUserLogInHomePageTitleCssFontAlignment() {
//        String userLogInHomePageTitleAlign = null;
//        try {
//            userLogInHomePageTitleAlign = logInHomePageTitle.getCssValue("text-align");
//            Log.info("user LogIn HomePage Title font alignment from css is: " + userLogInHomePageTitleAlign);
//        } catch (Exception e) {
//            Log.info("Error while checking user LogIn HomePage Title font alignment");
//        }
//        return userLogInHomePageTitleAlign;
//    }
//
//    public String checkTimeStampCssFontSize() {
//        String timeStampSize = null;
//        try {
//            timeStampSize = commentsTimeStamp.getCssValue("font-size");
//            Log.info("time Stamp font size from css is: " + timeStampSize);
//        } catch (Exception e) {
//            Log.info("Error while checking time Stamp font size");
//        }
//        return timeStampSize;
//    }
//
//    public String checkTimeStampCssFontColor() {
//        String timeStampColor = null;
//        try {
//            timeStampColor = commentsTimeStamp.getCssValue("color");
//            Log.info("time Stamp font color from css is: " + timeStampColor);
//        } catch (Exception e) {
//            Log.info("Error while checking time Stamp font color");
//        }
//        return timeStampColor;
//    }
//
//    public String checkTimeStampCssFontType() {
//        String timeStampType = null;
//        try {
//            timeStampType = commentsTimeStamp.getCssValue("font-family");
//            Log.info("time Stamp font type from css is: " + timeStampType);
//        } catch (Exception e) {
//            Log.info("Error while checking time Stamp font type");
//        }
//        return timeStampType;
//    }
//
//    public String checkTimeStampCssFontAlignment() {
//        String timeStampAlign = null;
//        try {
//            timeStampAlign = commentsTimeStamp.getCssValue("text-align");
//            Log.info("time Stamp font alignment from css is: " + timeStampAlign);
//        } catch (Exception e) {
//            Log.info("Error while checking time Stamp alignment");
//        }
//        return timeStampAlign;
//    }
//
//    public String checkShowMoreCommentFrameCssFontSize() {
//        String showMoreCommentFrameSize = null;
//        try {
//            showMoreCommentFrameSize = showMoreMessageFrame.getCssValue("font-size");
//            Log.info("Show More Comment Frame font size from css is: " + showMoreCommentFrameSize);
//        } catch (Exception e) {
//            Log.info("Error while checking Show More Comment Frame font size");
//        }
//        return showMoreCommentFrameSize;
//    }
//
//    public String checkShowMoreCommentFrameCssFontColor() {
//        String showMoreCommentFrameColor = null;
//        try {
//            showMoreCommentFrameColor = showMoreMessageFrame.getCssValue("color");
//            Log.info("Show More Comment Frame font color from css is: " + showMoreCommentFrameColor);
//        } catch (Exception e) {
//            Log.info("Error while checking Show More Comment Frame font color");
//        }
//        return showMoreCommentFrameColor;
//    }
//
//    public String checkShowMoreCommentFrameCssFontType() {
//        String showMoreCommentFrameType = null;
//        try {
//            showMoreCommentFrameType = showMoreMessageFrame.getCssValue("font-family");
//            Log.info("Show More Comment Frame font type from css is: " + showMoreCommentFrameType);
//        } catch (Exception e) {
//            Log.info("Error while checking Show More Comment Frame font type");
//        }
//        return showMoreCommentFrameType;
//    }
//
//    public String checkShowMoreCommentFrameCssFontAlignment() {
//        String showMoreCommentFrameAlign = null;
//        try {
//            showMoreCommentFrameAlign = showMoreMessageFrame.getCssValue("text-align");
//            Log.info("Show More Comment Frame font alignment from css is: " + showMoreCommentFrameAlign);
//        } catch (Exception e) {
//            Log.info("Error while checking Show More Comment Frame alignment");
//        }
//        return showMoreCommentFrameAlign;
//    }
//
//    public String checkShowMoreCommentTitleCssFontSize() {
//        String showMoreCommentTitleSize = null;
//        try {
//            showMoreCommentTitleSize = showMoreMessageTitle.getCssValue("font-size");
//            Log.info("Show More Comment Title font size from css is: " + showMoreCommentTitleSize);
//        } catch (Exception e) {
//            Log.info("Error while checking Show More Comment Title font size");
//        }
//        return showMoreCommentTitleSize;
//    }
//
//    public String checkShowMoreCommentTitleCssFontColor() {
//        String showMoreCommentTitleColor = null;
//        try {
//            showMoreCommentTitleColor = showMoreMessageTitle.getCssValue("color");
//            Log.info("Show More Comment Title font color from css is: " + showMoreCommentTitleColor);
//        } catch (Exception e) {
//            Log.info("Error while checking Show More Comment Title font color");
//        }
//        return showMoreCommentTitleColor;
//    }
//
//    public String checkShowMoreCommentTitleCssFontType() {
//        String showMoreCommentTitleType = null;
//        try {
//            showMoreCommentTitleType = showMoreMessageTitle.getCssValue("font-family");
//            Log.info("Show More Comment Title font type from css is: " + showMoreCommentTitleType);
//        } catch (Exception e) {
//            Log.info("Error while checking Show More Comment Title font type");
//        }
//        return showMoreCommentTitleType;
//    }
//
//    public String checkShowMoreCommentTitleCssFontAlignment() {
//        String showMoreCommentTitleAlign = null;
//        try {
//            showMoreCommentTitleAlign = showMoreMessageTitle.getCssValue("text-align");
//            Log.info("Show More Comment Title font alignment from css is: " + showMoreCommentTitleAlign);
//        } catch (Exception e) {
//            Log.info("Error while checking Show More Comment Title alignment");
//        }
//        return showMoreCommentTitleAlign;
//    }
//
//    public String checkUserBadgeCssFontSize() {
//        String userBadgeSize = null;
//        try {
//            userBadgeSize = userBadge.getCssValue("font-size");
//            Log.info("user Badge font size from css is: " + userBadgeSize);
//        } catch (Exception e) {
//            Log.info("Error while checking user Badge font size");
//        }
//        return userBadgeSize;
//    }
//
//    public String checkUserBadgeCssFontColor() {
//        String userBadgeColor = null;
//        try {
//            userBadgeColor = userBadge.getCssValue("color");
//            Log.info("user Badge font color from css is: " + userBadgeColor);
//        } catch (Exception e) {
//            Log.info("Error while checking user Badge font color");
//        }
//        return userBadgeColor;
//    }
//
//    public String checkUserBadgeCssFontType() {
//        String userBadgeType = null;
//        try {
//            userBadgeType = userBadge.getCssValue("font-family");
//            Log.info("user Badge font type from css is: " + userBadgeType);
//        } catch (Exception e) {
//            Log.info("Error while checking user Badge font type");
//        }
//        return userBadgeType;
//    }
//
//    public String checkUserBadgeCssFontAlignment() {
//        String userBadgeAlign = null;
//        try {
//            userBadgeAlign = userBadge.getCssValue("text-align");
//            Log.info("user Badge alignment from css is: " + userBadgeAlign);
//        } catch (Exception e) {
//            Log.info("Error while checking user Badge alignment");
//        }
//        return userBadgeAlign;
//    }
//
//    public String bellIndicatorSize() {
//        String bellIndicatorSize = null;
//        try {
//            bellIndicatorSize = bellIndicator.getCssValue("height");
//            Log.info("Bell indicator height: " + bellIndicatorSize);
//        } catch (Exception e) {
//            Log.info("Error while checking Bell indicator height");
//        }
//        return bellIndicatorSize;
//    }
//}