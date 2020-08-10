package fed.browsers;

public enum BrowserType {
    CHROME, IE, SAFARI, FIREFOX;

    public static BrowserType forName(String name) {
        for (BrowserType type : BrowserType.values()) {
            if (type.toString().equalsIgnoreCase(name)) {
                return type;
            }
        }
        // Defining default browser from code until we learn how to do it form Jenkins
        return BrowserType.CHROME;
        //throw new IllegalArgumentException("BrowserType must be 'IE', 'CHROME', 'FIREFOX' or 'SAFARI'");
    }
}
