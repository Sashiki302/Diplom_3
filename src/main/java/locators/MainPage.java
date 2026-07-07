package locators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    public static final String URL = "https://stellarburgers.education-services.ru/";
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By bunsTab = By.xpath(".//span[text()='Булки']/parent::div");
    private final By saucesTab = By.xpath(".//span[text()='Соусы']/parent::div");
    private final By nachinkiTab = By.xpath(".//span[text()='Начинки']/parent::div");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открываем главную страницу")
    public MainPage open() {
        driver.get(URL);
        return this;
    }

    @Step("Нажимаем на кнопку Войти в аккаунт")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажимаем на кнопку Личный Кабинет")
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    @Step("Проверка отображения кнопки Оформить заказ")
    public boolean orderButtonDisplayed() {
        return driver.findElement(createOrderButton).isDisplayed();
    }

    @Step("Переходим к разделу Булки")
    public void clickBuns() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(bunsTab)).click();
    }

    @Step("Переходим к разделу Соусы")
    public void clickSauces() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(saucesTab)).click();
    }

    @Step("Переходим к разделу Начинки")
    public void clickNachinki() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(nachinkiTab)).click();
    }

    @Step("Получаем название активной вкладки конструктора с ожиданием")
    public String getActiveConstructor(String waitText) {
        By activeWait = By.xpath("//span[contains(text(), '" + waitText + "')]");
        return driver.findElement(activeWait).getText();
    }
}