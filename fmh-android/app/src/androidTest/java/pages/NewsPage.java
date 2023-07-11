package pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.hasSibling;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import additional.MainHelper;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import screenElements.NewsScreen;

public class NewsPage {

    public static void initiateTheCreationOfNews() {
        Allure.step("Начинаем создавать новость (переход к созданию новости)");
        NewsScreen.editNewsButton.perform(click());
        NewsScreen.addNewsButton.perform(click());
    }

    public static void initiateNewsEditing(String title) throws InterruptedException {
        Allure.step("Переход к редактированию ранее созданной новости");
        NewsScreen.editNewsButton.perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.sort_news_material_button)).perform(click());
        MainHelper.isDisplayedWithSwipe(onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(title)))), 1, true);
        onView(allOf(withId(R.id.edit_news_item_image_view), hasSibling(withText(title)))).perform(click());

    }

    public static void checkNewsData(String title, String description) {
        Allure.step("Убеждаемся, что соданная новость содержит ранее введенные данные");
        if (MainHelper.isDisplayedWithSwipe(onView(withText(title)), 1, true)) {
            onView(withText(title)).check(matches(isDisplayed())).perform(click());
            onView(withText(description)).check(matches(isDisplayed()));
        }
    }

    public static void checkFirstNewsDataAfterEdit(String category, String description, String currentDate) {
        Allure.step("Провека первой новости после редактирования");
        NewsScreen.firstCardNews.perform(click());
        NewsScreen.firstNewsItemTitle.check(matches(withText(category)));
        NewsScreen.firstNewsItemDescription.check(matches(withText(description)));
        NewsScreen.firstNewsItemDate.check(matches(withText(currentDate)));
    }

    public static void checkThatNewsDoesNotExist(String title, String description) throws InterruptedException {
        Allure.step("Проверка того, что новость не существует в блоке новостей");
        NewsScreen.firstCardNews2.perform(actionOnItemAtPosition(0, click()));
        NewsScreen.firstNewsItemTitle2.check(matches(not(withText(title))));
        NewsScreen.firstNewsItemDescription2.check(matches(not(withText(description))));
    }

    public static void checkThatNewsDoesNotExistInNewsBlockWhenItHasNotActiveStatus(String category, String description) {
        Allure.step("Проверка того, что не активная новость не видна в блоке новостей ");
        NewsScreen.firstCardNews.perform(click());
        NewsScreen.firstNewsItemTitle.check(matches(not(withText(category))));
        NewsScreen.firstNewsItemDescription.check(matches(not(withText(description))));
    }

    public static void deleteNews(String title) {
        Allure.step("Удалить ранее созданную новость новость");
        // пересортировать новости (для стабильности свайпа)
        onView(withId(R.id.sort_news_material_button)).perform(click());
        // свайп к ранее созданной новости
        MainHelper.isDisplayedWithSwipe(onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(title)))), 1, true);
        // непосредственное удаление новости
        onView(allOf(withId(R.id.delete_news_item_image_view), hasSibling(withText(title)))).perform(click());
        //NewsScreen.deleteFirstNewsButton.perform(click());
        // подтверждаем удаление новости
        NewsScreen.okButton.perform(click());
    }

    public static void checkNewsStatus(String chosenCategory, String currentDate, String finalStatus) {
        Allure.step("Проверить статус новости");
        onView(withId(R.id.sort_news_material_button)).perform(click());
        MainHelper.isDisplayedWithSwipe(onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(chosenCategory)))), 1, true);
        // проверяем категорию
        onView(allOf(withId(R.id.news_item_published_text_view), hasSibling(withText(chosenCategory)))).check(matches(withText(finalStatus)));
        // на всякий случай проверяем дату создания и публикации (текущая)
        onView(allOf(withId(R.id.news_item_publication_date_text_view), hasSibling(withText(chosenCategory)))).check(matches(withText(currentDate)));
    }

    public static void expandFirstNewsInNewsBlock() {
        Allure.step("Раскрыть первую заявку в блоке новостей");
        NewsScreen.openFirstNewsInNewsBlock.perform(click());
    }

    public static void checkBasicContentOfFirstExpandedNewsInNewsBlock() {
        Allure.step("Проверить базовое содержимое раскрытой первой новости в блоке новостей");
        NewsScreen.firstNewsItemTitle.check(matches(isDisplayed()));
        NewsScreen.firstNewsItemDescription.check(matches(isDisplayed()));
        NewsScreen.firstNewsItemDate.check(matches(isDisplayed()));
    }

    public static void checkThatThereAreThreeNewsItemsInTheNewsBlock() {
        Allure.step("Проверка, что три новости имеются в блоке новостей");
        NewsScreen.firstCardNews.check(matches(isDisplayed()));
        NewsScreen.firstNewsItemTitle.check(matches(isDisplayed()));
        NewsScreen.secondCardNews.check(matches(isDisplayed()));
        NewsScreen.secondNewsItemTitle.check(matches(isDisplayed()));
        NewsScreen.thirdCardNews.check(matches(isDisplayed()));
        NewsScreen.thirdNewsItemTitle.check(matches(isDisplayed()));
    }

    public static void goToEditingModeForNews() {
        NewsScreen.editNewsButton.perform(click());
    }

}
