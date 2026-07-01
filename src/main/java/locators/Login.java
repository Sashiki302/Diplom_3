package locators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private final WebDriver driver;
    public static final String URL = "https://stellarburgers.education-services.ru/login";
    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordInput = By.xpath(".//input[@type='password']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By forgotPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открываем личный кабинет")
    public Login open() {
        driver.get(URL);
        return this;
    }

    @Step("Вводим почту, пароль и нажимаем на кнопку Войти")
    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Нажимаем на кнопку Восстановить пароль")
    public void clickForgotPassword() {
        driver.findElement(forgotPasswordLink).click();
    }
}