package Config;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.HashMap;

public class BaseClass {
    public WebDriver driver;
    public WebDriverWait wait;
    public WebDriverWait waitForElement;
    public Actions actions;

    @BeforeClass
    public void setupBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

//        options.addArguments("--headless");
        options.addArguments("window-size=1920,1080");
        options.addArguments("no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions"); // to disable extension
        options.addArguments("--disable-notifications"); // to disable notification
        options.addArguments("--disable-application-cache");
        options.addArguments("--enable-javascript");
        options.addArguments("--disable-gpu");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36)");
         driver = new ChromeDriver(options);

//        options.addArguments("--incognito"); // Open in incognito mode
//        options.addArguments("--disable-blink-features=AutomationControlled"); // Prevent detection
//        options.setExperimentalOption("useAutomationExtension", false);
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});



//        driver = new ChromeDriver(options);
        driver.get("https://www.zoom.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitForElement = new WebDriverWait(driver, Duration.ofSeconds(4));
        actions = new Actions(driver);
        System.out.println("Navigate to web app");
    }

//    @AfterClass
    public void needToClose() {
        driver.quit();
    }
}