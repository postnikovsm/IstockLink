package tests.clicks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MenuButton {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1400x800";
    }
    @Test
    void clickAllButton() {
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
//переход по свернутым разделам
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

        //переход по наведению
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
        void clickGB(){
            open("https://messenger.test.istock.link/login");
            $("input[name='email']").setValue("istock.link.test@rambler.ru");
            $("input[name='password']").setValue("123123123");
            $("button[name='loginUserButton']").click();
            $(".layout-messenger").shouldHave(text("Мессенджер"));

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
            sleep(2000);

        }

    @Test
    void clickTopMenu(){
        open("https://messenger.test.istock.link/login");
        $("input[name='email']").setValue("istock.link.test@rambler.ru");
        $("input[name='password']").setValue("123123123");
        $("button[name='loginUserButton']").click();
        $(".layout-messenger").shouldHave(text("Мессенджер"));

        $(".logo").click();
        //написать строку определение страницы
        switchTo().window(0);
        $(".logo").click();


    }

}
