package tests.request;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.AuthorizationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CreateRequests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void createRequestsWithFillForm() {
        AuthorizationPage authorizationPage = new AuthorizationPage();
        authorizationPage.authorizationPage("istock.link.test@rambler.ru", "123123123");

        $(".snm__sections").$(byText("Заявки на закупку")).click();

        $(".breadcrumbs-buttons").click();
        $$("#title-form").findBy(text("Номер заявки"))
                .sibling(0).$("#title", 1).setValue("11111111");

        $$("#title-form").findBy(text("Наименование заявки "))
                .sibling(1).$("#title").setValue("11111111");



        $(".category-select").setValue("Автоматизированные").pressEnter();

        $$(".control-label-row").findBy(text("Срок поставки "))
                .sibling(0).$(".input-group").click();

        $$("td:not(.text-muted)").first().click();


        $("#region-select").setValue("Хабаровский край").pressEnter();
        $$(".control-label-row").findBy(text("Требования к поставщику")).click(); //костыли


        $("#city-select").setValue("Комсомольск-на-Амуре").pressEnter();
        $$(".control-label-row").findBy(text("Город ")).click(); //костыли

        $(".btn-default").click();


        $(byId("0pr-name")).setValue("ffff");
        $(".input-number-bootstrap").setValue("111");
        $(".product-table-number",1).click();
        $(".product-table-number",1).$("input[type='number']").setValue("2");

        $$(".btn-default").findBy(text("Содержание заявки")).click();
        $(".panel-body").setValue("ddddd");

        $$(".btn-default").findBy(text("Цена закупки")).click();

       // $(".input-number-bootstrap  form-control",1).setValue("100");


        sleep(5000);
        $(".product-table-number").click();
        $(".product-table-number").sendKeys("111");
        sleep(5000);
        $(".product-table-number",1).setValue("10");

        sleep(5000);
        $(".form-group #title").setValue("фффф");


    }

}
