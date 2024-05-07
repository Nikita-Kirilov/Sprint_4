import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.*;

@RunWith(Parameterized.class)
public class CheckOrderBike {
    private WebDriver driver;

    private final String textOwnerName;
    private final String textOwnerSurname;
    private final String textOwnerAddress;
    private final int indexOwnerSubway;
    private final String textOwnerPhoneNumber;
    private final int indexRentWhenArrivedDate;
    private final int indexRentRentalPeriod;
    private final int indexRentColorBike;
    private final String textRentCommentForCourier;


    public CheckOrderBike(String textOwnerName, String textOwnerSurname,String textOwnerAddress, int indexOwnerSubway,String textOwnerPhoneNumber, int indexRentWhenArrivedDate,int indexRentRentalPeriod,int indexRentColorBike,String textRentCommentForCourier) {
        this.textOwnerName = textOwnerName;
        this.textOwnerSurname = textOwnerSurname;
        this.textOwnerAddress = textOwnerAddress;
        this.indexOwnerSubway = indexOwnerSubway;
        this.textOwnerPhoneNumber = textOwnerPhoneNumber;
        this.indexRentWhenArrivedDate = indexRentWhenArrivedDate;
        this.indexRentRentalPeriod = indexRentRentalPeriod;
        this.indexRentColorBike = indexRentColorBike;
        this.textRentCommentForCourier = textRentCommentForCourier;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {"Никита", "Кологривый","г Новосибирск, ул Ленина, д 1, кв 107", 1,"+79137895672",0,1,0,"Позвоните перед доставкой"},
                {"Алексей", "Багровый","г Москва, ул Преображенского, д 56", 2,"+79137895688",3,4,1,"Оставьте у двери"},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void checkConfirmOrderWithHeaderButton() {
        //System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderBikeButtons orderBikeButtons = new OrderBikeButtons(driver);
        orderBikeButtons.clickOrderHeaderButton();

        DataBikeOwner dataBikeOwner = new DataBikeOwner(driver);
        dataBikeOwner.waitForLoadBikeOwnerData();
        dataBikeOwner.fillDataBikeOwner(textOwnerName,textOwnerSurname,textOwnerAddress,indexOwnerSubway,textOwnerPhoneNumber);

       DataAboutRent dataAboutRent = new DataAboutRent(driver);
        dataAboutRent.waitForLoadAboutRentData();
        dataAboutRent.fillDataAboutRent(indexRentWhenArrivedDate,indexRentRentalPeriod,indexRentColorBike,textRentCommentForCourier);

        BlockConfirmOrder blockConfirmOrder = new BlockConfirmOrder(driver);
        String expectedTextConfirmRent="Заказ оформлен";
        blockConfirmOrder.ConfirmOrderForRentBikeAndCheckAllowConfrim(expectedTextConfirmRent);
    }

    @Test
    public void checkConfirmOrderWithMiddleButton() {
        //System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderBikeButtons orderBikeButtons = new OrderBikeButtons(driver);
        orderBikeButtons.clickOrderMiddleButton();

        DataBikeOwner dataBikeOwner = new DataBikeOwner(driver);
        dataBikeOwner.waitForLoadBikeOwnerData();
        dataBikeOwner.fillDataBikeOwner(textOwnerName,textOwnerSurname,textOwnerAddress,indexOwnerSubway,textOwnerPhoneNumber);

        DataAboutRent dataAboutRent = new DataAboutRent(driver);
        dataAboutRent.waitForLoadAboutRentData();
        dataAboutRent.fillDataAboutRent(indexRentWhenArrivedDate,indexRentRentalPeriod,indexRentColorBike,textRentCommentForCourier);

        BlockConfirmOrder blockConfirmOrder = new BlockConfirmOrder(driver);
        String expectedTextConfirmRent="Заказ оформлен";
        blockConfirmOrder.ConfirmOrderForRentBikeAndCheckAllowConfrim(expectedTextConfirmRent);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
