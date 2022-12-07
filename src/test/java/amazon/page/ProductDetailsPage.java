package amazon.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = "//div[@id='feature-bullets']/h1")
    WebElement aboutItem;

    String detailsPath = "//div[@id='feature-bullets']/ul//li/span";


    public static ProductDetailsPage init() {
        return PageFactory.initElements(getDriver(), ProductDetailsPage.class);
    }

    public String getAboutItem() {
        log.info(String.format("Get about item text"));
        return aboutItem.getText();
    }

    public List<String> getItemDetails() {
        log.info(String.format("Get item details"));
        return getDriver().findElements(By.xpath(detailsPath)).stream().map(element -> element.getText()).collect(Collectors.toList());
    }
}
