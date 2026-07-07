import data.Login;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import api.BaseApi;
import locators.Register;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

@DisplayName("Регистрация пользователя")
public class RegisterTest extends BrowsersTest {

    private BaseApi apiClient;
    private String email;
    private String password;
    private String name;

    @Before
    public void newData() {
        apiClient = new BaseApi();
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        name = faker.name().firstName();
    }

    @After
    public void cleanUp() {
        if (password != null) {
            Response loginResponse = apiClient.login(new Login(email, password));
            String accessToken = loginResponse.path("accessToken");
            apiClient.delete(accessToken);
        }
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверяем, что пользователь создался с валидными данными")
    public void trueRegistration() {
        password = "ololo123";
        Register registerPage = new Register(driver);
        registerPage.open();
        registerPage.registrationForm(name, email, password);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("/login"));
        assertTrue("Переход на страницу логина не произошел", driver.getCurrentUrl().contains("/login"));
    }

    @Test
    @DisplayName("Ошибка регистрации: некорректный пароль")
    @Description("Проверяем появления ошибки при вводе пароля менее 6 символов")
    public void shortPassword() {
        Register registerPage = new Register(driver);
        registerPage.open();
        registerPage.registrationForm(name, email, "1234");
        assertTrue("Нет сообщения об ошибке пароля", registerPage.passwordError());
    }
}