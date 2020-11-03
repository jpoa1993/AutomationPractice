package Practice.steps;

import Practice.pages.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;

import static net.serenitybdd.core.pages.PageObject.withParameters;

public class SearchSteps {

    private SearchPage searchPage;

    @Given("^I have searched for a product$")
    public void iHaveSearchedForAProduct() {
        searchPage.open("searchResultPage", withParameters("blouse"));
    }

    @When("^I search for '(.*)'$")
    public void iSearchForProduct(String searchTerm) {
        searchPage.searchForProduct(searchTerm);
        Serenity.setSessionVariable("searchTerm").to(searchTerm);
    }

    @When("^I view the page of the first product$")
    public void iViewThePageOfTheFirstProduct() {
        searchPage.viewProductDetailsPage();
    }

    @When("^I view the product preview$")
    public void iViewTheProductPreview() {
        searchPage.viewProductPreview();
    }

    
}
