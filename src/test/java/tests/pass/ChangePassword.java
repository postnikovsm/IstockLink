package tests.pass;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.AuthorizationPage;

import javax.swing.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ChangePassword {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1400x800";
    }
    @Test
    @Story("Изменение пароля")
    @Owner("Олехандро")
    void changePasswordFromProfile(){
        AuthorizationPage authorizationPage = new AuthorizationPage();
        step("Авторизация в мессенджере", () -> {
            authorizationPage.authorizationPage("istock.link.test@rambler.ru", "123123123");
        });
        step("Изменение пароля на новый", () -> {
            $(".snm__sections").$(byText("Мой профиль")).click();
            $(".link").scrollTo().click();
            $("#currentPassword").setValue("123123123");
            $("#newPassword").setValue("12345678");
            $("#newPasswordRepeat").setValue("12345678");
            $("#saveCharacteristicButton").click();
            $(".alert-success").shouldHave(text("Пароль успешно изменен"));
            $("button[type='button'][class='close']").click();
            $("button[type='button'][class='snm-link']").click();
        });

        step("Авторизация в мессенджере с новым паролем", () -> {
            authorizationPage.authorizationPage("istock.link.test@rambler.ru", "12345678");
        });

        step("Возврат старого пароля", () -> {
            $(".snm__sections").$(byText("Мой профиль")).click();
            $(".link").scrollTo().click();
            $("#currentPassword").setValue("12345678");
            $("#newPassword").setValue("123123123");
            $("#newPasswordRepeat").setValue("123123123");
            $("#saveCharacteristicButton").click();
            $("button[type='button'][class='snm-link']").click();
        });

    }
}
