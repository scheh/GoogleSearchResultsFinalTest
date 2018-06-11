package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultPage1 extends GoogleBasePage
{
    @FindBy(xpath = "//*[@aria-label='Page 1']")
    private WebElement page1Icon;

    @FindBy(xpath = "//*[@aria-label='Page 2']")
    private WebElement page2Icon;

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List <WebElement> searchResultsPage1;

    /**
     * @param webDriver
     * Constructor for Google search result page 1
     */
    public GoogleSearchResultPage1(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * @return Google search page 2
     * Method for clicking on "page 2 icon" to get the next page
     */
    public GoogleSearchResultPage2 clickIcon()
    {
        page2Icon.click();
        return PageFactory.initElements(webDriver, GoogleSearchResultPage2.class);
    }

    /**
     * @return page 1 icon and search results for page 1
     * Method checking for the next elements:"page 1 icon", "search results for page 1"
     */
    public boolean isPageLoaded()
    {
        return page1Icon.isDisplayed();
    }

    public List<String> getSearchResults()
    {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResultElement : searchResultsPage1)
        {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }

}
