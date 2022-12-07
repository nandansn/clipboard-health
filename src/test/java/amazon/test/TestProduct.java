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

/**
 * Test Script to validate the product category TV.
 *
 * Test Steps:
 *
 * - Open web: amazon.in
 * - Click menu, item category
 * - Click on Televisions under Tv, Audio & Cameras sub section.
 * - Scroll down and filter the results by Brand ‘Samsung’.
 * - Sort listed items by "Price: High To Low"
 * - Open or click second item in the sorted list
 * - Switch to child window
 * - Validate the text "About this item" in the Item Description section
 * - Get the "About this item" and log it in the console.
 */

@Slf4j

public class TestProduct {


    @BeforeEach
    public void openApp() {
        log.info("=====================  Test Execution Started ===========================================================");
        log.info("Project Assignment For Clipboard Health Interview | Author: Nandakumar. R");
        log.info("Opening the Application.");
        BasePage.openApp();
    }


    @DisplayName("Test to validate TV product in the electronics category")
    @Test
    public void testProductDetails() {

        String brandName = "Samsung";
        String sortBy = "Price: High to Low";
        int itemIndex = 2;
        String assertExpectedText = "About this item";

        openTvCategory();
        openTv(brandName, sortBy, itemIndex);
        assertAndLogTvDetails(assertExpectedText);
    }


    @AfterEach
    public void closeApp() {
        BasePage.closeApp();
        log.info("Application closed");
    }


    private void assertAndLogTvDetails(String assertExpectedText) {
        ProductDetailsPage detailsPage = ProductDetailsPage.init();

        detailsPage.switchToChildWindow();

        Assertions.assertEquals(assertExpectedText, ProductDetailsPage.init().getAboutItem());

        log.info("=====================  Product Description ===========================================================");

        List<String> details = detailsPage.getItemDetails();

        details.forEach(item -> {
            log.info(String.format("%d) -> %s", details.indexOf(item) + 1, item));
        });

        log.info("======================================================================================================");
    }

    private void openTv(String brandName, String sortBy, int itemIndex) {
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
