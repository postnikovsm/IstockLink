package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage {
    public void authorizationPage(String name, String password) {
        open("https://messenger.test.istock.link/login");
        $("input[name='email']").setValue(name);
        $("input[name='password']").setValue(password);
        $("button[name='loginUserButton']").click();
        $(".layout-messenger__header").shouldHave(text("Мессенджер"));
    }
}
