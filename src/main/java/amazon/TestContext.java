package amazon;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import org.openqa.selenium.WebDriver;

public class TestContext {

    private Config config;
    private final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private WebDriver driver;


    private TestContext() {
        this.config = EnvFactory.getInstance().getConfig();
        this.driver = DriverFactory.getDriver();
    }

    public static TestContext init() {
        return new TestContext();
    }

    public Config getConfig() {
        return config;
    }

    public  String getHomePageUrl() {
        return HOME_PAGE_URL;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
