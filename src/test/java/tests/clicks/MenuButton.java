package tests.clicks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MenuButton {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1400x800";
    }
    @Test
    @Story("Переход по всем разделам")
    @Owner("Олехандро")
    void clickAllButton() {
        step("Авторизация в мессенджере", () -> {
            AuthorizationPage authorizationPage = new AuthorizationPage();
            authorizationPage.authorizationPage("istock.link.test@rambler.ru", "123123123");
        });

        step("Переход по развернутым разделам", () -> {
            $(".snm__sections").$(byText("Задачи")).click();
            $(".breadcrumbs__item").shouldHave(text("Задачи"));
            $(".snm__sections").$(byText("Заявки на закупку")).click();
            $(".breadcrumbs__item").shouldHave(text("Заявки на закупку"));
            $(".snm__sections").$(byText("Моя организация")).click();
            $(".breadcrumbs__item").shouldHave(text("Данные о компании"));
            $(".snm__sections").$(byText("Партнеры")).click();
            $(".breadcrumbs__item").shouldHave(text("Мои партнеры"));
            $(".snm__sections").$(byText("Сотрудники")).click();
            $(".breadcrumbs__item").shouldHave(text("Сотрудники"));
            $(".snm__sections").$(byText("Мой профиль")).click();
            $(".breadcrumbs__item").shouldHave(text("Мой профиль"));
            $(".snm__sections").$(byText("Хранилище файлов")).click();
            $(".breadcrumbs__item").shouldHave(text("Хранилище файлов"));
            $(".snm__sections").$(byText("Мессенджер")).click();
            $(".layout-messenger__header").shouldHave(text("Мессенджер"));
        });

        step("Свернуть меню и переход по разделам", () -> {
            $("div[class='snm-header']").click();

            $(".snm-short-section", 4).click();
            $(".breadcrumbs__item").shouldHave(text("Задачи"));

            $(".snm-short-section", 3).click();
            $(".breadcrumbs__item").shouldHave(text("Заявки на закупку"));

            $(".snm-short-section", 2).click();
            $(".breadcrumbs__item").shouldHave(text("Данные о компании"));

            $(".snm-short-section", 1).click();
            $(".breadcrumbs__item").shouldHave(text("Мой профиль"));

            $(".snm-short-section", 0).click();
            $(".layout-messenger__header").shouldHave(text("Мессенджер"));
        });

        step("Переход по наведению", () -> {
            $(".snm-short-section", 4).hover();
            $(".snm-short-tooltip", 4).click();
            $(".breadcrumbs__item").shouldHave(text("Задачи"));

            $(".snm-short-section", 3).hover();
            $(".snm-short-tooltip", 3).click();
            $(".breadcrumbs__item").shouldHave(text("Заявки на закупку"));

            $(".snm-short-section", 2).hover();
            $(".snm-short-tooltip", 2).$(byText("Моя организация")).click();
            $(".breadcrumbs__item").shouldHave(text("Данные о компании"));
            $(".snm-short-section", 2).hover();
            $(".snm-short-tooltip", 2).$(byText("Партнеры")).click();
            $(".breadcrumbs__item").shouldHave(text("Мои партнеры"));
            $(".snm-short-section", 2).hover();
            $(".snm-short-tooltip", 2).$(byText("Сотрудники")).click();
            $(".breadcrumbs__item").shouldHave(text("Сотрудники"));
        });
            //переход по наведению

//свернуть меню

        $(".snm-short-section", 1).hover();
        $(".snm-short-tooltip", 1).$(byText("Мой профиль")).click();
        $(".breadcrumbs__item").shouldHave(text("Мой профиль"));
        $(".snm-short-section", 1).hover();
        $(".snm-short-tooltip", 1).$(byText("Хранилище файлов")).click();
        $(".breadcrumbs__item").shouldHave(text("Хранилище файлов"));

        $(".snm-short-section", 0).hover();
        $(".snm-short-tooltip", 0).$(byText("Мессенджер")).click();
        $(".layout-messenger__header").shouldHave(text("Мессенджер"));
        // резвернуть меню
        $(".snm-header__arrow").click();
        sleep(2000
        );
    }

        @Test
        @Story("Переход в goodwix")
        @Owner("Олехандро")
        void clickGB(){
            step("Авторизация в мессенджере", () -> {
                AuthorizationPage authorizationPage = new AuthorizationPage();
                authorizationPage.authorizationPage("istock.link.test@rambler.ru", "123123123");
            });

            $(".snm__sections").$(byText("Перейти в Goodwix")).click();
            switchTo().window(1);
            $(".default-left-form").shouldHave(Condition.text("Воспользуйтесь демо-версией," +
                    " чтобы оценить возможности сервиса."));
            switchTo().window(0);
            $("div[class='snm-header']").click();
            $(".snm-short-section",5).click();
            switchTo().window(1);
            $(".default-left-form").shouldHave(Condition.text("Воспользуйтесь демо-версией," +
                   " чтобы оценить возможности сервиса."));
            switchTo().window(0);

        }

    @Test
    void clickTopMenu(){
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.authorizationPage("istock.link.test@rambler.ru", "123123123");

        $(".logo").click();
        //написать строку определение страницы
        switchTo().window(0);
        $(".logo").click();
    }

}
