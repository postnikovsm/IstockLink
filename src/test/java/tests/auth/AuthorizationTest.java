package tests.auth;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AuthorizationTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void authorizationFormTest() {
        open("https://messenger.test.istock.link/login");
        $("input[name='email']").setValue("postnikov.smm@mail.ru");
        $("input[name='password']").setValue("123123123");
        $("button[name='loginUserButton']").click();
        $(".layout-messenger").shouldHave(text("Мессенджер"));
    }
}

