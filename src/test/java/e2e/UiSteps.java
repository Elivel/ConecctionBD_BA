package e2e;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UiSteps {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    private WebDriver driver;

    @Given("una sesión Playwright")
    public void unaSesionPlaywright() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        context = browser.newContext();
        page = context.newPage();
    }

    @When("abro la página {string}")
    public void abroLaPagina(String url) {
        page.navigate(url);
    }

    @Then("el título contiene {string}")
    public void elTituloContiene(String textoEsperado) {
        String title = page.title();
        Assertions.assertTrue(title.contains(textoEsperado), "Título inesperado: " + title);
    }

    @Given("una sesión Selenium con WebDriverManager")
    public void unaSesionSeleniumConWebDriverManager() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @When("navego a {string}")
    public void navegoA(String url) {
        driver.get(url);
    }

    @Then("el título Selenium contiene {string}")
    public void elTituloSeleniumContiene(String textoEsperado) {
        String title = driver.getTitle();
        Assertions.assertTrue(title.contains(textoEsperado), "Título inesperado: " + title);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
