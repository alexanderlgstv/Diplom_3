import com.codeborne.selenide.WebDriverRunner;
import models.User;
import clients.UserClient;
import models.Credentials;
import generator.UserGenerator;
import io.restassured.response.Response;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasicTest {
    protected static final User user = UserGenerator.getUser();

    private static final String URL = "https://stellarburgers.nomoreparties.site/";

    public UserClient userClient;

    public WebDriver driver;

    private WebDriver getDriver(String browserName) {
        if ("chrome".equals(browserName)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*", "start-maximized");
            return driver = new ChromeDriver(options);
        } else if ("yandex".equals(browserName)) {
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", "C:\\cygwin64\\home\\lgstv\\Diplom\\Diplom_3\\src\\main\\resources\\yandexdriver.exe");
            options.setBinary("C:\\Users\\lgstv\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            options.addArguments("--remote-allow-origins=*", "start-maximized");
            return driver = new ChromeDriver(options);
        } else {
            throw new IllegalArgumentException("Тестирование в данном браузере невозможно");
        }
    }

    public void setUp() {
        driver = getDriver("chrome");   //запуск в выбранном браузере
        driver.get(URL);
    }

    @Before
    public void init() {
        setUp();
        userClient = new UserClient();
        userClient.createUser(user);
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Credentials credentials = new Credentials(user.getEmail(), user.getPassword());
        Response response = userClient.login(credentials);
        if (response.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(response);
        }
        driver.quit();
    }
}