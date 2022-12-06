package amazon.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "nav-hamburger-menu")
    WebElement menu;

    public static HomePage init() {
        return PageFactory.initElements(getDriver(), HomePage.class);
    }

    public void clickMenu() {
        menu.click();
    }
}
