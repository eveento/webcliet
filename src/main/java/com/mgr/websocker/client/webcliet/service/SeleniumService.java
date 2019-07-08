package com.mgr.websocker.client.webcliet.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Service
public class SeleniumService {

    private final String url="http://localhost:8099";

//    {
//        Properties properties = System.getProperties();
//        url = properties.getProperty("server.selenium.url");
//
//    }

    @Value("${chrome.option}")
    private String chromeOptions;

    private ChromeDriverService chromeDriverService;

    private final static By CONNECT = By.id("connect");

    @Autowired
    public SeleniumService(ChromeDriverService chromeDriverService) {
        this.chromeDriverService = chromeDriverService;
    }

    private WebDriver prepareDriver(final ChromeDriverService chromeDriverService) {
        final ChromeOptions options = new ChromeOptions();
        final String[] opts = chromeOptions.split("#");
        options.addArguments(opts);
        options.addArguments("--whitelisted-ips 127.0.0.1");
        options.setExperimentalOption("useAutomationExtension", false);
        ChromeDriver chromeDriver = new ChromeDriver(chromeDriverService, options);
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return chromeDriver;
    }

    private void clickElement(WebElement webElement) {
        webElement.click();
    }

    private void setConnection(final WebDriver driver, final By shareButtonElem) {
        driver.navigate().to(url);
        final WebElement shareButton = driver.findElement(shareButtonElem);
        clickElement(shareButton);
    }

    @Scheduled(fixedRate = 999999999)
    public void startSelenium() {
        final WebDriver driver = prepareDriver(chromeDriverService);
        setConnection(driver, CONNECT);
    }
}
