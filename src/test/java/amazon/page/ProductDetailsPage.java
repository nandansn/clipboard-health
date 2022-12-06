package amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = "//div[@id='feature-bullets']/h1")
    WebElement aboutItem;

    String detailsPath = "//div[@id='feature-bullets']/ul//li/span";


    public static ProductDetailsPage init() {
        return PageFactory.initElements(getDriver(), ProductDetailsPage.class);
    }

    public String getAboutItem() {
        return aboutItem.getText();
    }

    public List<String> getItemDetails() {
        return getDriver().findElements(By.xpath(detailsPath)).stream().map(element -> element.getText()).collect(Collectors.toList());
    }
}
