package page;

import org.openqa.selenium.WebDriver;

public abstract class GoogleBasePage
{
    protected WebDriver webDriver;

    public GoogleBasePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }
}
