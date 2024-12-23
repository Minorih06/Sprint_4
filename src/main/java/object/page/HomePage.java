package object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    //Верхняя кнопка "Заказать"
    private static final By TOP_ORDER_BUTTON = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Нижняя кнопка "Заказать"
    private static final By BOTTOM_ORDER_BUTTON = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    //Вопросы о важном:
    //Кнопка аккордеона "Сколько это стоит? И как оплатить?"
    private static final By HOW_MUCH_BUTTON = By.id("accordion__heading-0");
    //Содержимое аккордеона "Сколько это стоит? И как оплатить?"
    private static final By HOW_MUCH_CONTENT = By.xpath(".//div[@id='accordion__panel-0']/p");

    //Кнопка аккордеона "Хочу сразу несколько самокатов! Так можно?"
    private static final By SOME_SCOOTERS_BUTTON = By.id("accordion__heading-1");
    //Содержимое аккордеона "Хочу сразу несколько самокатов! Так можно?"
    private static final By SOME_SCOOTERS_CONTENT = By.xpath(".//div[@id='accordion__panel-1']/p");

    //Кнопка аккордеона "Как рассчитывается время аренды?"
    private static final By RENTAL_TIME_CALCULATION_BUTTON = By.id("accordion__heading-2");
    //Кнопка аккордеона "Как рассчитывается время аренды?"
    private static final By RENTAL_TIME_CALCULATION_CONTENT = By.xpath(".//div[@id='accordion__panel-2']/p");

    //Кнопка аккордеона "Можно ли заказать самокат прямо на сегодня?"
    private static final By ORDER_IN_ONE_DAY_BUTTON = By.id("accordion__heading-3");
    //Кнопка аккордеона "Можно ли заказать самокат прямо на сегодня?"
    private static final By ORDER_IN_ONE_DAY_CONTENT = By.xpath(".//div[@id='accordion__panel-3']/p");

    //Кнопка аккордеона "Можно ли продлить заказ или вернуть самокат раньше?"
    private static final By EXTENSION_OR_REFUND_BUTTON = By.id("accordion__heading-4");
    //Кнопка аккордеона "Можно ли продлить заказ или вернуть самокат раньше?"
    private static final By EXTENSION_OR_REFUND_CONTENT = By.xpath(".//div[@id='accordion__panel-4']/p");

    //Кнопка аккордеона "Вы привозите зарядку вместе с самокатом?"
    private static final By CHARGING_FROM_SCOOTER_BUTTON = By.id("accordion__heading-5");
    //Кнопка аккордеона "Вы привозите зарядку вместе с самокатом?"
    private static final By CHARGING_FROM_SCOOTER_CONTENT = By.xpath(".//div[@id='accordion__panel-5']/p");

    //Кнопка аккордеона "Можно ли отменить заказ?"
    private static final By CANCEL_ORDER_BUTTON = By.id("accordion__heading-6");
    //Содержимое аккордеона "Можно ли отменить заказ?"
    private static final By CANCEL_ORDER_CONTENT = By.xpath(".//div[@id='accordion__panel-6']/p");

    //Кнопка аккордеона "Я жизу за МКАДом, привезёте?"
    private static final By DELIVERY_AREA_BUTTON = By.id("accordion__heading-7");
    //Содержимое аккордеона "Я жизу за МКАДом, привезёте?"
    private static final By DELIVERY_AREA_CONTENT = By.xpath(".//div[@id='accordion__panel-7']/p");

    //Кнопка "Принять Cookie"
    private static final By ACCEPT_COOKIE = By.id("rcc-confirm-button");

    private WebDriver driver;

    public By getTOP_ORDER_BUTTON() {
        return TOP_ORDER_BUTTON;
    }

    public By getBOTTOM_ORDER_BUTTON() {
        return BOTTOM_ORDER_BUTTON;
    }

    public By getACCEPT_COOKIE() {
        return ACCEPT_COOKIE;
    }

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

