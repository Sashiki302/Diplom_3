package PagesLocators;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    private final WebDriver driver;
    private final By loginLink = By.xpath(".//a[text()='Войти']");

    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаем на кнопку Войти на странице восстановления пароля")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}