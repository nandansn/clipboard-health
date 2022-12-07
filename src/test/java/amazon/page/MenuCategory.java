package amazon.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class MenuCategory extends HomePage {

    @FindBy(xpath = "//a/div[contains(text(),'TV, Appliances, Electronics')]")
    WebElement tvAppliancesElectronics;


    public static MenuCategory init() {
        return PageFactory.initElements(getDriver(), MenuCategory.class);
    }

    public void clickTvAppliancesElectronics() {
        log.info("Opening sub menu - TV, Appliances, Electronics.");
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        waitForVisibilityOfElement(tvAppliancesElectronics);
        js.executeScript("arguments[0].scrollIntoView();", tvAppliancesElectronics);
        js.executeScript("arguments[0].focus();", tvAppliancesElectronics);
        tvAppliancesElectronics.click();
        log.info("Sub menu - TV, Appliances, Electronics, opened.");
    }
}
