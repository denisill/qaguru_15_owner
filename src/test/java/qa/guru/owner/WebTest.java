package qa.guru.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import qa.guru.owner.config.WebConfig;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebTest {

    @Test
    public void webDriverConfigLocalTest() {
        System.setProperty("environment", "local");
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
        assertThat(config.getBrowser()).isEqualTo("FIREFOX");
        assertThat(config.getBaseUrl()).isEqualTo("https://yandex.ru");
        assertThat(config.getVersionBrowser()).isEqualTo("94.0");
    }

    @Test
    public void webDriverConfigRemoteTest() {
        System.setProperty("environment", "remote");
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
        assertThat(config.getBrowser()).isEqualTo("CHROME");
        assertThat(config.getRemoteUrl()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub/");
        assertThat(config.getVersionBrowser()).isEqualTo("91.0");
    }
}
