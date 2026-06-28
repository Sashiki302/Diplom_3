package PagesLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;
    public static final String URL = "https://stellarburgers.education-services.ru/";
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By bunsTab = By.xpath(".//span[text()='Булки']/parent::div");
    private final By saucesTab = By.xpath(".//span[text()='Соусы']/parent::div");
    private final By nachinkiTab = By.xpath(".//span[text()='Начинки']/parent::div");
    private final By activeTab = By.xpath(".//div[contains(@class, 'tab_type_current')]//span");

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
        driver.findElement(bunsTab).click();
    }

    @Step("Переходим к разделу Соусы")
    public void clickSauces() {
        driver.findElement(saucesTab).click();
    }

    @Step("Переходим к разделу Начинки")
    public void clickNachinki() {
        driver.findElement(nachinkiTab).click();
    }

    @Step("Получаем название активной вкладки конструктора")
    public String getActiveConstructor() {
        return driver.findElement(activeTab).getText();
    }
}