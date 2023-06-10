import pageobjects.SignInPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class OpenConstructorFromUserProfilePageTest extends BasicTest {

    @Test
    @DisplayName("Переход из Личного кабинета на главную страницу через кнопку Конструтор")
    public void openConstructorButtonTest() {
        open(SignInPage.URL_SIGN_IN_PAGE, SignInPage.class)
                .signInUser(user)
                .clickAccountButtonAfterAuthorization()
                .clickConstructorButton()
                .isConstructorHeaderExist();
    }

    @Test
    @DisplayName("Переход из Личного кабинета на главную страницу через кнопку Лого")
    public void openLogoPictureTest() {
        open(SignInPage.URL_SIGN_IN_PAGE, SignInPage.class)
                .signInUser(user)
                .clickAccountButtonAfterAuthorization()
                .clickLogoPicture()
                .isConstructorHeaderExist();
    }
}