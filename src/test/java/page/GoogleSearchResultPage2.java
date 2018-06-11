package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultPage2 extends GoogleBasePage
{
    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List <WebElement> searchResultsPage2;

    public GoogleSearchResultPage2(WebDriver webDriver)
    {
        super(webDriver);
    }

    public List<String> getSearchResults()
    {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResultElement : searchResultsPage2)
        {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }
}
