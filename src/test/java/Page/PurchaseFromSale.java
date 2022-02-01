package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class PurchaseFromSale {
    WebDriver driver;

    @FindBy(css = "img")
    List<WebElement> productList;

    @FindBy(name = "add-to-cart")
    WebElement addCart;

    @FindBy(className = "wc-forward")
    List<WebElement> viewCart;

    @FindBy(className = "wc-proceed-to-checkout")
    WebElement btnCheckout;

    public PurchaseFromSale(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void matchTitle() throws InterruptedException {
        productList.get(4).click();
        Thread.sleep(2000);
        String urlTitle = driver.getTitle();
        Assert.assertTrue(urlTitle.contains("Black trousers"));
        addCart.click();
    }

    public void cartPage(){
        viewCart.get(4).click();
        btnCheckout.click();
    }


}
