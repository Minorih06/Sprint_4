package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import static constans.Locators.*;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Ввод
    public void input (By element, String value) {
        driver.findElement(element).sendKeys(value);
    }

    //Клик
    public void clickButton (By element) {
        driver.findElement(element).click();
    }

    //Scroll
    public void scrollForElement(By element) {
        WebElement newElement = driver.findElement(element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", newElement);
    }

    //Выбор из списка
    public void selectFromList (By list, By element) {
        clickButton(list);
        clickButton(element);
    }

    public void order(String name, String surname, String address, By station, String phone, By date, By rentalPeriod, By colour, String comment) {
        input(NAME_FIELD, name);
        input(SURNAME_FIELD, surname);
        input(ADDRESS_FIELD, address);
        selectFromList(METRO_STATION_FIELD, station);
        input(PHONE_FIELD, phone);
        clickButton(NEXT_BUTTON);
        scrollForElement(By.className("Order_Header__BZXOb"));
        selectFromList(CALENDAR, date);
        selectFromList(RENTAL_PERIOD, rentalPeriod);
        clickButton(colour);
        input(COMMENT, comment);
        clickButton(ORDER_BUTTON);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(YES_BUTTON));
        clickButton(YES_BUTTON);
    }

}
