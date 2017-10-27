package me.sn00pbom.boomboomchess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static WebDriver webDriver;

    public static void main(String[] args) {

//        System.setProperty("webdriver.chrome.driver", "chromedriver");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        

        webDriver = new ChromeDriver();
        webDriver.get("http://www.amazon.com/");
    }

}

