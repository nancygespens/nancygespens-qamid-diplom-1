package tests;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import pages.AuthorizationPage;
import pages.ClaimsPage;
import pages.ControlPanelPage;
import ru.iteco.fmhandroid.ui.AppActivity;

@RunWith(AllureAndroidJUnit4.class)
public class ClaimsFilteringTests {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(ru.iteco.fmhandroid.ui.AppActivity.class);

    @Before
    public void logIn() throws InterruptedException {
        Thread.sleep(7000);
        try {
            AuthorizationPage.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            return;
        }
        AuthorizationPage.logIn("login2", "password2");
    }

    @Test  // крайне нестабильный тест - падает по техническим причинам (проблемы со свайпом)
    @DisplayName("Выбран статус \"Открыта\" при фильтрации заявок")
    public void openStatusIsChosenDuringClaimsFiltering() throws InterruptedException {
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.initiateClaimFiltering();
        ClaimsPage.сhooseOnlyOpenStatusIfOpenAndInProgressStatusesAreChosenInitially();
        Thread.sleep(2000);
        ClaimsPage.checkThatFirstFiveClaimsHaveOpenStatus();
    }

}
