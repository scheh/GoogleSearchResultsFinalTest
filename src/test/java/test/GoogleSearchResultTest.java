package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GooglePage;
import page.GoogleSearchResultPage1;
import page.GoogleSearchResultPage2;

import java.util.List;

import static java.lang.Thread.sleep;

public class GoogleSearchResultTest extends GoogleSearchBaseTest
{
    @Test
    public void googleSearch() throws InterruptedException
    {
        String searchTerm = "Selenium";

        GoogleSearchResultPage1 googleSearchResultPage1 = googlePage.search(searchTerm);

        List<String> googleSearchResultsList = googleSearchResultPage1.getSearchResults();
        Assert.assertEquals(googleSearchResultsList.size(), 10,
                "Count of search result items is wrong.");
        System.out.println(googleSearchResultsList.size());

        for (String searchResult : googleSearchResultsList)
        {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "Searchterm " + searchTerm + " was not found in: \n" + searchResult);
        }
        sleep(2000);


        GoogleSearchResultPage2 googleSearchResultPage2 = googleSearchResultPage1.clickIcon();

        List<String> googleSearchResultsList2 = googleSearchResultPage2.getSearchResults();
        Assert.assertEquals(googleSearchResultsList.size(), 10,
                "Count of search result items is wrong.");
        System.out.println(googleSearchResultsList2.size());

        for (String searchResult : googleSearchResultsList2)
        {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "Searchterm " + searchTerm + " was not found in: \n" + searchResult);
        }
        sleep(2000);


    }
}
