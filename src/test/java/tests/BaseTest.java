package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import utils.Utils;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    public void setup(@Optional("Chrome") String browser) throws URISyntaxException, IOException {
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "EdgeDriver":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:// open Chrome browser by default
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Utils.readProperty("applicationUrl"));

//        WebDriverManager webDriverManager = WebDriverManager
//                .chromedriver()
//                .browserInDocker()
//                .enableVnc()
//                .enableRecording();
//        driver = webDriverManager
//                .create();
//        Desktop.getDesktop().browse(webDriverManager.getDockerNoVncUrl().toURI());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

//    public void createRemoteDriver(String browser) throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        switch (browser) {
//            case "chrome":
//                capabilities.setBrowserName("chrome");
//                capabilities.setVersion("99.0");
//                break;
//            case "firefox":
//                capabilities.setBrowserName("firefox");
//                capabilities.setVersion("98.0");
//                break;
////            default: // use chrome by default in case no string is matched
////                capabilities.setBrowserName("chrome");
////                capabilities.setVersion("99.0");
////                break;
//        }
//
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true));
//        capabilities.setCapability("videoName", this.getClass().getName() + "_"
//                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_mm_ss")));
//         capabilities.setCapability("screenResolution","1280x1024x24");
//         driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(),capabilities);
//    }
}
