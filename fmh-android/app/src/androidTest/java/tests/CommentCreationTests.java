package tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

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
import pages.ClaimsPage;
import pages.CommentPage;
import pages.ControlPanelPage;
import ru.iteco.fmhandroid.ui.AppActivity;

@RunWith(AllureAndroidJUnit4.class)
public class CommentCreationTests {

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
    @DisplayName("Добавление нового комментария заявки с введением валидных данных")
    public void shouldCreateCommentWithValidData() throws InterruptedException {
        String comment = "QA Midg1";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.goToFirstClaimFromClaimsBlock();
        Thread.sleep(3000);
        ClaimPage.scrollToLastComment();
        ClaimPage.initiateCommentCreation();
        CommentPage.fillInTheCommentField(comment);
        CommentPage.saveComment();
        Thread.sleep(3000);
        ClaimPage.scrollToLastComment();
        ClaimPage.isCommentDisplayed(comment);
    }

    @Test // нестабильный тест при запуске всех тестов в эмуляторе (отдельно проходит)
    @DisplayName("Пустой ввод при добавлении нового комментария к заявке")
    public void shouldTryCreateCommentWithEmptyField() throws InterruptedException {
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.goToFirstClaimFromClaimsBlock();
        Thread.sleep(3000);
        ClaimPage.scrollToLastComment();
        ClaimPage.initiateCommentCreation();
        CommentPage.saveComment();
        onView(withText("The field cannot be empty."))
                .inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow()
                        .getDecorView())))).check(matches(withText("The field cannot be empty.")));
    }

    @Test  // нестабильный тест при запуске всех тестов на эмуляторе (отдельно проходит)
    @DisplayName("Отмена добавления нового комментария")
    public void shouldCancelCommentCreation() throws InterruptedException {
        String comment = "QA Midf1";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.goToFirstClaimFromClaimsBlock();
        Thread.sleep(3000);
        ClaimPage.scrollToLastComment();
        ClaimPage.initiateCommentCreation();
        CommentPage.fillInTheCommentField(comment);
        CommentPage.cancelCommentCreation();
        Thread.sleep(3000);
        ClaimPage.scrollToLastComment();
        ClaimPage.commentDoesNotExist(comment);
    }

}
