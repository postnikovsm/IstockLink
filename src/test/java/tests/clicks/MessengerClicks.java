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
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Авторизация в мессенджере", () -> {
            AuthorizationPage authorizationPage = new AuthorizationPage();
            authorizationPage.authorizationPage("istock.link.test@rambler.ru", "123123123");
        });

        // добавить шаг клик по кнопкам табов
        $(".cws-tabs__tab",2).click();
        $(".cws-tabs__tab",1).click();
        $(".cws-tabs__tab",0).click();
        $(".cws-dashboard__left").$(byText("Все контакты")).click();
        $(".open").$(byText("Заблокированные")).click();
       sleep(2000);




    }
}
