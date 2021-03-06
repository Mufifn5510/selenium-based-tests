package net.kozon.selenium.example.test.framework.common.owasp;

import net.kozon.selenium.example.test.framework.common.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.io.IOException;

/**
 * Created by Dariusz_Kozon on 06.11.2017.
 */
public class OwaspProxyGeckoDriverStrategy extends ProxyStrategy {

    @Override
    public WebDriver webDriver() throws IOException {
        return new FirefoxDriver(owaspZAPService(), owaspZAPOptions());
    }

    private FirefoxOptions owaspZAPOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setProxy(proxyConfig());
        return options;
    }

    private GeckoDriverService owaspZAPService() throws IOException {
        GeckoDriverService service = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File(Configuration.getPropertyFromFile("geckoDriver")))
                .usingAnyFreePort()
                .usingAnyFreePort()
                .build();
        service.start();
        return service;
    }
}
