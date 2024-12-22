package object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constans.Locators.*;

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

    //Получение контента
    public String getContent(By elementContent) {
        return driver.findElement(elementContent).getText();
    }

    public String getAnswer (By elementButton, By elementContent) {
        scrollForElement(elementButton);
        buttonClick(elementButton);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(elementContent));
        return getContent(elementContent);
    }

    public String trueAnswer (String question) {
        String answer = "";
        if (question.equals(getContent(HOW_MUCH_BUTTON))) {
            answer = getAnswer(HOW_MUCH_BUTTON, HOW_MUCH_CONTENT);
        } else if (question.equals(getContent(SOME_SCOOTERS_BUTTON))) {
            answer = getAnswer(SOME_SCOOTERS_BUTTON, SOME_SCOOTERS_CONTENT);
        } else if (question.equals(getContent(RENTAL_TIME_CALCULATION_BUTTON))) {
            answer = getAnswer(RENTAL_TIME_CALCULATION_BUTTON, RENTAL_TIME_CALCULATION_CONTENT);
        } else if (question.equals(getContent(ORDER_IN_ONE_DAY_BUTTON))) {
            answer = getAnswer(ORDER_IN_ONE_DAY_BUTTON, ORDER_IN_ONE_DAY_CONTENT);
        } else if (question.equals(getContent(EXTENSION_OR_REFUND_BUTTON))) {
            answer = getAnswer(EXTENSION_OR_REFUND_BUTTON, EXTENSION_OR_REFUND_CONTENT);
        } else if (question.equals(getContent(CHARGING_FROM_SCOOTER_BUTTON))) {
            answer = getAnswer(CHARGING_FROM_SCOOTER_BUTTON, CHARGING_FROM_SCOOTER_CONTENT);
        } else if (question.equals(getContent(CANCEL_ORDER_BUTTON))) {
            answer = getAnswer(CANCEL_ORDER_BUTTON, CANCEL_ORDER_CONTENT);
        } else if (question.equals(getContent(DELIVERY_AREA_BUTTON))) {
            answer = getAnswer(DELIVERY_AREA_BUTTON, DELIVERY_AREA_CONTENT);
        }
        return answer;
    }
}

