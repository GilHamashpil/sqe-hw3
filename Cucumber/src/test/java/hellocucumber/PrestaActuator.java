package hellocucumber;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PrestaActuator {
    private WebDriver driverAdmin;
    private WebDriver driverUser;
    private WebDriverWait waitAdmin;
    private WebDriverWait waitUser;




    public void initSessionUser(String webDriver, String path) {
        System.setProperty(webDriver, path);
        // new chrome driver object
        this.driverUser = new ChromeDriver();
        // new web driver wait -> waits until element are loaded (40 sec max)
        this.waitUser = new WebDriverWait(driverUser, Duration.ofSeconds(17));
        driverUser.get("https://demo.prestashop.com/#/en/front");
        driverUser.manage().window().maximize();
        System.out.println("User Driver setup finished for - " + driverUser.getTitle());
    }

    public void initSessionAdmin(String webDriver, String path) {
        System.setProperty(webDriver, path);

        // new chrome driver object
        this.driverAdmin = new ChromeDriver();

        // new web driver wait -> waits until element are loaded (40 sec max)
        this.waitAdmin = new WebDriverWait(driverAdmin, Duration.ofSeconds(17));


        // launch website -> prestashop
        driverAdmin.get("https://demo.prestashop.com/#/en/back");

        // maximize the window - some web apps look different in different sizes
        driverAdmin.manage().window().maximize();



        /*
            If we wanted to test the web application on different devices -
                1. Open the web app
                2. Right click -> click inspect
                3. Click on the phone icon at the top left corner of the inspect window (the app changes preview format at this point)
                4. Locate the dimensions drop-down list at the top of the web app and choose device
                5. Copy dimensions size (on the right side of the drop-down list)
                   -> driver.manage().window().setSize(new Dimension(width, height));
         */

        System.out.println("Admin Driver setup finished for - " + driverAdmin.getTitle());
    }

    public void adminSetItemStockTo0(){
        //Moving into the right frame
        WebElement iframe = driverAdmin.findElement(By.xpath("//*[@id='framelive']"));
        driverAdmin.switchTo().frame(iframe);
        //Admin log in into the system
        waitAdmin.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit_login']"))).click();
        //press on the Catalog button
        waitAdmin.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='subtab-AdminCatalog']"))).click();
        //get into the stock area and change one item to be out of stock
        waitAdmin.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='subtab-AdminStockManagement']"))).click();
        ((JavascriptExecutor) driverAdmin).executeScript("window.scrollBy(0,500)");
        WebElement stockField = waitAdmin.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[26]/td[9]"))).findElement(By.cssSelector("input.form-control"));
        stockField.clear();
        stockField.sendKeys("-300");
        waitAdmin.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[26]/td[9]"))).findElement(By.cssSelector("button.check-button")).click();


    }
    public void  adminChangedTheDiscount(){
        //Moving into the right frame
        WebElement iframe = driverAdmin.findElement(By.xpath("//*[@id='framelive']"));
        driverAdmin.switchTo().frame(iframe);
        //Admin log in into the system
        waitAdmin.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit_login']"))).click();
        //press on the Catalog button
        waitAdmin.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='subtab-AdminCatalog']"))).click();
        //Get into the products and change the discount of "Hummingbird printed sweater" to 10%
        driverAdmin.findElement(By.xpath("//*[@id='subtab-AdminProducts']")).click();
        waitAdmin.until(ExpectedConditions.elementToBeClickable(By.linkText("Hummingbird printed sweater"))).click();
        waitAdmin.until(ExpectedConditions.elementToBeClickable(By.linkText("Pricing"))).click();
        ((JavascriptExecutor) driverAdmin).executeScript("window.scrollBy(0,500)");
        waitAdmin.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='js-edit edit btn tooltip-link delete pl-0 pr-0']"))).findElement(By.tagName("i")).click();
        WebElement discountField= waitAdmin.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id*='form_modal_sp_reduction']")));
        discountField.clear();
        discountField.sendKeys("10");
        waitAdmin.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id*='form_modal_save']"))).click();

    }
    public void userAddsItemToCart(String itemName){

        //Moving into the right frame
        WebElement iframe = driverUser.findElement(By.xpath("//*[@id='framelive']"));
        driverUser.switchTo().frame(iframe);
        ((JavascriptExecutor) driverUser).executeScript("window.scrollBy(0,200)");
        waitUser.until(ExpectedConditions.elementToBeClickable(By.xpath(itemName))).click();
        waitUser.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='btn btn-primary add-to-cart']"))).click();

    }

    public void userAddsItemToWishlist(){

        //user need to sign up
        //Moving into the right frame
        WebElement iframe = driverUser.findElement(By.xpath("//*[@id='framelive']"));
        driverUser.switchTo().frame(iframe);
        waitUser.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a"))).click();
        waitUser.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section/div/div/div/section/div/div/a"))).click();

        //writing all the information
        waitUser.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div/div/div/section/div/section/form/div/div[2]/div[1]/input"))).sendKeys("Gil");
        waitUser.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div/div/div/section/div/section/form/div/div[3]/div[1]/input"))).sendKeys("Mich");
        waitUser.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"field-email\"]"))).sendKeys("gil@gmail.com");
        waitUser.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"field-password\"]"))).sendKeys("*Am4mneXjt");
        waitUser.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div/div/div/section/div/section/form/div/div[6]/div[1]/input"))).sendKeys("01/06/1996");
        ((JavascriptExecutor) driverUser).executeScript("window.scrollBy(0,200)");
        waitUser.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section/div/div/div/section/div/section/form/div/div[9]/div[1]"))).click();
        ((JavascriptExecutor) driverUser).executeScript("window.scrollBy(0,200)");
        waitUser.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section/div/div/div/section/div/section/form/footer/button"))).click();
        waitUser.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/section[1]/div/div[6]/article/div/div[1]/a"))).click();
        waitUser.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/button"))).click();
        waitUser.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"footer\"]/div[2]/div/div[1]/div[4]/div[1]/div/div/div[2]/div/ul/li/p"))).click();


    }
    public void userComebackToWishlist(){
        waitUser.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a[2]/span"))).click();
        waitUser.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section/div/div/div/section/section/div/div/a[5]/span/i"))).click();
        waitUser.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section/div/div/div/section/div[1]/section/div/ul/li/a/p"))).click();

    }
    public void userContinueToCheckout(){
        waitUser.until(ExpectedConditions.elementToBeClickable(By.className("cart-content-btn"))).findElement(By.tagName("a")).click();

    }

}


