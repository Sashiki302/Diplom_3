package locators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
    private final WebDriver driver;
    public static final String URL = "https://stellarburgers.education-services.ru/register";
    private final By nameInput = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordInput = By.xpath(".//input[@type='password']");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By loginLink = By.xpath(".//a[text()='Войти']");
    private final By passwordError = By.xpath(".//p[@class='input__error text_type_main-default']");

    public Register(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открываем страницу регистрации")
    public Register open() {
        driver.get(URL);
        return this;
    }

    @Step("Заполненяем форму регистрации")
    public void registrationForm(String name, String email, String password) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    @Step("Проверка отображения ошибки пароля")
    public boolean passwordError() {
        return driver.findElement(passwordError).isDisplayed();
    }
}