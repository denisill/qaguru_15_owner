package qa.guru.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${environment}.properties")
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("versionBrowser")
    String getVersionBrowser();

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();
}
