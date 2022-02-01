package TestRunner;

import Page.PurchaseFromSale;
import Setup.EnvironmentSetup;
import org.testng.annotations.Test;

public class SaleTestRunner extends EnvironmentSetup {

    @Test(priority = 1, groups = "SalePurchase", description = "View product from sale page")
    public void viewProduct() throws InterruptedException {
            driver.get("https://envothemes.com/envo-ecommerce/sale/");
            PurchaseFromSale salePurchase = new PurchaseFromSale(driver);
            salePurchase.matchTitle();
    }

    @Test(priority = 2, groups = "SalePurchase", description = "Add to cart from sale page")
    public void cartToCheckout() throws InterruptedException {
            PurchaseFromSale salePurchase = new PurchaseFromSale(driver);
            Thread.sleep(2000);
            salePurchase.cartPage();
    }
}
