package me.sn00pbom.boomboomchess;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.awt.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ChessClient {
    //instantiated class to create a shit ton of tabs playing chess games. each instantiated class has its own tab and
    //is registered in the main class arraylist.

    public enum Chessmode{
        PUBLIC,
        PRIVATE
    }
    private enum BotState{
        SPLASH("//*[@id=\"header\"]/div[1]/div/a","//*[@id=\"header\"]/div[1]/div/a"),
        LOGIN_SCREEN("//*[@id=\"vertical-nav\"]/div[1]/a[6]/button","//*[@id=\"vertical-nav\"]/div[1]/a[6]/button"),
        CREDENTIAL_SCREEN("asdf2","target2"),
        MATCH_SETUP("asdf3","target3"),
        IN_MATCH_START("asdf4","target4"),
        IN_MATCH_OPPONENTTURN("asdf5","target5"),
        IN_MATCH_MYTURN("asdfjk6","target6"),
        IN_MATCH_END("asdf7","target7");

        private String identifyElement;
        private String targetElement;

        BotState(String identifyElement, String targetElement){
            this.identifyElement = identifyElement;
            this.targetElement = targetElement;
        }

        public String getIdentifyElement(){
            return identifyElement;
        }
        public String getTargetElement(){
            return targetElement;
        }
        public void click(){

        }
    }


    private Chessmode mode = null;
    private WebDriver driver;
    private String id = "-1";
    public Credential cred;
    private boolean active = false;

    public ChessClient(Chessmode mode){
        this.driver = new ChromeDriver();
        this.mode = mode;
        driver.get("file:"+ System.getProperty("user.dir")+ "/splash.png");
        driver.manage().window().setPosition(new Point((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()-100,0));


    }

    public void startDriver(){
        driver.get("http://chess.com/");
        this.active = true;

    }
    public void startDriver(String path){
        driver.get(path);
        this.active = true;

    }
    public void stopDriver(){
        try{
            driver.close();
            this.active = false;
        }catch (Exception e){
            System.out.println("ERROR: Either the timer wasn't started or the driver didn't exist.");
        }

    }


    /*


    8888888888888888888888888THIS IS WHERE THE MAGIC HAPPENS888888888888888888888888888888888


     */
    public void automateTick(){

        System.out.println("db");
        try{
            BotState state = scanState();
            if(state == BotState.SPLASH){
                driver.findElement(By.xpath(BotState.SPLASH.getTargetElement())).click();
            } else if(state == BotState.LOGIN_SCREEN){
                System.out.println("db2");
                driver.findElement(By.xpath(BotState.LOGIN_SCREEN.getTargetElement())).click();
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    private BotState scanState(){
        if(scanElements(BotState.SPLASH.getIdentifyElement()).size() != 0)return BotState.SPLASH;

        else if(scanElements(BotState.SPLASH.getIdentifyElement()).size() != 0)return BotState.LOGIN_SCREEN;
        return null;
    }

    private List<WebElement> scanElements(String xpath){

        return driver.findElements(By.xpath(xpath));
    }


    /*
    GETTER SETTER
     */
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
