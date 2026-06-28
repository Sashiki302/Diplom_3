import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import PagesLocators.MainPage;
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
    public void testSauces() throws InterruptedException {
        mainPage.clickSauces();
        Thread.sleep(1500);
        assertEquals("Вкладка Соусы не стала активной", "Соусы", mainPage.getActiveConstructor());
    }

    @Test
    @DisplayName("Переходим к разделу Начинки")
    public void testNachinki() throws InterruptedException {
        mainPage.clickNachinki();
        Thread.sleep(1500);
        assertEquals("Вкладка Начинки не стала активной", "Начинки", mainPage.getActiveConstructor());
    }

    @Test
    @DisplayName("Переходим к разделу Булки")
    public void testBuns() throws InterruptedException {
        mainPage.clickNachinki();
        Thread.sleep(1500);
        mainPage.clickBuns();
        assertEquals("Вкладка Булки не стала активной", "Булки", mainPage.getActiveConstructor());
    }
}