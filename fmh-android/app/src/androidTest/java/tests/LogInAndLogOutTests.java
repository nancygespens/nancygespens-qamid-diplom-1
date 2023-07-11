package tests;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import pages.AuthorizationPage;
import pages.ControlPanelPage;

import ru.iteco.fmhandroid.R;

@RunWith(AllureAndroidJUnit4.class)
public class LogInAndLogOutTests {

    @Rule
    public ActivityTestRule<ru.iteco.fmhandroid.ui.AppActivity> activityTestRule =
            new ActivityTestRule<>(ru.iteco.fmhandroid.ui.AppActivity.class);

    String validLogin = "login2";
    String validPassword = "password2";

    @Before
    public void sleep() throws InterruptedException {
        Thread.sleep(7000);
    }

    @Test
    @DisplayName("Вход в личный кабинет с валидными данными (латинские символы)")
    public void shouldLogInWithValidData() throws InterruptedException {
        AuthorizationPage.logIn(validLogin, validPassword);
        ControlPanelPage.checkTradeMark();
        ControlPanelPage.logOut();
    }

    @Test
    @DisplayName("Вход в личный кабинет с пустыми полями")
    public void shouldTryLogInWithEmptyField() throws InterruptedException {
        AuthorizationPage.clickSignInButton();
        onView(withText(R.string.empty_login_or_password))
                .inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow()
                        .getDecorView())))).check(matches(withText("Login and password cannot be empty")));
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    public void shouldLogOut() throws InterruptedException {
        AuthorizationPage.logIn(validLogin, validPassword);
        ControlPanelPage.logOut();
        AuthorizationPage.isAuthorizationScreen();
    }
}
