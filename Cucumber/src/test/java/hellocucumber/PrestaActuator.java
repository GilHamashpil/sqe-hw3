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
        //webDriver = "webdriver.chrome.driver";
        //path = "C:\\Users\\eylon\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty(webDriver, path);

        // new chrome driver object
        this.driverAdmin = new ChromeDriver();

        // new web driver wait -> waits until element are loaded (40 sec max)
        this.waitAdmin = new WebDriverWait(driverAdmin, Duration.ofSeconds(17));


        // launch website -> localhost
        //driver.get("https://demo.prestashop.com/");
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

    public void InitAdmin(){
        driverAdmin.findElement(By.linkText("Explore back office")).click();
    }
    private void loginAdmin(){
        // this.wait = new WebDriverWait(driver, Duration.ofSeconds(17));
        waitAdmin.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit_login']"))).click();
        //driver.switchTo().defaultContent();
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //  wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log in")));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='submit_login']")));
        //driver.findElement(By.xpath("//*[@id='submit_login']")).click();

        //   driver.findElement(By.cssSelector("button#submit_login")).click();


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
    public void  adminChangedTheDiscount(String itemName){
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


        //driver.findElement(By.xpath("//a[@href='https://harmonious-thought.demo.prestashop.com/admin-dev/index.php/sell/catalog/products/2?_token=BiddOrQ8cnOBllc5r4VKseIZw9Qar-zeaw3QrqUq7Cs#tab-step2']")).click();



    }
    public void userAddsItemToCart(String itemName){

        //Moving into the right frame
        WebElement iframe = driverUser.findElement(By.xpath("//*[@id='framelive']"));
        driverUser.switchTo().frame(iframe);
        ((JavascriptExecutor) driverUser).executeScript("window.scrollBy(0,200)");
        waitUser.until(ExpectedConditions.elementToBeClickable(By.xpath(itemName))).click();
        //By.cssSelector("input[id*='form_modal_sp_reduction']")
        waitUser.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='btn btn-primary add-to-cart']"))).click();

        //driverUser.findElement(By.xpath("//a[contains(@href,'1-size-s')]/img[contains(@src,'brown-bear-printed-sweater')]")).click();
        //waitUser.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='h2 products-section-title text-uppercase']"))).findElement(By.className("h3 product-title")).findElement(By.linkText("Hummingbird printed sweater")).click();
        //driverUser.findElement(By.xpath("//a[@href='https://immune-meat.demo.prestashop.com/en/women/2-9-brown-bear-printed-sweater.html#/1-size-s']")).click();
        //waitUser.until(ExpectedConditions.elementToBeClickable(By.linkText("Hummingbird printed sweater"))).click();
        //driver.findElement(By.xpath("//a[@href ='https://rugged-brick.demo.prestashop.com/en/women/2-9-brown-bear-printed-sweater.html#/1-size-s']")).click();

    }
    public void userContinueToCheckout(){
        waitUser.until(ExpectedConditions.elementToBeClickable(By.className("cart-content-btn"))).findElement(By.tagName("a")).click();

    }

}

