package tests.auth;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AuthorizationTest {
    @Tag("smoke")
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

    @CsvSource({
            "00000000, 00000000, Пользователь с таким логином не зарегистрирован",
            "postnikov.smm@mail.ru, 00000000, Вы ввели неправильный пароль"
    })
    @ParameterizedTest(name = "Авторизация по логину {0} и паролю {1}")
    void authorizationNegativeEmailFormTest(String email, String password, String result) {
        open("https://messenger.test.istock.link/login");
        $("input[name='email']").setValue(email);
        $("input[name='password']").setValue(password);
        $("button[name='loginUserButton']").click();
        $("#errorText").shouldHave(text(result));
    }

}

