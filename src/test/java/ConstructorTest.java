import pageobjects.MainPage;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import static com.codeborne.selenide.Selenide.open;


public class ConstructorTest extends BasicTest {

    @Test
    @DisplayName("Переход к разделу Булки")
    public void clickBunsSectionButtonTest() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickSaucesButton()
                .clickBunsButton()
                .isBunsHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void clickSaucesSectionButtonTest() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickSaucesButton()
                .isSaucesHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void clickFillingsSectionButtonTest() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .clickFillingsButton()
                .isFillingsHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Скролл к разделу Булки")
    public void scrollBunsSectionTest() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .scrollToBunsHeader()
                .isBunsHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Скролл к разделу Соусы")
    public void scrollSaucesSectionTest() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .scrollToSaucesHeader()
                .isSaucesHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Скролл к разделу Начинки")
    public void scrollFillingsSectionTest() {
        open(MainPage.MAIN_PAGE_URL, MainPage.class)
                .scrollToFillingsHeader()
                .isFillingsHeaderIsDisplayed();
    }
}