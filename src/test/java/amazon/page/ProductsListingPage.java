package amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsListingPage extends BasePage {


    String brandElPath = "//div[@class='a-section a-spacing-none']//span[text()='Brands']/" +
            "parent::div/following-sibling::ul//li//span[contains(text(),'%s')]/preceding-sibling::div/parent::a";


    String itemPath = "//div[@data-component-type='s-search-result' and @data-index='%s']//img";

    @FindBy(xpath = "//select[@id='s-result-sort-select']")
    WebElement selectSort;

    public static ProductsListingPage init() {
        return PageFactory.initElements(getDriver(), ProductsListingPage.class);
    }

    public void clickBrand(String brandName) {
        brandElPath = String.format(brandElPath, brandName);
        WebElement brandElement = getDriver().findElement(By.xpath(brandElPath));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", brandElement);
        brandElement.click();
    }

    public void sortListing(String text) {
        Select sort = new Select(selectSort);
        sort.selectByVisibleText(text);
    }

    public void openAnItem(int itemIndex) {
        itemPath = String.format(itemPath, itemIndex);
        getDriver().findElement(By.xpath(itemPath)).click();
    }
}
