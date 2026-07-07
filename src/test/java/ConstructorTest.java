import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import locators.MainPage;
import static org.junit.Assert.assertEquals;

@DisplayName("Раздел Конструктор")
public class ConstructorTest extends BrowsersTest {

    private MainPage mainPage;

    @Before
    public void openPage() {
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    @DisplayName("Переходим к разделу Соусы")
    public void testSauces() {
        mainPage.clickSauces();
        assertEquals("Вкладка Соусы не стала активной", "Соусы", mainPage.getActiveConstructor("Соусы"));
    }

    @Test
    @DisplayName("Переходим к разделу Начинки")
    public void testNachinki() {
        mainPage.clickNachinki();
        assertEquals("Вкладка Начинки не стала активной", "Начинки", mainPage.getActiveConstructor("Начинки"));
    }

    @Test
    @DisplayName("Переходим к разделу Булки")
    public void testBuns() {
        mainPage.clickNachinki();
        mainPage.clickBuns();
        assertEquals("Вкладка Булки не стала активной", "Булки", mainPage.getActiveConstructor("Булки"));
    }
}