package tests;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import pages.AuthorizationPage;
import pages.ControlPanelPage;
import pages.NewsCreationAndEditingPage;
import pages.NewsPage;
import ru.iteco.fmhandroid.ui.AppActivity;

@RunWith(AllureAndroidJUnit4.class)
public class NewsTests {

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
    @DisplayName("Наличие новостей в блоке \"Новости\" (минимум 3)")
    public void shouldBeThreeNewsInNewsBlock() {
        ControlPanelPage.goToNewsBlock();
        NewsPage.checkThatThereAreThreeNewsItemsInTheNewsBlock();
    }

    @Test
    @DisplayName("Полнота информации новостей (в развернутом состоянии) в блоке \"Новости\"")
    public void shouldBeFullContentOfFirstExpandedNewsInNewsBlock() {
        ControlPanelPage.goToNewsBlock();
        NewsPage.expandFirstNewsInNewsBlock();
        NewsPage.checkBasicContentOfFirstExpandedNewsInNewsBlock();
    }

    @Test // низкая стабильность теста
    @DisplayName("Удаление новости")
    public void shouldDeleteNews() throws InterruptedException {
        String emptyCategory = "no";
        String withCategoryChoice = "yes";
        String chosenCategory = "Зарплата";
        String category = "no";
        String title = "no";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String description = "New description";
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        ControlPanelPage.goToNewsBlock();
        NewsPage.initiateTheCreationOfNews();
        NewsCreationAndEditingPage.fillInTheNewsFields(emptyCategory, withCategoryChoice, chosenCategory, category, title, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        NewsCreationAndEditingPage.saveNews();
        ControlPanelPage.goToNewsBlock();
        NewsPage.checkNewsData(chosenCategory, description);
        NewsPage.deleteNews(chosenCategory);
        ControlPanelPage.goToNewsBlock();
        Thread.sleep(3000);
        NewsPage.checkThatNewsDoesNotExist(chosenCategory, description);
    }
}

