package tests;

import static androidx.test.espresso.Espresso.onView;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import pages.AuthorizationPage;
import pages.ClaimCreationPage;
import pages.ClaimPage;
import pages.ClaimsPage;
import pages.ControlPanelPage;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AllureAndroidJUnit4.class)
public class ClaimCreationTest {

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

    @Test // тест длительно выполняется из-за огромного количества заявок
    @DisplayName("Создание заявки при вводе валидных данных во все поля (кириллические символы, текущая дата и текущее время в формате циферблата)")
    public void shouldCreateClaimWithValidData() {
        String emptyTitle = "no";
        String title = "Diplom QA1";
        String emptyExecutor = "no";
        String withExecutorChoice = "yes";
        String chosenExecutor = "Netology Diplom QAMID";
        String executor = "no";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String description = "New description";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.initiateTheCreationOfClaim();
        ClaimCreationPage.fillInTheClaimFields(emptyTitle, title, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationPage.saveClaim();
        ClaimsPage.checkCreatedClaimInClaimsBlock(title);
    }

    @Test // тест длительно выполняется из-за огромного количества заявок
    @DisplayName("Ввод 49 символов в поле \"Тема\" при создании заявки")
    public void shouldInput49SymbolsInTitleDuringClaimCreation() {
        String emptyTitle = "no";
        String title49 = "DiplomQADiplomQADiplomQADiplomQADiplomQADiplom001";
        String emptyExecutor = "no";
        String withExecutorChoice = "yes";
        String chosenExecutor = "Netology Diplom QAMID";
        String executor = "no";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String description = "New description";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.initiateTheCreationOfClaim();
        ClaimCreationPage.fillInTheClaimFields(emptyTitle, title49, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationPage.saveClaim();
        ClaimsPage.checkCreatedClaimInClaimsBlock(title49);
    }

    @Test // тест длительно выполняется из-за огромного количества заявок
    @DisplayName("Ввод 50 символов в поле \"Тема\" при создании заявки")
    public void shouldInput50SymbolsInTitleDuringClaimCreation() {
        String emptyTitle = "no";
        String title50 = "DiplomQADiplomQADiplomQADiplomQADiplomQADiplom0001";
        String emptyExecutor = "no";
        String withExecutorChoice = "yes";
        String chosenExecutor = "Netology Diplom QAMID";
        String executor = "no";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String description = "New description";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.initiateTheCreationOfClaim();
        ClaimCreationPage.fillInTheClaimFields(emptyTitle, title50, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationPage.saveClaim();
        ClaimsPage.checkCreatedClaimInClaimsBlock(title50);
    }

    @Test // тест длительно выполняется из-за огромного количества заявок
    @DisplayName("Ввод 51 символа в поле \"Тема\" при создании заявки")
    public void shouldInput51SymbolsInTitleDuringClaimCreation() {
        String emptyTitle = "no";
        String title51 = "DiplomQADiplomQADiplomQADiplomQADiplomQADiploM00001";
        String titleOfCreatedClaim = "DiplomQADiplomQADiplomQADiplomQADiplomQADiploM0000";
        String emptyExecutor = "no";
        String withExecutorChoice = "yes";
        String chosenExecutor = "Netology Diplom QAMID";
        String executor = "no";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String description = "New description";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.initiateTheCreationOfClaim();
        ClaimCreationPage.fillInTheClaimFields(emptyTitle, title51, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationPage.saveClaim();
        ClaimsPage.checkCreatedClaimInClaimsBlock(titleOfCreatedClaim);
    }

    @Test
    @DisplayName("Пустой ввод в поле \"Тема\" при создании заявки")
    public void shouldTryCreateClaimWithEmptyTitle() {
        String emptyTitle = "yes";
        String title = "no";
        String emptyExecutor = "no";
        String withExecutorChoice = "yes";
        String chosenExecutor = "Netology Diplom QAMID";
        String executor = "no";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String description = "New description";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.initiateTheCreationOfClaim();
        ClaimCreationPage.fillInTheClaimFields(emptyTitle, title, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationPage.saveClaim();
        onView(withText(R.string.empty_fields))
                .inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow()
                        .getDecorView())))).check(matches(withText("Fill empty fields")));
    }

    @Test
    @DisplayName("Пустой ввод в поле \"Описание\" при создании заявки")
    public void shouldTryCreateClaimWithEmptyDescription() {
        String emptyTitle = "no";
        String title = "QAMIDK78";
        String emptyExecutor = "no";
        String withExecutorChoice = "yes";
        String chosenExecutor = "Netology Diplom QAMID";
        String executor = "yes";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "yes";
        String description = "-";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.initiateTheCreationOfClaim();
        ClaimCreationPage.fillInTheClaimFields(emptyTitle, title, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationPage.saveClaim();
        onView(withText(R.string.empty_fields))
                .inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow()
                        .getDecorView())))).check(matches(withText("Fill empty fields")));
    }

    @Test
    @DisplayName("Отмена выбора даты при создании заявки")
    public void shouldTryCreateClaimWithEmptyDate() {
        String emptyTitle = "no";
        String title = "QAMIDK78lF";
        String emptyExecutor = "no";
        String withExecutorChoice = "yes";
        String chosenExecutor = "Netology Diplom QAMID";
        String executor = "yes";
        String emptyDate = "yes";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String description = "New description";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.initiateTheCreationOfClaim();
        ClaimCreationPage.fillInTheClaimFields(emptyTitle, title, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationPage.saveClaim();
        onView(withText(R.string.empty_fields))
                .inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow()
                        .getDecorView())))).check(matches(withText("Fill empty fields")));
    }

    @Test
    @DisplayName("Отмена выбора времени в разделе циферблат при создании заявки")
    public void shouldTryCreateClaimWithCancelSavingOfTime() {
        String emptyTitle = "no";
        String title = "QAMIDK78gF";
        String emptyExecutor = "no";
        String withExecutorChoice = "yes";
        String chosenExecutor = "Netology Diplom QAMID";
        String executor = "yes";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "cancel";
        String emptyDescription = "no";
        String description = "New description";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.initiateTheCreationOfClaim();
        ClaimCreationPage.fillInTheClaimFields(emptyTitle, title, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationPage.saveClaim();
        onView(withText(R.string.empty_fields))
                .inRoot(withDecorView(not(is(activityTestRule.getActivity().getWindow()
                        .getDecorView())))).check(matches(withText("Fill empty fields")));
    }

    @Test
    @DisplayName("Пустой ввод в поле \"Исполнитель\" при создании заявки")
    public void shouldTryCreateClaimWithEmptyExecutor() throws InterruptedException {
        String emptyTitle = "no";
        String title = "QAMID345H";
        String emptyExecutor = "yes";
        String withExecutorChoice = "no";
        String chosenExecutor = "no";
        String executor = "no";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "dial";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String description = "New description";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.initiateTheCreationOfClaim();
        ClaimCreationPage.fillInTheClaimFields(emptyTitle, title, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationPage.saveClaim();
        ClaimsPage.checkCreatedClaimInClaimsBlock(title);
        Thread.sleep(3000);
        ClaimsPage.goToCreatedClaim(title);
        Thread.sleep(3000);
        ClaimPage.checkThatTheExecutorIsNotAssigned();
    }

    @Test // тест длительно выполняется из-за огромного количества заявок
    @DisplayName("Ручной ввод часов и минут при при создании заявки")
    public void shouldCreateClaimWithManualTimeInput() {
        String emptyTitle = "no";
        String title = "35T";
        String emptyExecutor = "no";
        String withExecutorChoice = "yes";
        String chosenExecutor = "Netology Diplom QAMID";
        String executor = "yes";
        String emptyDate = "no";
        String emptyTime = "no";
        String withDialPadOrTextInput = "text input";
        String saveOrCancelTime = "save";
        String emptyDescription = "no";
        String description = "New description";
        // будет введено время: 02:23 (заложено в методе, также в методе есть проверка, что введено именно это время)
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.initiateTheCreationOfClaim();
        ClaimCreationPage.fillInTheClaimFields(emptyTitle, title, emptyExecutor, withExecutorChoice, chosenExecutor, executor, emptyDate, emptyTime, withDialPadOrTextInput, saveOrCancelTime, emptyDescription, description);
        ClaimCreationPage.saveClaim();
        ClaimsPage.checkCreatedClaimInClaimsBlock(title);
        ClaimsPage.checkTimeOfCreatedClaimInClaimsBlock(title, "02:23"); // эмулятор сохраняет 05:23
    }

    @Test
    @DisplayName("Ввод > 24 часов в поле часы при создании заявки")
    public void shouldInputMoreThan24HoursWhenClaimIsBeingCreated() {
        String invalidHours = "76";
        String validMinutes = "23";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.initiateTheCreationOfClaim();
        ClaimCreationPage.timeInput(invalidHours, validMinutes);
        ClaimCreationPage.checkMessageOfTimeInputError();
    }

    @Test
    @DisplayName("Ввод >60 в поле минуты при создании заявки")
    public void shouldInputMoreThan60MinutesWhenClaimIsBeingCreated() {
        String validHours = "22";
        String invalidMinutes = "68";
        ControlPanelPage.goToClaimsBlock();
        ClaimsPage.initiateTheCreationOfClaim();
        ClaimCreationPage.timeInput(validHours, invalidMinutes);
        ClaimCreationPage.checkMessageOfTimeInputError();
    }
}
