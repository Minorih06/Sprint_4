package object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constans.Locators.*;

public class OrderPage {
    private WebDriver driver;

    //Верхняя кнопка "Заказать"
    private static final By TOP_ORDER_BUTTON = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Нижняя кнопка "Заказать"
    private static final By BOTTOM_ORDER_BUTTON = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Ввод
    public void input(By element, String value) {
        driver.findElement(element).sendKeys(value);
    }

    public void nameInput(String name) {
        input(NAME_FIELD, name);
    }

    public void surnameInput(String surname) {
        input(SURNAME_FIELD, surname);
    }

    public void addressInput(String address) {
        input(ADDRESS_FIELD, address);
    }

    public void phoneInput(String phone) {
        input(PHONE_FIELD, phone);
    }

    public void commentInput(String comment) {
        input(COMMENT_FIELD, comment);
    }

    //Выбор кнопки "Заказать"
    public void selectButton(String positionButton) {
        By orderButton = null;
        if (positionButton.equals("Верхняя")) {
            orderButton = TOP_ORDER_BUTTON;
        } else if (positionButton.equals("Нижняя")) {
            scrollForElement(BOTTOM_ORDER_BUTTON);
            orderButton = BOTTOM_ORDER_BUTTON;
        }
        clickButton(orderButton);
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
        nameInput(name);
        surnameInput(surname);
        addressInput(address);
        selectFromList(METRO_STATION_FIELD, station);
        phoneInput(phone);
        clickButton(NEXT_BUTTON);
        scrollForElement(By.className("Order_Header__BZXOb"));
        selectFromList(CALENDAR, date);
        selectFromList(RENTAL_PERIOD, rentalPeriod);
        clickButton(colour);
        commentInput(comment);
        clickButton(ORDER_BUTTON);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(YES_BUTTON));
        clickButton(YES_BUTTON);
    }

}
