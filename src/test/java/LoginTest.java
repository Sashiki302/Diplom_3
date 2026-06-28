import Api.BaseApi;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import PagesLocators.*;
import static org.junit.Assert.assertTrue;

@DisplayName("Вход пользователя")
public class LoginTest extends BrowsersTest {

    private BaseApi apiUser;
    private String email;
    private String password;
    private String accessToken;

    @Before
    public void newUser() {
        apiUser = new BaseApi();
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        password = faker.internet().password(6, 12);

        Response response = apiUser.register(email, password, faker.name().firstName());
        accessToken = response.path("accessToken");
    }

    @After
    public void cleanUp() {
        apiUser.delete(accessToken);
    }

    @Test
    @DisplayName("Входим по кнопке Войти в аккаунт на главной странице")
    public void testLoginMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open().clickLoginButton();
        new Login(driver).login(email, password);
        assertTrue("Пользователь не авторизован", mainPage.orderButtonDisplayed());
    }

    @Test
    @DisplayName("Входим через кнопку Личный кабинет")
    public void testLoginAccountButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open().clickAccountButton();
        new Login(driver).login(email, password);
        assertTrue("Пользователь не авторизован", mainPage.orderButtonDisplayed());
    }

    @Test
    @DisplayName("Входим через кнопку в форме регистрации")
    public void testLoginRegisterPage() {
        Register registerPage = new Register(driver);
        registerPage.open().clickLoginLink();
        new Login(driver).login(email, password);
        assertTrue("Пользователь не авторизован", new MainPage(driver).orderButtonDisplayed());
    }

    @Test
    @DisplayName("Входим через кнопку в форме восстановления пароля")
    public void testLoginForgotPage() {
        Login loginPage = new Login(driver);
        loginPage.open().clickForgotPassword();
        new ForgotPassword(driver).clickLoginLink();
        loginPage.login(email, password);
        assertTrue("Пользователь не авторизован", new MainPage(driver).orderButtonDisplayed());
    }
}