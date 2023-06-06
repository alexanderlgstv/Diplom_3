import clients.Client;
import com.codeborne.selenide.WebDriverRunner;
import driver.DefaultDriver;
import pageobjects.MainPage;
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

import static com.codeborne.selenide.Selenide.open;

public class BasicTest {
    protected static final User user = UserGenerator.getUser();

    UserClient userClient;

    private MainPage mainPage;

    public void setUp() {
        new DefaultDriver().startBrowser();
        mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
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
    }
}