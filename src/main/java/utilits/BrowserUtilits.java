package utilits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtilits {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    private WebDriver driver;

    public BrowserUtilits(String browserName) {
        this.driver = openBrowser(browserName);
    }

    private WebDriver openBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("CHROME")) {
            return new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("FIREFOX")) {
            return new FirefoxDriver();
        } else {
            throw new RuntimeException("Нераспознанный браузер: " + browserName);
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public String getURL() {
        return URL;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
