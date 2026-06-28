package Api;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BaseApi {
    private static final String BASE_URL = "https://stellarburgers.education-services.ru";

    public Response register(String email, String password, String name) {
        String body = String.format("{\"email\": \"%s\", \"password\": \"%s\", \"name\": \"%s\"}", email, password, name);
        return given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(body)
                .post("/api/auth/register");
    }

    public Response login(String email, String password) {
        String body = String.format("{\"email\": \"%s\", \"password\": \"%s\"}", email, password);
        return given()
                .baseUri(BASE_URL)
                .header("Content-type", "application/json")
                .body(body)
                .post("/api/auth/login");
    }

    public void delete(String accessToken) {
        if (accessToken != null) {
            given()
                    .baseUri(BASE_URL)
                    .header("Authorization", accessToken)
                    .delete("/api/auth/user");
        }
    }
}