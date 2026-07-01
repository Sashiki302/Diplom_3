package Api;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import SerialData.*;

public class BaseApi {
    private static final String BASE_URL = "https://stellarburgers.education-services.ru";

    @Step ("Регистрируем пользователя")
    public Response register(User user) {
        return given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(user)
                .post("/api/auth/register");
    }
    @Step ("Авторизуем пользователя")
    public Response login(Login login) {
        return given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(login)
                .post("/api/auth/login");
    }
    @Step ("Удаляем созданного пользователя")
    public void delete(String accessToken) {
        if (accessToken != null) {
            given()
                    .baseUri(BASE_URL)
                    .header("Authorization", accessToken)
                    .delete("/api/auth/user");
        }
    }
}