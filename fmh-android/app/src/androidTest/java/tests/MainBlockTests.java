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
import pages.ClaimPage;
import pages.MainPage;
import ru.iteco.fmhandroid.ui.AppActivity;

@RunWith(AllureAndroidJUnit4.class)
public class MainBlockTests {

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
        AuthorizationPage.logIn("login2","password2");
    }

    @Test
    @DisplayName("Наличие разделов \"Новости\" и \"Завки\" в главном блоке")
    public void newsAndClaimsPartsShouldBeInMainBLock(){
        MainPage.checkIfNewsPartitionExists();
        MainPage.checkIfClaimsPartitionExists();
    }

    @Test
    @DisplayName("Раскрытие новости в главном блоке")
    public void newsCanBeExpandedInMainBlock() {
        MainPage.expandFirstNewsInMainBlock();
        MainPage.checkDescriptionOfFirstNews();
    }

    @Test
    @DisplayName("Полнота информации свернутой новости в главном блоке")
    public void shouldBeFullContentOfNotExpandedNewsInMainBlock() {
        MainPage.checkContentOfNotExpandedFirstNewsInMainBlock();
    }

    @Test
    @DisplayName("Наличие заявок в разделе \"Заявки\" в главном блоке")
    public void claimsShouldBeVisibleInClaimsPartOnMainBlock() throws InterruptedException {
        MainPage.expandOrHideNewsPart();
        MainPage.claimTitleIsDisplayedWithSwipe(0);
        MainPage.claimTitleIsDisplayedWithSwipe(1);
    }

    @Test // нестабильный тест в эмуляторе (отдельно проходит)
    @DisplayName("Полнота информации заявки в главном блоке (в свернутом состоянии)")
    public void shouldBeFullContentOfNotExpandedClaimInMainBlock() throws InterruptedException {
        MainPage.expandOrHideNewsPart();
        Thread.sleep(3000);
        MainPage.checkContentOfFirstClaimInMainBlock();
    }

    @Test // нестабильный тест в эмуляторе (отдельно проходит)
    @DisplayName("Переход к заявке в главном блоке")
    public void shouldGoToFirstClaimInMainBlock() throws InterruptedException {
        MainPage.expandOrHideNewsPart();
        MainPage.goToFirstClaimFromMainBlock();
        Thread.sleep(3000);
        ClaimPage.checkBasicElementsOfClaim();
    }
}
