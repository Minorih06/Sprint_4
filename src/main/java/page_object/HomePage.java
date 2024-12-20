package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Scroll
    public void scrollForElement(By element) {
        WebElement newElement = driver.findElement(element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newElement);
    }

    //Клик по кнопке
    public void buttonClick(By elementButton) {
        driver.findElement(elementButton).click();
    }

    //Получение контента компонента аккордеона
    public String getContent(By elementContent) {
        return driver.findElement(elementContent).getText();
    }

    //Шаг
    public String text (By elementButton, By elementContent) {
        scrollForElement(elementButton);
        buttonClick(elementButton);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(elementContent));
        return getContent(elementContent);
    }
}

