package qa.guru.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import qa.guru.owner.config.ApiConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiTest {

    @Test
    public void apiConfigRemoteFileTest() throws IOException {
        String content = "token=osehf3486hsrh3w8jkwf";
        Path props = Paths.get("C:\\Windows\\Temp\\api.properties");

        Files.write(props, content.getBytes(StandardCharsets.UTF_8));

        ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertThat(config.getToken()).isEqualTo("osehf3486hsrh3w8jkwf");
        assertThat(config.getBaseUrl()).isEqualTo("https://github.com/");

        Files.delete(props);
    }

    @Test
    public void apiConfigLocalFileTest() {
        ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertThat(config.getToken()).isEqualTo("657sdf");
        assertThat(config.getBaseUrl()).isEqualTo("https://github.com/");
    }
}
