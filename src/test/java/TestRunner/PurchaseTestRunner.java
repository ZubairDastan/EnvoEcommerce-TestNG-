package TestRunner;

import Page.PurchaseProduct;
import Setup.EnvironmentSetup;
import org.testng.annotations.Test;

public class PurchaseTestRunner extends EnvironmentSetup {

    @Test(priority = 1, groups = "purchase", description = "Check if product card is clickable")
    public void viewProduct() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/shop/");
        PurchaseProduct purchase = new PurchaseProduct(driver);
        purchase.productVisiblity();
    }

    @Test(priority = 2, groups = "purchase", description = "Select a product")
    public void selectMyProduct() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/shop/");
        PurchaseProduct purchase = new PurchaseProduct(driver);
        purchase.matchName();

    }

    @Test(priority = 3, groups = "purchase", description = "Select color and add in cart")
    public void selectProductColor() throws InterruptedException {
        PurchaseProduct purchase = new PurchaseProduct(driver);
        purchase.selectColor();
    }

    @Test(priority = 4, groups = "purchase", description = "Increase quantity and update cart")
    public void increaseQuantity() throws InterruptedException {
        PurchaseProduct purchase = new PurchaseProduct(driver);
        purchase.addQuantity();
    }

    @Test(priority = 5, groups = "purchase", description = "Place order without any billing info")
    public void invalidOrder() throws InterruptedException {
        PurchaseProduct purchase = new PurchaseProduct(driver);
        purchase.placeOrder();
    }

    @Test(priority = 6, groups = "purchase", description = "Put invalid email in email field")
    public void wrongEmail() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/checkout/");
        PurchaseProduct purchase = new PurchaseProduct(driver);
        purchase.invalidMail();
    }

    @Test(priority = 7, groups = "purchase", description = "Put text as phone number")
    public void wrongPhone() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/checkout/");
        PurchaseProduct purchase = new PurchaseProduct(driver);
        purchase.invalidPhone();
    }

    @Test(priority = 8, groups = "purchase", description = "Put invalid postal code")
    public void wrongPostCode() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/checkout/");
        PurchaseProduct purchase = new PurchaseProduct(driver);
        purchase.invalidPostCode();
    }

    @Test(priority = 9, groups = "purchase", description = "Put invalid coupon code")
    public void wrongCoupon() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/checkout/");
        PurchaseProduct purchase = new PurchaseProduct(driver);
        purchase.invalidCoupon();
    }

    @Test(priority = 10, groups = "purchase", description = "Final order placing")
    public void placeOrderFinal() throws InterruptedException {
        driver.get("https://envothemes.com/envo-ecommerce/checkout/");
        PurchaseProduct purchase = new PurchaseProduct(driver);
        purchase.validOrder();
    }
}
