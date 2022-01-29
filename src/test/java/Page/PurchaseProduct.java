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
    }
}
