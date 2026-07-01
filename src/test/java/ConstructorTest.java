import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import PagesLocators.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        assertEquals("Вкладка Соусы не стала активной", "Соусы", mainPage.getActiveConstructor());
    }

    @Test
    @DisplayName("Переходим к разделу Начинки")
    public void testNachinki() {
        mainPage.clickNachinki();
        assertEquals("Вкладка Начинки не стала активной", "Начинки", mainPage.getActiveConstructor());
    }

    @Test
    @DisplayName("Переходим к разделу Булки")
    public void testBuns() {
        mainPage.clickNachinki();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[text()='Булки']/parent::div"))).click();
        mainPage.clickBuns();
        assertEquals("Вкладка Булки не стала активной", "Булки", mainPage.getActiveConstructor());
    }
}