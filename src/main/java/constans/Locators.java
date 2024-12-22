package constans;

import org.openqa.selenium.By;

public class Locators {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    //Главная страница
    public static final By ACCEPT_COOKIE = By.id("rcc-confirm-button");
    //Вопросы о важном:
    //Кнопка аккордеона "Сколько это стоит? И как оплатить?"
    public static final By HOW_MUCH_BUTTON = By.id("accordion__heading-0");
    //Содержимое аккордеона "Сколько это стоит? И как оплатить?"
    public static final By HOW_MUCH_CONTENT = By.xpath(".//div[@id='accordion__panel-0']/p");

    //Кнопка аккордеона "Хочу сразу несколько самокатов! Так можно?"
    public static final By SOME_SCOOTERS_BUTTON = By.id("accordion__heading-1");
    //Содержимое аккордеона "Хочу сразу несколько самокатов! Так можно?"
    public static final By SOME_SCOOTERS_CONTENT = By.xpath(".//div[@id='accordion__panel-1']/p");

    //Кнопка аккордеона "Как рассчитывается время аренды?"
    public static final By RENTAL_TIME_CALCULATION_BUTTON = By.id("accordion__heading-2");
    //Кнопка аккордеона "Как рассчитывается время аренды?"
    public static final By RENTAL_TIME_CALCULATION_CONTENT = By.xpath(".//div[@id='accordion__panel-2']/p");

    //Кнопка аккордеона "Можно ли заказать самокат прямо на сегодня?"
    public static final By ORDER_IN_ONE_DAY_BUTTON = By.id("accordion__heading-3");
    //Кнопка аккордеона "Можно ли заказать самокат прямо на сегодня?"
    public static final By ORDER_IN_ONE_DAY_CONTENT = By.xpath(".//div[@id='accordion__panel-3']/p");

    //Кнопка аккордеона "Можно ли продлить заказ или вернуть самокат раньше?"
    public static final By EXTENSION_OR_REFUND_BUTTON = By.id("accordion__heading-4");
    //Кнопка аккордеона "Можно ли продлить заказ или вернуть самокат раньше?"
    public static final By EXTENSION_OR_REFUND_CONTENT = By.xpath(".//div[@id='accordion__panel-4']/p");

    //Кнопка аккордеона "Вы привозите зарядку вместе с самокатом?"
    public static final By CHARGING_FROM_SCOOTER_BUTTON = By.id("accordion__heading-5");
    //Кнопка аккордеона "Вы привозите зарядку вместе с самокатом?"
    public static final By CHARGING_FROM_SCOOTER_CONTENT = By.xpath(".//div[@id='accordion__panel-5']/p");

    //Кнопка аккордеона "Можно ли отменить заказ?"
    public static final By CANCEL_ORDER_BUTTON = By.id("accordion__heading-6");
    //Содержимое аккордеона "Можно ли отменить заказ?"
    public static final By CANCEL_ORDER_CONTENT = By.xpath(".//div[@id='accordion__panel-6']/p");

    //Кнопка аккордеона "Я жизу за МКАДом, привезёте?"
    public static final By DELIVERY_AREA_BUTTON = By.id("accordion__heading-7");
    //Содержимое аккордеона "Я жизу за МКАДом, привезёте?"
    public static final By DELIVERY_AREA_CONTENT = By.xpath(".//div[@id='accordion__panel-7']/p");

    //Страница заказа
    //Поле "Имя"
    public static final By NAME_FIELD = By.xpath(".//input[@placeholder='* Имя']");
    //Поле "Фамилия"
    public static final By SURNAME_FIELD = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле "Адрес"
    public static final By ADDRESS_FIELD = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле "Станция метро"
    public static final By METRO_STATION_FIELD = By.className("select-search");
    //Станция "Сокольники"
    public static final By SOKOLNIKI_STATION = By.xpath(".//button[@value='4']");
    //Станция "Лубянка"
    public static final By LUBYANKA_STATION = By.xpath(".//button[@value='9']");

    //Поле "Телефон"
    public static final By PHONE_FIELD = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    public static final By NEXT_BUTTON = By.xpath(".//button[text()='Далее']");

    //Выбор даты
    public static final By CALENDAR = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //28.12.2024
    public static final By DATE_28_12_2024 = By.xpath(".//div[@aria-label='Choose суббота, 28-е декабря 2024 г.']");
    //30.12.2024
    public static final By DATE_30_12_2024 = By.xpath(".//div[@aria-label='Choose понедельник, 30-е декабря 2024 г.']");


    //Срок аренды
    public static final By RENTAL_PERIOD = By.className("Dropdown-root");
    //1 день
    public static final By ONE_DAY_RENTAL = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    //4 дня
    public static final By FOUR_DAY_RENTAL = By.xpath(".//div[@class='Dropdown-option' and text()='четверо суток']");

    //Черный цвет самоката
    public static final By BLACK_COLOUR = By.id("black");
    //Серый цвет самоката
    public static final By GREY_COLOUR = By.id("grey");

    //Комментарий
    public static final By COMMENT_FIELD = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Кнопка "Заказать""
    public static final By ORDER_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Кнопка "Да"
    public static final By YES_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    //Окно подтверждающее оформление заказа
    public static final By ORDER_PLACED = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");
}
