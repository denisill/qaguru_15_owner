package qa.guru.owner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import qa.guru.owner.config.WebDriverProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {

    private WebDriver driver = new WebDriverProvider().get();

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void testGithubTitle() {
        assertEquals("https://github.com/", driver.getCurrentUrl());
        driver.quit();
    }
}
