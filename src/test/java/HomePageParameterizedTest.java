import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.HomePage;

import static constans.Locators.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class HomePageParameterizedTest {
    private WebDriver driver;
    private static final String EXPEXTED_TEXT_1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String EXPEXTED_TEXT_2 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

    private String textContent;
    private By elementButton;
    private By elementContent;

    public HomePageParameterizedTest(String textContent, By elementButton, By elementContent) {
        this.textContent = textContent;
        this.elementButton = elementButton;
        this.elementContent = elementContent;
    }

    @Parameterized.Parameters
    public static Object[][] getContents() {
        return new Object[][] {
                {EXPEXTED_TEXT_1, HOW_MUCHDES_IT_COST_BUTTON, HOW_MUCHDES_IT_COST_CONTENT},
                {EXPEXTED_TEXT_2, POSSIBILITY_OF_ORDER_CANCEL_BUTTON, POSSIBILITY_OF_ORDER_CANCEL_CONTENT}
        };
    }

    @Before
    public void before() {
        driver = new ChromeDriver();
    }

    @Test
    public void matchesTheContentAccordion() {
        driver.get(URL);
        HomePage objectHomePage = new HomePage(driver);
        assertEquals(textContent, objectHomePage.text(elementButton, elementContent));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
