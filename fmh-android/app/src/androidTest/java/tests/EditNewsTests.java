package tests;

import static androidx.test.espresso.action.ViewActions.click;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.junit4.DisplayName;
import pages.AuthorizationPage;
import pages.ControlPanelPage;
import pages.NewsCreationAndEditingPage;
import pages.NewsPage;
import ru.iteco.fmhandroid.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;

import additional.MainHelper;
import ru.iteco.fmhandroid.ui.AppActivity;
import screenElements.NewsScreen;

@RunWith(AllureAndroidJUnit4.class)
public class EditNewsTests {

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

    public void createNewsWithActiveStatus() {
        Allure.step("Создание новости с активным статусом");
        // общие параметры для создания/редактирования новости
        String emptyCategory = "no";
        String withCategoryChoice = "yes";
        String category = "no";
        String title = "no";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        // параметры новости
        String chosenCategory = "Зарплата";
        String description = "Description";
        ControlPanelPage.goToNewsBlock();
        NewsPage.initiateTheCreationOfNews();
        NewsCreationAndEditingPage.fillInTheNewsFields(emptyCategory, withCategoryChoice, chosenCategory, category, title, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        NewsCreationAndEditingPage.saveNews();
    }

    public void createNewsWithNotActiveStatus() throws InterruptedException {
        Allure.step("Создание заявки с НЕактивным статусом");
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        // параметры новости (должны совпадать с параметрами пердварительно созданной новости!!!!!)
        String chosenCategory = "Зарплата";
        String description = "Description";
        String finalStatus = "Not active";
        createNewsWithActiveStatus();
        ControlPanelPage.goToNewsBlock();
        // проверяем,что новость, действительно, создана
        NewsPage.checkNewsData(chosenCategory, description);
        NewsPage.initiateNewsEditing(chosenCategory);
        // убеждаемся, что для изменения статуса выбрана именно ранее созданная новость
        NewsCreationAndEditingPage.checkNewsInEditMode(chosenCategory, currentDate, description);
        // изменение статуса
        NewsCreationAndEditingPage.changeNewsStatus();
        NewsCreationAndEditingPage.saveNews();
        Thread.sleep(5000);
        ControlPanelPage.goToClaimsBlock();
        ControlPanelPage.goToNewsBlock();
        NewsScreen.editNewsButton.perform(click());
        // проверка, что новость имеет статус "На активна"
        //NewsPage.checkNewsStatus(chosenCategory,currentDate, finalStatus);
    }

    @Test // низкая стабильностьь теста
    @DisplayName("Редактирование новости при заполнении всех полей валидными данными (кирилические символы, текущая дата, текущее время в формате циферблата)")
    public void editNewsWithValidData() throws InterruptedException {
        // общие параметры для создания/редактирования новости
        String emptyCategory = "no";
        String withCategoryChoice = "yes";
        String category = "no";
        String title = "no";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        // параметры старой новости
        String chosenCategory = "Зарплата";
        String description = "Description";
        // параметры для редактирования новости
        String newChosenCategory = "Массаж";
        String newDescription = "New description";
        // создаем новость
        createNewsWithActiveStatus();
        ControlPanelPage.goToNewsBlock();
        // проверяем,что новость, действительно, создана
        NewsPage.checkNewsData(chosenCategory, description);
        // переход к редактированию новости
        NewsPage.initiateNewsEditing(chosenCategory);
        // убеждаемся, что для редактирования выбрана именно ранее созданная новость
        Thread.sleep(2000);
        NewsCreationAndEditingPage.checkNewsInEditMode(chosenCategory, currentDate, description);
        // редактирование новости
        NewsCreationAndEditingPage.fillInTheNewsFields(emptyCategory, withCategoryChoice, newChosenCategory, category, title, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, newDescription);
        NewsCreationAndEditingPage.saveNews();
        ControlPanelPage.goToNewsBlock();
        // проверяем,что новость, действительно, отредактирована (данные обновились)
        NewsPage.checkFirstNewsDataAfterEdit(newChosenCategory, newDescription, currentDate);
        // удаление новости
        NewsPage.goToEditingModeForNews();
        NewsPage.deleteNews(newChosenCategory);
    }

    @Test  // тест проходит (без удаления)
    @DisplayName("Изменение статуса с \"Активна\" на \"Не активна\" при редактировании новости")
    public void shouldChangeNewsStatusToNotActive() throws InterruptedException {
        // общие параметры для редактирования новости
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        // параметры новости (должны совпадать с параметрами пердварительно созданной новости!!!!!)
        String chosenCategory = "Зарплата";
        String description = "Description";
        String finalStatus = "Not active";
        // создаем новость
        createNewsWithActiveStatus();
        ControlPanelPage.goToNewsBlock();
        // проверяем,что новость, действительно, создана
        NewsPage.checkNewsData(chosenCategory, description);
        // переход к редактированию новости
        NewsPage.initiateNewsEditing(chosenCategory);
        // убеждаемся, что для изменения статуса выбрана именно ранее созданная новость
        NewsCreationAndEditingPage.checkNewsInEditMode(chosenCategory, currentDate, description);
        // изменение статуса
        NewsCreationAndEditingPage.changeNewsStatus();
        NewsCreationAndEditingPage.saveNews();
        Thread.sleep(5000);
        ControlPanelPage.goToClaimsBlock();
        ControlPanelPage.goToNewsBlock();
        NewsScreen.editNewsButton.perform(click());
        // проверка, что новость имеет статус "На активна"
        NewsPage.checkNewsStatus(chosenCategory, currentDate, finalStatus);
        // проверка, что новость исчезла из панели новостей (допущение, что сохраненная ноовсть всегда показывается первой)
        ControlPanelPage.goToClaimsBlock();
        ControlPanelPage.goToNewsBlock();
        NewsPage.checkThatNewsDoesNotExist(chosenCategory, description);
        // удаление новости
        NewsPage.goToEditingModeForNews();
        NewsPage.deleteNews(chosenCategory);
    }

    @Test // падает по техническим причинам!
    @DisplayName("Изменение статуса с \"Не активна\" на \"Активна\" при редактировании новости")
    public void shouldChangeNewsStatusToActive() throws InterruptedException {
        String chosenCategory = "Зарплата";
        String description = "Description";
        String finalStatus = "Active";
        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        createNewsWithNotActiveStatus();
        onView(MainHelper.withIndex(withId(R.id.view_news_item_image_view), 0)).perform(click());
        onView(MainHelper.withIndex(withContentDescription("News editing button"), 0)).perform(click());
        // убеждаемся, что для изменения статуса выбрана именно ранее созданная новость
        NewsCreationAndEditingPage.checkNewsInEditMode(chosenCategory, currentDate, description);
        // изменение статуса
        NewsCreationAndEditingPage.changeNewsStatus();
        NewsCreationAndEditingPage.saveNews();
        // проверка, что новость имеет статус активна
        NewsPage.checkNewsStatus(chosenCategory, currentDate, finalStatus);
        // проверка, что новость снова видна в блоке "Новости"
        ControlPanelPage.goToNewsBlock();
        //checkFirstNewsDataAfterEdit(chosenCategory,description,currentDate);
        NewsPage.checkNewsData(chosenCategory, description);
    }

}

