package qa.guru.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/C:/Windows/Temp/api.properties",
        "classpath:api.properties"
})
public interface ApiConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://github.com/")
    String getBaseUrl();

    @Key("token")
    String getToken();
}