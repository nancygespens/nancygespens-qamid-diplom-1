package pages;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.AppActivity;
import screenElements.CommentScreen;

public class CommentPage {

    @Rule
    public static ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(ru.iteco.fmhandroid.ui.AppActivity.class);

    public static void fillInTheCommentField(String comment) {
        Allure.step("Заполнение поля комментария");
        CommentScreen.commentTestInputEditText.perform(replaceText(comment));
    }

    public static void saveComment() {
        Allure.step("Сохранить комментарий");
        CommentScreen.saveButton.perform(click());
    }

    public static void cancelCommentCreation() {
        CommentScreen.cancelButton.perform(click());
    }

}
