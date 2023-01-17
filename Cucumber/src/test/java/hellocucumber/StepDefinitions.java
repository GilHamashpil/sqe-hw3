package hellocucumber;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
public class StepDefinitions {
    private static List<PrestaActuator> allPrestas;
    private static PrestaActuator presta;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "C:\\Users\\gilgu\\Desktop\\הנדסת מערכות מידע\\סמסטר ה'\\הנדסת איכות תוכנה\\sqe-hw3-main\\sqe-hw3-main\\sqe-hw3\\Selenium\\chromedriver.exe";
    private void prestaInit(){
        System.out.println("--------------- INITIALIZING MOODLE TEST - OPENING WEBPAGE ---------------");
        if(allPrestas == null){
            allPrestas = new ArrayList<>();
        }
        presta = new PrestaActuator();
        allPrestas.add(presta);
        presta.initSession(webDriver, path);
    }

    @Given("User is on the catalog")
    public void userIsOnTheCatalog() {
        prestaInit();

    }


    @Then("message displayed item out of stock!")
    public void messageDisplayedItemOutOfStock() {
    }

    @When("User adds item to cart")
    public void userAddsItemToCart() {
        
    }

    @And("Admin set item stock to {int}")
    public void adminSetItemStockTo(int arg0) {
    }

    @When("User adds item on discount to cart")
    public void userAddsItemOnDiscountToCart() {
        
    }

    @And("Admin changes discount")
    public void adminChangesDiscount() {
        
    }

    @Then("message displayed price changed!")
    public void messageDisplayedPriceChanged() {
    }

    @And("User returns to shopping")
    public void userReturnsToShopping() {
        
    }

    @And("user returns to shopping cart")
    public void userReturnsToShoppingCart() {
    }

    @When("User adds discount item to cart")
    public void userAddsDiscountItemToCart() {
    }

    @And("admin changes discount percentage")
    public void adminChangesDiscountPercentage() {
    }
}
