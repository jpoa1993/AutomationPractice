package Practice.steps;

import Practice.pages.ProductPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;

import static net.serenitybdd.core.pages.PageObject.withParameters;

public class ProductSteps {

    private ProductPage productPage;

    @Given("^I am on the page for a product")
    public void iAmOnThePageForAProduct() {
        String productId = "1_1_0_0";
        productPage.open("productPage", withParameters(productId));
        productPage.storeProductReference();
        Serenity.setSessionVariable("productId").to("product_"+productId);
    }

    @When("^I add the product to the cart$")
    public void iAddTheProductToTheCart() {
        productPage.addItemToCart();
    }
    
    @Then("^I see the related product preview$")
    public void iSeeTheRelatedProductPreview() {
        productPage.checkProductPreview();
    }

}
