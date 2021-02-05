package amazonpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AmazonOrder {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
        String url = "https://www.amazon.com/";

        /**
         * Locators
         */

        By searchbar = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
        By searchbtn = By.xpath("//*[@id=\"nav-search-submit-button\"]");
        By valueincart = By.xpath("//span[text()='Buy new:']/../../div[2]/span");
        By Addtocart = By.xpath("//*[@id=\"add-to-cart-button\"]");
        By procedtocheckout = By.xpath("//*[@id=\"hlb-ptc-btn-native\"]");
        By priceofcart = By.xpath("//div[@id='hlb-subcart']//span[2]");
        //1. Visit amazon.com Page
        driver.get(url);
        //2. Search for Book 'qa testing for beginners'
        driver.findElement(searchbar).sendKeys("qa testing for beginners");
        driver.findElement(searchbtn).click();
        // 3. Click on the 1st item in the listed results.
        WebElement ele = driver.findElement(By.xpath("//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/a/span[@class='a-price']/span[1]"));
        String pricebeforeAddtoCart = ele.getAttribute("textContent");
        //4. Before Click on add to cart Add to Cart asset price from Step 3.
        driver.findElement(By.xpath("//div[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div/div//a[@class='a-link-normal a-text-normal']")).click();
        String cartvalue = driver.findElement(valueincart).getAttribute("textContent");
        Assert.assertEquals(pricebeforeAddtoCart, cartvalue);
        // 5. Click on Add to Cart.
        driver.findElement(Addtocart).click();
        //6. Before Click on Proceed to Checkout asset price from Step 3.
        String afterAddToCartPric = driver.findElement(priceofcart).getAttribute("textContent");
        Assert.assertEquals(afterAddToCartPric, pricebeforeAddtoCart);
        //7. Click on proceed to checkout
        driver.findElement(procedtocheckout).click();

        driver.close();
    }

}







