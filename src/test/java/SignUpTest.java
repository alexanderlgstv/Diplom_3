import generator.UserGenerator;
import clients.UserClient;
import models.Credentials;
import pageobjects.MainPage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;

public class SignUpTest{
    private UserClient userClient;

    protected String name = UserGenerator.getUser().getName();
    protected String email = UserGenerator.getUser().getEmail();
    protected String password = UserGenerator.getUser().getPassword();
    protected String incorrectPassword = "abcd";

    @Test
    @DisplayName("Создание нового пользователя - валидные данные")
    public void userSignUpValidDataTest() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickEnterAccountButton()
                .clickSignUpButton()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickConfirmSignUpButton()
                .SignUpUser(email, password);


        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        assertEquals( "https://stellarburgers.nomoreparties.site/login", currentUrl);
    }

    @Test
    @DisplayName("Создание нового пользователя - некорректный пароль")
    public void userSignUpInValidDataTest() {
        boolean inValidDataRegister = open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickEnterAccountButton()
                .clickSignUpButton()
                .setName(name)
                .setEmail(email)
                .setPassword(incorrectPassword)
                .clickConfirmSignUpButton()
                .errorMessageGetText()
                .clickEnterLinkButton()
                .SignUpUser(email, incorrectPassword)
                .isErrorMessageExist();
        assertTrue(inValidDataRegister);
    }

    @After
    public void tearDown(){
        userClient = new UserClient();
        Credentials credentials = new Credentials(email, password);
        Response response = userClient.login(credentials);
        if (response.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(response);
        }

        Credentials userInValidCredentials = new Credentials(email, incorrectPassword);
        Response inValidResponse = userClient.login(userInValidCredentials);
        if (inValidResponse.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(inValidResponse);
        }
    }
}