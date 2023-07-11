package tests;

import androidx.test.espresso.NoMatchingViewException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import pages.AuthorizationPage;
import pages.ClaimPage;
import pages.ClaimsPage;
import pages.ControlPanelPage;

import androidx.test.rule.ActivityTestRule;

import ru.iteco.fmhandroid.ui.AppActivity;

@RunWith(AllureAndroidJUnit4.class)
public class ClaimsTests {

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

    @Test
    @DisplayName("Наличие всех заявок в блоке \"Заявки\" (минимум 3)")
    public void shouldBeThreeClaimsInClaimsBlock() {
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.checkThatThereAreThreeClaimsItemsInTheClaimsBlock();
    }

    @Test // тест нестабильный при запуске всех тестов в эмуляторе (отдельно проходит)
    @DisplayName("Полнота информации заявок (в свернутом состоянии) в блоке \"Заявки\"")
    public void shouldBeFullContentOfNotExpandedClaimInClaimsBlock() throws InterruptedException {
        ControlPanelPage.goToClaimsBlock();
        Thread.sleep(3000);
        ClaimsPage.checkContentOfFirstClaimInClaimsBlock();
    }

    @Test
    @DisplayName("Полнота информации раскрытой заявки в блоке \"Заявки\"")
    public void shouldBeFullContentOfExpandedClaimInClaimsBlock() throws InterruptedException {
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.goToFirstClaimFromClaimsBlock();
        Thread.sleep(3000);
        ClaimPage.checkFullContentOfExpandedClaim();
    }

}
