package amazon.test;

import amazon.page.BasePage;
import amazon.page.ElectronicsMenu;
import amazon.page.HomePage;
import amazon.page.MenuCategory;
import amazon.page.ProductDetailsPage;
import amazon.page.ProductsListingPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class TestProduct {


//    ========================================= Test Data ==============================================

    String brandName = "Samsung";
    String sortBy = "Price: High to Low";
    int itemIndex = 2;
    String assertExpectedText = "About this item";

//  =====================================================================================================


    @BeforeEach
    public void openApp() {
        log.info("Opening the Application.");
        BasePage.openApp();
    }


    @DisplayName("Test to validate TV product in the electronics category")
    @Test
    public void testProductDetails() {
        openTvCategory();
        openTv();
        assertAndLogTvDetails();
    }


    @AfterEach
    public void closeApp() {
        BasePage.closeApp();
        log.info("Application closed");
    }


    private void assertAndLogTvDetails() {
        ProductDetailsPage detailsPage = ProductDetailsPage.init();

        detailsPage.switchToChildWindow();

        Assertions.assertEquals(assertExpectedText, ProductDetailsPage.init().getAboutItem());

        log.info("=====================  Product Description ========================================================================================================================================================================");

        List<String> details = detailsPage.getItemDetails();

        details.forEach(item -> {
            log.info(String.format("%d) -> %s", details.indexOf(item) + 1, item));
        });

        log.info("==================================================================================================================================================================================================================");
    }

    private void openTv() {
        ProductsListingPage listingPage = ProductsListingPage.init();
        listingPage.clickBrand(brandName);
        listingPage.sortListing(sortBy);
        listingPage.openAnItem(itemIndex);
    }

    private void openTvCategory() {
        HomePage.init().clickMenu();
        MenuCategory.init().clickTvAppliancesElectronics();
        ElectronicsMenu.init().clickTelevision();
    }
}
