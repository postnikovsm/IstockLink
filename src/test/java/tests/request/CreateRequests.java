package tests.request;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.AuthorizationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CreateRequests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @Owner("Сантьяго")
    void createRequestsWithFillForm() {
        step("Авторизация в мессенджере и переход в заявки на закупку", () -> {
            AuthorizationPage authorizationPage = new AuthorizationPage();
            authorizationPage.authorizationPage("istock.link.test@rambler.ru", "123123123");
            $(".snm__sections").$(byText("Заявки на закупку")).click();
        });

        step("Выбор новой заявки и запись номера заявки и наименования", () -> {
            $(".breadcrumbs-buttons").click();
            $$("#title-form").findBy(text("Номер заявки"))
                    .sibling(0).$("#title", 1).setValue("11111111");

            $$("#title-form").findBy(text("Наименование заявки "))
                    .sibling(1).$("#title").setValue("11111111");
        });

        step("Выбор категории", () -> {
            $(".category-select").setValue("Автоматизированные").pressEnter();
        });

        step("Выбор в календаре следующий день", () -> {
            $$(".control-label-row").findBy(text("Срок поставки "))
                    .sibling(0).$(".input-group").click();
            $$("td:not(.text-muted)").first().click();
        });

        step("Выбор региона и города", () -> {
            $("#region-select").setValue("Хабаровский край").pressEnter();
            $$(".control-label-row").findBy(text("Требования к поставщику")).click(); //костыли
            $("#city-select").setValue("Комсомольск-на-Амуре").pressEnter();
            $$(".control-label-row").findBy(text("Город ")).click(); //костыли
        });

        step("Заполнение таблицы", () -> {
            $(".btn-default").click();
            $(byId("0pr-name")).setValue("ffff");
            $(".input-number-bootstrap").setValue("111");
            $(".product-table-number", 1).click();
            $(".product-table-number", 1).$("input[type='number']").setValue("2");
        });

        step("Заполнение содержания заявки", () -> {
            $$(".btn-default").findBy(text("Содержание заявки")).click();
            $(".panel-body").setValue("ddddd");
        });

        step("Заполнение цены закупки", () -> {
            $$(".btn-default").findBy(text("Цена закупки")).click();
            // $(".input-number-bootstrap  form-control",1).setValue("100");
        });

        step("Загрузка файла", () -> {
            $("input[type='file']").uploadFromClasspath("example.jpg");
            $(".form-respond-file-item__name").shouldHave(text("example"));
        });

        step("Сохранение заявки и публикация", () -> {
            $("#createOrSaveRequest").click();
            $(".alert-text").shouldHave(text("Черновик успешно сохранен"));
            $("button[type='button'][class='close']").click();
            $$(".btn-primary").findBy(text("Опубликовать")).scrollTo().click();
            $("#saveButton").click();
            $(".breadcrumbs__item").click();
        });

        step("Проверка результата", () -> {


        });


    }

}
