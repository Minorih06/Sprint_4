package utilits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver openBrowser(String browserName) {
        if (browserName.equals("CHROME")) {
            return new ChromeDriver();
        } else if (browserName.equals("FIREFOX")) {
            return new FirefoxDriver();
        } else {
            throw new RuntimeException("Нераспознанный браузер: " + browserName);
        }
    }
}

