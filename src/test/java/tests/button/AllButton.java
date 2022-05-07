package tests.button;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AllButton {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1400x800";
    }
    @Test
    void clickAllButton(){
        open("https://messenger.test.istock.link/login");
        $("input[name='email']").setValue("istock.link.test@rambler.ru");
        $("input[name='password']").setValue("123123123");
        $("button[name='loginUserButton']").click();
        $(".layout-messenger").shouldHave(text("Мессенджер"));
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
//свернуть меню
        $("div[class='snm-header']").click();

        $("svg[xmlns=\"http://www.w3.org/2000/svg\"]").click();
        $(".breadcrumbs__item").shouldHave(text("Задачи"));
        $("li[class='snm__icon'][herf='/requests/all']").click();
        $(".breadcrumbs__item").shouldHave(text("Заявки на закупку"));
        $("li[class='snm__icon'][herf='/company/edit']").click();
        $(".breadcrumbs__item").shouldHave(text("Данные о компании"));
        $("li[class='snm__icon'][herf='/requests/all']").click();
        $(".breadcrumbs__item").shouldHave(text("Мои партнеры"));
        $(".snm__sections").$(byText("Сотрудники")).click();
        $(".breadcrumbs__item").shouldHave(text("Сотрудники"));
        $(".snm__sections").$(byText("Мой профиль")).click();
        $(".breadcrumbs__item").shouldHave(text("Мой профиль"));
        $(".snm__sections").$(byText("Хранилище файлов")).click();
        $(".breadcrumbs__item").shouldHave(text("Хранилище файлов"));
        $(".snm__sections").$(byText("Мессенджер")).click();
        $(".layout-messenger__header").shouldHave(text("Мессенджер"));

    }
}
