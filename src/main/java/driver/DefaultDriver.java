package driver;

import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import com.codeborne.selenide.WebDriverRunner;

import java.util.Objects;

public class DefaultDriver {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    @Step("Создание драйвера")
    public void startBrowser() {
        // Устанавливаем браузер по умолчанию
        String pathToYandexDriver = "src/main/resources/yandexdriver.exe";
        String pathToChromeDriver = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToYandexDriver);  // Установили Yandex браузер
        //Настройки браузера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        // options.addArguments("--headless");
        //Запуск кастомного драйвера
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
    }
}