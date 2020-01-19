package seleniumWebTesting.web.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import static seleniumWebTesting.web.dataObjects.UrlData.loginPageUrl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public abstract class ChromeRunner {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = loginPageUrl;
        //Configuration.proxyEnabled = true;
        //System.setProperty(wdm.proxy,"proxy.hq.tbc");
        //Configuration.fastSetValue = true;
        Configuration.startMaximized = true;


        //        Configuration.headless = true;

        // Chromedrivermanager downloads latest chromedriver version 74, which expects browser to be version 74 as well, but it is not released in stable yet.
        // System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "/.m2/repository/webdriver/chromedriver/linux64/73.0.3683.68/chromedriver");

        // Windows has issue with path, So we need to specify chromedriver path manually
        // Configuration.driverManagerEnabled = true;

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ddanelia\\Desktop\\chromedriver.exe");

    }

    @AfterAll
    void tearDown() {

        // Cookies was not authenticated. Failure message: Unprotect ticket failed
        Selenide.clearBrowserCookies();
    }


}
