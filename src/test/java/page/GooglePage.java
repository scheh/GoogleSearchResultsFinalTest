package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.GoogleSearchResultTest;

import static java.lang.Thread.sleep;

public class GooglePage extends GoogleBasePage
{
    public GooglePage (WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(xpath = "//input[@type='button' and contains(@value,'Google')]")
    private WebElement searchButton;

    /**
     * @param searchTerm
     * @return Result page 1
     * Method for searching by searchTerm
     */
    public GoogleSearchResultPage1 search(String searchTerm) throws InterruptedException
    {
        searchField.sendKeys(searchTerm);
        sleep(3000);
        searchButton.click();
        return PageFactory.initElements(webDriver, GoogleSearchResultPage1.class);
    }
}
