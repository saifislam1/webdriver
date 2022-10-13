package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basetest {

    private WebDriver driver;
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://creative-panda-1mkpql-dev-ed.lightning.force.com/lightning/page/home");
        System.out.println(driver.getTitle());
        driver.quit();
    }

    public static void main(String Args[]){
        basetest test = new basetest();
        test.setUp();

    }
}
