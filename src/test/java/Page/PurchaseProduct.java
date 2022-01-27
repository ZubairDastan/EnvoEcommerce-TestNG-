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
    @FindBy(name = "add-to-cart")
    WebElement btnAddCart;
    @FindBy(xpath = "//a[contains(text(),\"View cart\")]")
    List<WebElement> viewCart;
    @FindBy(xpath = "//a[contains(text(),\"Proceed to checkout\")]")
    WebElement btnCheckout;
    @FindBy(id = "pa_color")
    WebElement dropdown;
    @FindBy(className = "entry-title")
    WebElement prodName;

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
    }
}
