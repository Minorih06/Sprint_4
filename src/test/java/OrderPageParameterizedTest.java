import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.OrderPage;

import static constans.Locators.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderPageParameterizedTest {
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
    private String variantButton;

    public OrderPageParameterizedTest(String name, String surname, String address, By station, String phone, By date, By rentalPeriod, By colour, String comment, String variantButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.phone = phone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.colour = colour;
        this.comment = comment;
        this.variantButton = variantButton;
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
        driver = new ChromeDriver();
    }

    @Test
    public void validationOrderTest() {
        driver.get(URL);
        OrderPage objectOrderPage = new OrderPage(driver);
        objectOrderPage.clickButton(By.id("rcc-confirm-button"));
        By orderButton = null;
        if (variantButton.equals("Верхняя")) {
            orderButton = TOP_ORDER_BUTTON;
        } else if (variantButton.equals("Нижняя")) {
            objectOrderPage.scrollForElement(BOTTOM_ORDER_BUTTON);
            orderButton = BOTTOM_ORDER_BUTTON;
        }
        objectOrderPage.clickButton(orderButton);
        objectOrderPage.order(name, surname, address, station, phone, date, rentalPeriod, colour, comment);
        assertEquals(true, driver.findElement(ORDER_PLACED).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
