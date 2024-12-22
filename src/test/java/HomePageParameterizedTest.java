import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import object.page.HomePage;
import utilits.BrowserUtilits;
import utilits.WebDriverFactory;

import static constans.Locators.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class HomePageParameterizedTest {
    private static final String BROWSER_NAME = "CHROME";
    private WebDriver driver;

    private static final String HOW_MUCH_ANSWER_EXPECTED = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String SOME_SCOOTERS_ANSWER_EXPECTED = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String RENTAL_TIME_CALCULATION_ANSWER_EXPECTED  = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String ORDER_IN_ONE_DAY_ANSWER_EXPECTED = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String EXTENSION_OR_REFUND_ANSWER_EXPECTED = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String CHARGING_FROM_SCOOTER_ANSWER_EXPECTED = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String CANCEL_ORDER_ANSWER_EXPECTED = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String DELIVERY_AREA_ANSWER_EXPECTED = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private String question;
    private String answer;

    public HomePageParameterizedTest(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getContents() {
        return new Object[][] {
                {"Сколько это стоит? И как оплатить?", HOW_MUCH_ANSWER_EXPECTED},
                {"Хочу сразу несколько самокатов! Так можно?", SOME_SCOOTERS_ANSWER_EXPECTED},
                {"Как рассчитывается время аренды?", RENTAL_TIME_CALCULATION_ANSWER_EXPECTED},
                {"Можно ли заказать самокат прямо на сегодня?", ORDER_IN_ONE_DAY_ANSWER_EXPECTED},
                {"Можно ли продлить заказ или вернуть самокат раньше?", EXTENSION_OR_REFUND_ANSWER_EXPECTED},
                {"Вы привозите зарядку вместе с самокатом?", CHARGING_FROM_SCOOTER_ANSWER_EXPECTED},
                {"Можно ли отменить заказ?", CANCEL_ORDER_ANSWER_EXPECTED},
                {"Я жизу за МКАДом, привезёте?", DELIVERY_AREA_ANSWER_EXPECTED}
        };
    }

    @Before
    public void before() {
        driver = WebDriverFactory.openBrowser(BROWSER_NAME);
        driver.manage().window().maximize();
    }

    @Test
    public void matchesTheContentAccordion() {
        driver.get(URL);
        HomePage objectHomePage = new HomePage(driver);
        objectHomePage.buttonClick(ACCEPT_COOKIE);
        assertEquals(answer, objectHomePage.trueAnswer(question));
    }

    @After
    public void after() {
        BrowserUtilits closeBrowser = new BrowserUtilits(driver);
        closeBrowser.tearDown();
    }
}

