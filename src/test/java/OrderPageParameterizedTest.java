import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import object.page.OrderPage;
import utilits.BrowserUtilits;
import utilits.WebDriverFactory;

import static constans.Locators.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderPageParameterizedTest {
    private static final String BROWSER_NAME = "CHROME";
    private WebDriver driver;

    private String name;
    private String surname;
    private String address;
    private By station;
    private String phone;
    private By date;
    private By rentalPeriod;
    private By colour;
    private String comment;
    private String positionButton;

    public OrderPageParameterizedTest(String name, String surname, String address, By station, String phone, By date, By rentalPeriod, By colour, String comment, String positionButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.phone = phone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.colour = colour;
        this.comment = comment;
        this.positionButton = positionButton;
    }

    @Parameterized.Parameters
    public static Object[][] getContents() {
        return new Object[][] {
                {"Филип", "Киркоров", "Москва, Рублёвка, д. 35", SOKOLNIKI_STATION, "88005553535", DATE_28_12_2024, FOUR_DAY_RENTAL, BLACK_COLOUR, "Хотелось бы со стразами", "Верхняя"},
                {"Николай", "Басков", "Москва, Рублёвка, д. 100", LUBYANKA_STATION, "89005750565", DATE_30_12_2024, ONE_DAY_RENTAL, GREY_COLOUR, "Главное не как у Киркорова", "Нижняя"}
        };
    }

    @Before
    public void before() {
        driver = WebDriverFactory.openBrowser(BROWSER_NAME);
        driver.manage().window().maximize();
    }

    @Test
    public void validationOrderTest() {
        driver.get(URL);
        OrderPage objectOrderPage = new OrderPage(driver);
        objectOrderPage.clickButton(ACCEPT_COOKIE);
        objectOrderPage.selectButton(positionButton);
        objectOrderPage.order(name, surname, address, station, phone, date, rentalPeriod, colour, comment);
        assertEquals(true, driver.findElement(ORDER_PLACED).isDisplayed());
    }

    @After
    public void tearDown() {
        BrowserUtilits closeBrowser = new BrowserUtilits(driver);
        closeBrowser.tearDown();
    }
}
