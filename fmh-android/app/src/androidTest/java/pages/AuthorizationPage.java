package pages;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.rule.ActivityTestRule;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.AppActivity;
import screenElements.AuthorizationScreen;

public class AuthorizationPage {

    public static ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(ru.iteco.fmhandroid.ui.AppActivity.class);

    public static void isAuthorizationScreen() {
        Allure.step("Проверка, что открыто акно авторизации");
        AuthorizationScreen.authorization.check(matches(isDisplayed()));
    }

    public static void logIn(String login, String password) throws InterruptedException {
        Allure.step("Авторизация (вход в личный кабинет)");
        AuthorizationScreen.loginInput.perform(replaceText(login));
        AuthorizationScreen.passwordInput.perform(replaceText(password));
        AuthorizationScreen.signInButton.perform(click());
        Thread.sleep(3500);
    }

    public static void clickSignInButton() {
        Allure.step("Кликнуть на кнопку Войти");
        AuthorizationScreen.signInButton.perform(click());
    }

}
