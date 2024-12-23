package object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private WebDriver driver;

    //Страница заказа
    //Поле "Имя"
    private static final By NAME_FIELD = By.xpath(".//input[@placeholder='* Имя']");
    //Поле "Фамилия"
    private static final By SURNAME_FIELD = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле "Адрес"
    private static final By ADDRESS_FIELD = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле "Станция метро"
    private static final By METRO_STATION_FIELD = By.className("select-search");
    //Станция "Сокольники"
    private static final By SOKOLNIKI_STATION = By.xpath(".//button[@value='4']");
    //Станция "Лубянка"
    private static final By LUBYANKA_STATION = By.xpath(".//button[@value='9']");

    //Поле "Телефон"
    private static final By PHONE_FIELD = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private static final By NEXT_BUTTON = By.xpath(".//button[text()='Далее']");

    //Выбор даты
    private static final By CALENDAR = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //28.12.2024
    private static final By DATE_28_12_2024 = By.xpath(".//div[@aria-label='Choose суббота, 28-е декабря 2024 г.']");
    //30.12.2024
    private static final By DATE_30_12_2024 = By.xpath(".//div[@aria-label='Choose понедельник, 30-е декабря 2024 г.']");


    //Срок аренды
    private static final By RENTAL_PERIOD = By.className("Dropdown-root");
    //1 день
    private static final By ONE_DAY_RENTAL = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    //4 дня
    private static final By FOUR_DAY_RENTAL = By.xpath(".//div[@class='Dropdown-option' and text()='четверо суток']");

    //Черный цвет самоката
    private static final By BLACK_COLOUR = By.id("black");
    //Серый цвет самоката
    private static final By GREY_COLOUR = By.id("grey");

    //Комментарий
    private static final By COMMENT_FIELD = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Кнопка "Заказать""
    private static final By ORDER_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Кнопка "Да"
    private static final By YES_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    //Окно подтверждающее оформление заказа
    private static final By ORDER_PLACED = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    public By getOrderPlaced() {
        return ORDER_PLACED;
    }

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

    public void stationSelect(String station) {
        if (station.equals("Сокольники")) {
            selectFromList(METRO_STATION_FIELD, SOKOLNIKI_STATION);
        } else if (station.equals("Лубянка")) {
            selectFromList(METRO_STATION_FIELD, LUBYANKA_STATION);
        }
    }

    public void phoneInput(String phone) {
        input(PHONE_FIELD, phone);
    }

    public void dateSelect(String date) {
        if (date.equals("28.12.2024")) {
            selectFromList(CALENDAR, DATE_28_12_2024);
        } else if (date.equals("30.12.2024")) {
            selectFromList(CALENDAR, DATE_30_12_2024);
        }
    }

    public void rentalPeriodSelect(int rentalPeriod) {
        if (rentalPeriod == 1) {
            selectFromList(RENTAL_PERIOD, ONE_DAY_RENTAL);
        } else if (rentalPeriod == 4) {
            selectFromList(RENTAL_PERIOD, FOUR_DAY_RENTAL);
        }
    }

    public void colourSelect(String colour) {
        if (colour.equals("Чёрный")) {
            clickButton(BLACK_COLOUR);
        } else if (colour.equals("Серый")) {
            clickButton(GREY_COLOUR);
        }
    }

    public void commentInput(String comment) {
        input(COMMENT_FIELD, comment);
    }

    //Выбор кнопки "Заказать"
    public void selectButton(String positionButton) {
        HomePage objectHomePage = new HomePage(driver);
        By orderButton = null;
        if (positionButton.equals("Верхняя")) {
            orderButton = objectHomePage.getTOP_ORDER_BUTTON();
        } else if (positionButton.equals("Нижняя")) {
            scrollForElement(objectHomePage.getBOTTOM_ORDER_BUTTON());
            orderButton = objectHomePage.getBOTTOM_ORDER_BUTTON();
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

    public void order(String name, String surname, String address, String station, String phone, String date, int rentalPeriod, String colour, String comment) {
        nameInput(name);
        surnameInput(surname);
        addressInput(address);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(METRO_STATION_FIELD));
        stationSelect(station);
        phoneInput(phone);
        clickButton(NEXT_BUTTON);
        scrollForElement(By.className("Order_Header__BZXOb"));
        dateSelect(date);
        rentalPeriodSelect(rentalPeriod);
        colourSelect(colour);
        commentInput(comment);
        clickButton(ORDER_BUTTON);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(YES_BUTTON));
        clickButton(YES_BUTTON);
    }

}
