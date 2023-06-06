import pageobjects.SignInPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class UserProfileButtonTest extends BasicTest {

    @Test
    @DisplayName("Провека перехода по клику на «Личный кабинет»")
    public void clickUserProfileButtonTest() {
        open(SignInPage.URL_SIGN_IN_PAGE, SignInPage.class)
                .signInUser(user)
                .clickAccountButtonAfterAuthorization()
                .isUserProfileHeaderExist();
    }
}