package seleniumWebTesting.web.tests.News;

import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import seleniumWebTesting.web.pageObjects.CommunityGroups;
import seleniumWebTesting.web.pageObjects.MassagePage;
import seleniumWebTesting.web.stepObjects.*;
import seleniumWebTesting.web.utils.ChromeRunner;
import static seleniumWebTesting.web.dataObjects.CommunityGroupsData.*;
import static seleniumWebTesting.web.dataObjects.UserData.*;



public class loginTest extends ChromeRunner {

    @Test
    @DisplayName("successful Login")
    public void logginIntoSystem() {
        loginPageSteps step = new loginPageSteps();
        step.open();
        step.changeLanguage();
        step.successfulLogin(username, password);

        afterEachSteps closing = new afterEachSteps();
        closing.closeBrowserAndClearCookies();
    }

    @Test
    @DisplayName("Playing Music")
    public void playMusic() throws InterruptedException {
        loginPageSteps step3 = new loginPageSteps();
        MusicPageSteps step2 = new MusicPageSteps();
        step3.logginIntoSystem(username,password);
        step2.enterMusicSection();
        step2.searchingMusic(songName);
        step2.playSong();
        Thread.sleep(60000);

        afterEachSteps closing = new afterEachSteps();
        closing.closeBrowserAndClearCookies();
    }


    @Test
    @DisplayName("Sending Massage")
    public void sendMassageToPerson() {
        loginPageSteps step4 = new loginPageSteps();
        step4.logginIntoSystem(username,password);

        MassagePageSteps step3 = new MassagePageSteps();
        step3.enterMassageSection();
        step3.searchPerson(nameOfPerson);
        step3.sendMassageToPerson(massage);
        step3.checkingIfMassageWasSendSuccessfully();

        afterEachSteps closing = new afterEachSteps();
        closing.closeBrowserAndClearCookies();
    }

    @Test
    @DisplayName("Community Group search and openning Pics")
    public void searchingCommunityAndWatchingSomeMemes() throws InterruptedException {
        loginPageSteps step4 = new loginPageSteps();
        step4.logginIntoSystem(username,password);

        CommunityGroupsSteps step1 = new CommunityGroupsSteps();
        step1.enterCommunitySection();
        step1.searchingCommunity(communityName);
        step1.choosingCommunity();
        step1.openingPicByIndexWithTiming(5,5);

        afterEachSteps closing = new afterEachSteps();
        closing.closeBrowserAndClearCookies();

    }
}
