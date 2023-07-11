package tests;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import pages.CommentPage;

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
import ru.iteco.fmhandroid.ui.AppActivity;

@RunWith(AllureAndroidJUnit4.class)
public class CommentEditingTests {

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
    @DisplayName("Редактирование комментария в заявке при валидных данных (кириллические символы)")
    public void shouldEditCommentOfClaim() throws InterruptedException {
        String comment = "QA Midd1";
        String commentForEditing = "QA Midd2";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.goToFirstClaimFromClaimsBlock();
        Thread.sleep(3000);
        // приступаем к созданию комментария
        ClaimPage.scrollToLastComment();
        ClaimPage.initiateCommentCreation();
        CommentPage.fillInTheCommentField(comment);
        CommentPage.saveComment();
        Thread.sleep(3000);
        ClaimPage.scrollToLastComment();
        ClaimPage.isCommentDisplayed(comment);
        // приступаем к редактированию комментария
        ClaimPage.scrollToLastComment();
        ClaimPage.initiateCommentEditing(comment);
        CommentPage.fillInTheCommentField(commentForEditing);
        CommentPage.saveComment();
        Thread.sleep(3000);
        ClaimPage.scrollToLastComment();
        ClaimPage.isCommentDisplayed(commentForEditing);
    }

}
