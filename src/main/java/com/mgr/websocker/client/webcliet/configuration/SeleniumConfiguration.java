package com.mgr.websocker.client.webcliet.configuration;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
public class SeleniumConfiguration {

    @Value("${chrome.driver.path}")
    private String chromeDriver;

    @Bean
    public ChromeDriverService startChromeDriverService() throws IOException{
        final ChromeDriverService chromeDriverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(chromeDriver))
                .usingPort(9515)
                .build();
        chromeDriverService.start();
        return chromeDriverService;
    }
}
