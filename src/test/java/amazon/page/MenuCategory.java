package amazon.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuCategory extends HomePage {

    @FindBy(xpath = "//a/div[contains(text(),'TV, Appliances, Electronics')]")
    WebElement tvAppliancesElectronics;


    public static MenuCategory init() {
        return PageFactory.initElements(getDriver(), MenuCategory.class);
    }

    public void clickTvAppliancesElectronics() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        waitForVisibilityOfElement(tvAppliancesElectronics);
        js.executeScript("arguments[0].scrollIntoView();", tvAppliancesElectronics);
        js.executeScript("arguments[0].focus();", tvAppliancesElectronics);
        tvAppliancesElectronics.click();
    }
}
