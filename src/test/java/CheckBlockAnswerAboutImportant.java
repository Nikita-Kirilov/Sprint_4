import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.BlockQuestionAboutImportant;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Parameterized.class)
public class CheckBlockAnswerAboutImportant {
    private WebDriver driver;

    private final String textAnswer;
    private final int numberOfBlockAnswer;

    public CheckBlockAnswerAboutImportant(String textAnswer, int numberOfBlockAnswer) {
        this.textAnswer = textAnswer;
        this.numberOfBlockAnswer = numberOfBlockAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void checkAnswerAboutImportant() {
        //System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        BlockQuestionAboutImportant blockQuestionAboutImportant = new BlockQuestionAboutImportant(driver);
        blockQuestionAboutImportant.checkTextAnswerAboutImportant(textAnswer,numberOfBlockAnswer);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
