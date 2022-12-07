package amazon.page;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.time.Duration;
import java.util.ArrayList;

@Slf4j
public class BasePage {

    private static final Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private static final WebDriver driver = DriverFactory.getDriver();

    private static String parentWindow;

    public static Config getConfig() {
        return config;
    }

    public static String getHOME_PAGE_URL() {
        return HOME_PAGE_URL;
    }

    public static WebDriver getDriver() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void openApp() {
        driver.get(HOME_PAGE_URL);
    }

    public static void closeApp() {
        driver.quit();
    }

//    public void storeParentWindowHandle() {
//        parentWindow = driver.getWindowHandle();
//    }
//
//    public void switchToParentWindow() {
//        driver.switchTo().window(parentWindow);
//    }

    public void switchToChildWindow() {
        log.info(String.format("Switch to child window"));
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(driver.getWindowHandles().size() - 1));
    }


    public void waitForVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }



}
