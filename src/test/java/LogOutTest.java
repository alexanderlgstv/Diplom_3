import pageobjects.SignInPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LogOutTest extends BasicTest {

    @Test
    @DisplayName("Выход из личного кабинета через кнопку Выйти")
    public void logoutUserProfileButtonTest(){
        open(SignInPage.URL_SIGN_IN_PAGE, SignInPage.class)
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickSignInButton()
                .clickAccountButtonAfterAuthorization()
                .clickLogOutButton()
                .isEnterButtonExist();
    }
}