package amazon.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElectronicsMenu extends MenuCategory {

    @FindBy(xpath = "//a[contains(text(),'Televisions')]")
    WebElement televisions;


    public static ElectronicsMenu init() {
        return PageFactory.initElements(getDriver(), ElectronicsMenu.class);
    }

    public void clickTelevision() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        waitForVisibilityOfElement(televisions);
        js.executeScript("arguments[0].scrollIntoView();", televisions);
        js.executeScript("arguments[0].focus();", televisions);
        televisions.click();
    }
}
