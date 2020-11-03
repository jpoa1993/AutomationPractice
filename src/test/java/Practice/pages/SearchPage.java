package Practice.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.interactions.Actions;


@NamedUrls({@NamedUrl(name = "searchResultPage", url = "/index.php?controller=search&search_query={1}")})
public class SearchPage extends PageObject {
	
    public void searchForProduct(String searchTerm) {
        WebElementFacade searchField = find(By.id("search_query_top"));
        searchField.typeAndEnter(searchTerm);
    }

   public void viewProductDetailsPage() {
        WebElementFacade product = find(By.jquery(".product-container a.product-name"));
        Serenity.setSessionVariable("productName").to(product.getText());
        product.click();
    }

    public void viewProductPreview() {
        WebElementFacade product = find(By.jquery(".product-container a.product-name"));
        Serenity.setSessionVariable("productName").to(product.getText());

        WebElementFacade productImage = find(By.className("product_img_link"));
        Actions action = new Actions(this.getDriver());
        action.moveToElement(productImage).build().perform();

        WebElementFacade quickView = find(By.jquery("a.quick-view"));
        quickView.click();

        waitFor((WebElementFacade) find(By.jquery("div.fancybox-opened")));
    }

    public void viewCategory(String category) {
        String parentCategory = "#block_top_menu .sf-menu > li";
        WebElementFacade parentCategoryLink = find(By.jquery(parentCategory + " > a:eq(1)"));
        hoverElement(parentCategoryLink);

        WebElementFacade subCategory = find(By.jquery(parentCategory + " > ul > li > a[title='" + category + "']"));
        subCategory.click();
    }

    private void hoverElement(WebElementFacade element) {
        Actions builder = new Actions(getDriver());
        Actions hoverOverLocationSelector = builder.moveToElement(element);
        hoverOverLocationSelector.perform();
    }

    
}
