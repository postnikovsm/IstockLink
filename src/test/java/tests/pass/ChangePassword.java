package tests.pass;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import javax.swing.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ChangePassword {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1400x800";
    }
    @Test
    void changePasswordFromProfile(){
        open("https://messenger.test.istock.link/login");
        $("input[name='email']").setValue("istock.link.test@rambler.ru");
        $("input[name='password']").setValue("123123123");
        $("button[name='loginUserButton']").click();
        $(".layout-messenger").shouldHave(text("Мессенджер"));
        $(".snm__sections").$(byText("Мой профиль")).click();
        $(".link").scrollTo().click();
        $("input[id='currentPassword']").setValue("123123123");
        $("input[id='newPassword']").setValue("12345678");
        $("input[id='newPasswordRepeat']").setValue("12345678");
        $("button[id='saveCharacteristicButton']").click();
        $(".alert-success").shouldHave(text("Пароль успешно изменен"));
        $("button[type='button'][class='close']").click();
        $("button[type='button'][class='snm-link']").click();
        $("input[name='email']").setValue("istock.link.test@rambler.ru");
        $("input[name='password']").setValue("12345678");
        $("button[name='loginUserButton']").click();
        $(".layout-messenger").shouldHave(text("Мессенджер"));
        $(".snm__sections").$(byText("Мой профиль")).click();
        $(".link").scrollTo().click();
        $("input[id='currentPassword']").setValue("12345678");
        $("input[id='newPassword']").setValue("123123123");
        $("input[id='newPasswordRepeat']").setValue("123123123");
        $("button[id='saveCharacteristicButton']").click();
        $("button[type='button'][class='snm-link']").click();







    }
}
