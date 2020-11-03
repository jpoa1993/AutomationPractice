package Practice.steps;

import Practice.pages.ShoppingCartPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;

public class ShoppingCartSteps {

    private ShoppingCartPage shoppingCartPage;

    @Given("^I have a product in the cart$")
    public void iHaveAProductInTheCart() {
        String productId = "1_1_0_0";
        shoppingCartPage.open();
        shoppingCartPage.productHadBeenAddedToCart(productId);
        Serenity.setSessionVariable("productId").to(productId);
    }

    @When("^I remove the product from the cart$")
    public void iRemoveTheProductFromTheCart() {
        String productId = Serenity.getCurrentSession().get("productId").toString();
        shoppingCartPage.removeProduct(productId);
    }

    @Then("^The cart contains the product$")
    public void theCartContainsTheProduct() {
        shoppingCartPage.open();
        shoppingCartPage.checkCartContainsProduct();
    }

    @Then("^The cart does not contain the product$")
    public void theCartDoesNotContainTheProduct() {
        String productId = Serenity.getCurrentSession().get("productId").toString();
        shoppingCartPage.checkCartDoesNotContainProduct(productId);
    }
   
}
