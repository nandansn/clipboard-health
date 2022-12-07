package amazon.factories;

import amazon.choices.Browser;
import amazon.choices.Host;
import amazon.config.EnvFactory;
import com.typesafe.config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

@Slf4j
public class DriverFactory {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final Host HOST = Host.parse(config.getString("HOST"));
    private static final Browser BROWSER = Browser.parse(config.getString("BROWSER"));

    private DriverFactory() {
        throw new IllegalStateException("Static factory class");
    }

    public static WebDriver getDriver() {
        log.info("Getting driver for host: {}", HOST);
        switch (HOST) {
            case LOCALHOST:
                return getLocalWebDriver();
            case DOCKER_CONTAINER:
                // fall through - same options apply.
            case DOCKER_SELENIUM_GRID:
                return getRemoteWebDriver();
            default:
                throw new IllegalStateException(String.format("%s is not a valid HOST choice. Pick your HOST from %s.", HOST, java.util.Arrays.asList(Host.values())));
        }
    }

    private static WebDriver getLocalWebDriver() {
        log.info("Getting driver for browser: {}", BROWSER);
        switch (BROWSER) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(CapabilitiesFactory.getChromeOptions());
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(CapabilitiesFactory.getFirefoxOptions());
            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case OPERA:
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            default:
                throw new IllegalStateException(String.format("%s is not a valid browser choice. Pick your browser from %s.", BROWSER, java.util.Arrays.asList(BROWSER.values())));
        }
    }

    /** Chrome, firefox and edge; are the only 3 options available under docker.selenium.grid */
    private static WebDriver getRemoteWebDriver() {
        switch (BROWSER) {
            case CHROME:
                // fall - through. Same method for all browsers.
            case FIREFOX:
                // fall - through. Same method for all browsers.
            case EDGE:
                return new RemoteWebDriver(URLFactory.getHostURL(HOST), CapabilitiesFactory.getCapabilities(BROWSER));
            default:
                throw new IllegalStateException(String.format("%s is not a valid browser choice. Pick your browser from %s.", BROWSER, java.util.Arrays.asList(BROWSER.values())));
        }
    }
}
