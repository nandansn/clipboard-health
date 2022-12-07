package amazon.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class ElectronicsMenu extends MenuCategory {

    @FindBy(xpath = "//a[contains(text(),'Televisions')]")
    WebElement televisions;


    public static ElectronicsMenu init() {
        return PageFactory.initElements(getDriver(), ElectronicsMenu.class);
    }

    public void clickTelevision() {
        log.info("Opening sub menu - TV.");
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        waitForVisibilityOfElement(televisions);
        js.executeScript("arguments[0].scrollIntoView();", televisions);
        js.executeScript("arguments[0].focus();", televisions);
        televisions.click();
        log.info("Sub menu - TV, opened.");
    }
}
