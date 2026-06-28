import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BrowsersTest {
    protected WebDriver driver;

    @Before
    public void startBrowser() {
        String browser = System.getProperty("browser", "chrome");
        if ("yandex".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "C:\\YANDEX PRACTICUM\\Projects\\yandexdriver\\yandexdriver.exe");
            driver = new ChromeDriver();
        } else {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void stopBrowser() {
            driver.quit();
    }
}