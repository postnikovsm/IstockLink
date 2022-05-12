package tests.clicks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class MessengerClicks {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1400x800";
    }
    @Test
    @Story("Переход по всем разделам")
    @Owner("Олехандро")

    void clickMessengerButton() {




    }
}
