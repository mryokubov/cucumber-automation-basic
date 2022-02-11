import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by tairovich_jr on 2022-02-08.
 */
public class Main {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com");

        String pageSource = driver.getPageSource();

        System.out.println(pageSource);

    }
}
