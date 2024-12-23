import object.page.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import object.page.OrderPage;
import utilits.BrowserUtilits;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderPageParameterizedTest {
    private static final String BROWSER_NAME = "CHROME";
    private BrowserUtilits browserUtilits;
    private WebDriver driver;

    private String name;
    private String surname;
    private String address;
    private String station;
    private String phone;
    private String date;
    private int rentalPeriod;
    private String colour;
    private String comment;
    private String positionButton;

    public OrderPageParameterizedTest(String name, String surname, String address, String station, String phone, String date, int rentalPeriod, String colour, String comment, String positionButton) {
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
                {"Филип", "Киркоров", "Москва, Рублёвка, д. 35", "Сокольники", "88005553535", "28.12.2024", 4, "Чёрный", "Хотелось бы со стразами", "Верхняя"},
                {"Николай", "Басков", "Москва, Рублёвка, д. 100", "Лубянка", "89005750565", "30.12.2024", 1, "Серый", "Главное не как у Киркорова", "Нижняя"}
        };
    }

    @Before
    public void before() {
        browserUtilits = new BrowserUtilits(BROWSER_NAME);
        driver = browserUtilits.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void validationOrderTest() {
        driver.get(browserUtilits.getURL());
        OrderPage objectOrderPage = new OrderPage(driver);
        HomePage objectHomePage = new HomePage(driver);
        objectOrderPage.clickButton(objectHomePage.getACCEPT_COOKIE());
        objectOrderPage.selectButton(positionButton);
        objectOrderPage.order(name, surname, address, station, phone, date, rentalPeriod, colour, comment);
        assertEquals(true, driver.findElement(objectOrderPage.getOrderPlaced()).isDisplayed());
    }

    @After
    public void tearDown() {
        browserUtilits.tearDown();
    }
}
