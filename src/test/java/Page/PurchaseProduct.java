package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class PurchaseProduct {
    WebDriver driver;
    @FindBy(css = "img")
    List<WebElement> imgProducts;
    @FindBy(className = "single_add_to_cart_button")
    WebElement btnAddCart;
    @FindBy(css = "i")
    List<WebElement> viewCart;
    @FindBy(xpath = "//a[contains(text(),\"Proceed to checkout\")]")
    WebElement btnCheckout;
    @FindBy(id = "pa_color")
    WebElement dropdown;
    @FindBy(className = "entry-title")
    WebElement prodName;
    @FindBy(className = "product-name")
    List<WebElement> matchColorCart;
    @FindBy(className = "input-text")
    List<WebElement> quantityModify;
    @FindBy(name = "update_cart")
    WebElement updateCart;
    @FindBy(className = "product-price")
    List<WebElement> basePrice;
    @FindBy(xpath = "//td[@data-title = \"Subtotal\"]")
    WebElement subtotalPrice;
    @FindBy(id = "place_order")
    WebElement btnConfirmOrder;
    @FindBy(css = "ul.woocommerce-error li")
    List<WebElement> errorList;
    @FindBy(id = "billing_first_name")
    WebElement fName;
    @FindBy(id = "billing_last_name")
    WebElement lName;
    @FindBy(id="billing_address_1")
    WebElement address;
    @FindBy(id="billing_city")
    WebElement town;
    @FindBy(id = "billing_postcode")
    WebElement postCode;
    @FindBy(id = "billing_phone")
    WebElement phone;
    @FindBy(id = "billing_email")
    WebElement mail;
    @FindBy(className = "showcoupon")
    WebElement coupon;
    @FindBy(id = "coupon_code")
    WebElement couponCode;
    @FindBy(name = "apply_coupon")
    WebElement applyCoupon;


    public PurchaseProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void matchName() throws InterruptedException {
        imgProducts.get(1).click();
        Thread.sleep(2000);
        String name = prodName.getText();
        Assert.assertEquals("Black pants", name);
    }

    public void selectColor() throws InterruptedException {
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(2000);
        btnAddCart.click();
        viewCart.get(3).click();
        String colorName = matchColorCart.get(1).getText();
        Assert.assertEquals("Black pants - Red", colorName);
    }

    public void addQuantity() throws InterruptedException {
        quantityModify.get(0).clear();
        quantityModify.get(0).sendKeys("2");
        updateCart.click();
        String unitText = basePrice.get(1).getText().substring(1, 3);
        int unitPrice = Integer.parseInt(unitText);
        int subTotal = unitPrice * 2;
        Thread.sleep(5000);
        String subText = subtotalPrice.getText().substring(1, 4);
        int matchTotal = Integer.parseInt(subText);
        Assert.assertEquals(subTotal, matchTotal);
        btnCheckout.click();
        Thread.sleep(3000);
    }

    public void placeOrder() throws InterruptedException {
        btnConfirmOrder.click();
        Thread.sleep(3000);
        int listLength = errorList.size();
        System.out.println(listLength);
        Assert.assertEquals(8, listLength);
    }

    public void invalidMail() throws InterruptedException {
        fName.clear();
        fName.sendKeys("Zubair");
        Thread.sleep(1000);
        lName.clear();
        lName.sendKeys("Hasan");
        Thread.sleep(1000);
        address.clear();
        address.sendKeys("ASDFGH");
        Thread.sleep(1000);
        town.clear();
        town.sendKeys("ASDF1234");
        Thread.sleep(1000);
        postCode.clear();
        postCode.sendKeys("AB10AA");
        Thread.sleep(1000);
        phone.clear();
        phone.sendKeys("12345678901");
        Thread.sleep(1000);
        mail.clear();
        mail.sendKeys("test.test.test");
        Thread.sleep(1000);
        btnConfirmOrder.click();
        Thread.sleep(3000);
        String response = errorList.get(0).getText();
        System.out.println(response);
        Assert.assertEquals("Invalid billing email address", response);
    }
    public void invalidPhone() throws InterruptedException {
        fName.clear();
        fName.sendKeys("Zubair");
        Thread.sleep(1000);
        lName.clear();
        lName.sendKeys("Hasan");
        Thread.sleep(1000);
        address.clear();
        address.sendKeys("ASDFGH");
        Thread.sleep(1000);
        town.clear();
        town.sendKeys("ASDF1234");
        Thread.sleep(1000);
        postCode.clear();
        postCode.sendKeys("AB10AA");
        Thread.sleep(1000);
        phone.clear();
        phone.sendKeys("123456789asd");
        Thread.sleep(1000);
        mail.clear();
        mail.sendKeys("test@test.test");
        Thread.sleep(1000);
        btnConfirmOrder.click();
        Thread.sleep(3000);
        String response = errorList.get(0).getText();
        System.out.println(response);
        Assert.assertNotSame("is not a valid phone number", response);
    }
    public void invalidPostCode() throws InterruptedException {
        fName.clear();
        fName.sendKeys("Zubair");
        Thread.sleep(1000);
        lName.clear();
        lName.sendKeys("Hasan");
        Thread.sleep(1000);
        address.clear();
        address.sendKeys("ASDFGH");
        Thread.sleep(1000);
        town.clear();
        town.sendKeys("ASDF1234");
        Thread.sleep(1000);
        postCode.clear();
        postCode.sendKeys("asdf");
        Thread.sleep(1000);
        phone.clear();
        phone.sendKeys("12345678901");
        Thread.sleep(1000);
        mail.clear();
        mail.sendKeys("test@test.test");
        Thread.sleep(1000);
        btnConfirmOrder.click();
        Thread.sleep(3000);
        String response = errorList.get(0).getText();
        System.out.println(response);
        Assert.assertEquals("is not a valid postcode / ZIP.", response);
    }
    public void invalidCoupon() throws InterruptedException {
        fName.clear();
        fName.sendKeys("Zubair");
        Thread.sleep(1000);
        lName.clear();
        lName.sendKeys("Hasan");
        Thread.sleep(1000);
        address.clear();
        address.sendKeys("ASDFGH");
        Thread.sleep(1000);
        town.clear();
        town.sendKeys("ASDF1234");
        Thread.sleep(1000);
        postCode.clear();
        postCode.sendKeys("AB10AA");
        Thread.sleep(1000);
        phone.clear();
        phone.sendKeys("12345678901");
        Thread.sleep(1000);
        mail.clear();
        mail.sendKeys("test@test.test");
        Thread.sleep(1000);
        coupon.click();
        Thread.sleep(1000);
        couponCode.sendKeys("asd1325");
        Thread.sleep(1000);
        applyCoupon.click();
        Thread.sleep(1000);
        btnConfirmOrder.click();
        Thread.sleep(3000);
        String response = errorList.get(0).getText();
        System.out.println(response);
        Assert.assertEquals("Invalid billing email address", response);
    }

    public void validOrder() throws InterruptedException {
        fName.clear();
        fName.sendKeys("Zubair");
        Thread.sleep(1000);
        lName.clear();
        lName.sendKeys("Hasan");
        Thread.sleep(1000);
        address.clear();
        address.sendKeys("ASDFGH");
        Thread.sleep(1000);
        town.clear();
        town.sendKeys("ASDF1234");
        Thread.sleep(1000);
        postCode.clear();
        postCode.sendKeys("AB10AA");
        Thread.sleep(1000);
        phone.clear();
        phone.sendKeys("12345678901");
        Thread.sleep(1000);
        mail.clear();
        mail.sendKeys("test@test.test");
        Thread.sleep(1000);
        btnConfirmOrder.click();
    }
}
