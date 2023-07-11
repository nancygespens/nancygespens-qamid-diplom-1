package pages;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import screenElements.MainScreen;

public class ControlPanelPage {

    public static void logOut() {
        Allure.step("Выход из личного кабинета");
        MainScreen.authorizationButton.perform(click());
        MainScreen.logOutButton.perform(click());
    }

    public static void checkTradeMark() {
        Allure.step("Проверка видимости эмблемы приложения");
        MainScreen.tradeMark.check(matches(isDisplayed()));
    }

    public static void goToNewsBlock() {
        Allure.step("Переход в блок \"Новости\"");
        MainScreen.menuButton.perform(click());
        MainScreen.newsOfMenu.perform(click());
    }

    public static void goToMainBlock() {
        Allure.step("Переход в блок \"Новости\"");
        MainScreen.menuButton.perform(click());
        MainScreen.mainOfMenu.perform(click());
    }

    public static void goToClaimsBlock() {
        Allure.step("Переход в блок \"Заявки\"");
        MainScreen.menuButton.perform(click());
        MainScreen.claimsOfMenu.perform(click());
    }

    public static void goToAboutBlock() {
        Allure.step("Переход в блок \"О приложении\"");
        MainScreen.menuButton.perform(click());
        MainScreen.aboutOfMenu.perform(click());
    }

    public static void goToQuotesBlock() {
        Allure.step("Переход в блок цитат о хосписе");
        MainScreen.goToQuotesBlockButton.perform(click());
    }

    public static void checkThatAllItemsOfMenuAreDisplayed() {
        Allure.step("Провека, что видны все пункты меню");
        MainScreen.mainOfMenu.check(matches(isDisplayed()));
        MainScreen.claimsOfMenu.check(matches(isDisplayed()));
        MainScreen.newsOfMenu.check(matches(isDisplayed()));
        MainScreen.aboutOfMenu.check(matches(isDisplayed()));
    }

}
