package TestRunner;

import Page.PurchaseProduct;
import Setup.EnvironmentSetup;
import org.testng.annotations.Test;

public class PurchaseTestRunner extends EnvironmentSetup {
    @Test(priority = 1, groups = "purchase", description = "Select a product")
    public void selectMyProduct() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce");
        PurchaseProduct purchase = new PurchaseProduct(driver);
        purchase.selectProduct();
    }

    @Test(priority = 2, groups = "purchase", description = "Add product in cart")
    public void addCart() throws InterruptedException {
        PurchaseProduct purchase = new PurchaseProduct(driver);
        purchase.addCart();
    }
}
