package enums;

public  enum BrowserEnum {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge");

    private final String browserName;

    BrowserEnum(String browserName)
    {
        this.browserName=browserName;
    }

    public String getBrowserName()
    {
        return browserName;
    }








}
