package utilits;

import org.openqa.selenium.WebDriver;

public class BrowserUtilits {
    private WebDriver driver;

    public BrowserUtilits(WebDriver driver) {
        this.driver = driver;
    }

    public void tearDown() {
        driver.quit();
    }


}
