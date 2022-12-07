package amazon.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class HomePage extends BasePage {

    @FindBy(id = "nav-hamburger-menu")
    WebElement menu;

    public static HomePage init() {
        return PageFactory.initElements(getDriver(), HomePage.class);
    }

    public void clickMenu() {
        log.info("Opening main menu");
        menu.click();
        log.info("Main menu Opened");
    }
}
