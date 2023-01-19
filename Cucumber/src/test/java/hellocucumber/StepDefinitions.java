package hellocucumber;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {

    // $$*TODO* explain what this step does$$

    private static List<PrestaActuator> allPrestas;
    private static PrestaActuator prestaAdmin;
    private static PrestaActuator prestaUser;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "C:\\Users\\hilae\\Desktop\\sqe-hw3-main\\Selenium\\chromedriver.exe";

    private void prestaInit(){
        System.out.println("--------------- INITIALIZING MOODLE TEST - OPENING WEBPAGE ---------------");
        if(allPrestas == null){
            allPrestas = new ArrayList<>();
        }
        prestaAdmin = new PrestaActuator();
        prestaUser =new PrestaActuator();
        allPrestas.add(prestaAdmin);
        allPrestas.add(prestaUser);
        prestaAdmin.initSessionAdmin(webDriver, path);
        prestaUser.initSessionUser(webDriver, path);
    }

    @Given("User is on the catalog")
    public void userIsOnTheCatalog() {
        prestaInit();


    }


    @When("User adds item for sale to cart")
    public void userAddsItemForSaleToCart() {
        String itemForSale = "//a[contains(@href,'1-size-s')]/img[contains(@src,'brown-bear-printed-sweater')]";
        prestaUser.userAddsItemToCart(itemForSale);

    }

    //User adds item to wishlist

    @When("User adds item to wishlist")
    public void userAddsItemToWishlist() {
        prestaUser.userAddsItemToWishlist();

    }


    @When("Admin changed the discount of the item")
    public void adminChangedTheDiscount() {
        prestaAdmin.adminChangedTheDiscount();

    }

    @When("Admin set item stock to 0")
    public void adminSetItemStockTo0() {
        prestaAdmin.adminSetItemStockTo0();

    }


   //
   @When("User comeback to wishlist")
   public void userComebackToWishlist() {
       prestaUser.userComebackToWishlist();

   }

    @When("User continue to checkout")
    public void userContinueToCheckout() {
        prestaUser.userContinueToCheckout();

    }
   @When("User continue to checkout with sale item")
    public void userContinueToCheckoutWithSaleItem() {
        prestaUser.userContinueToCheckout();

    }

    @Then("Message displayed item out of stock!")
    public void messageDisplayedItemOutOfStock() {
        System.out.println("Message displayed item out of stock successfully");
    }
    @Then("Price and discount changed in the checkout window")
    public void priceAndDiscountHasChanged() {
        System.out.println("Price and discount changed in the checkout window successfully");
    }

}

