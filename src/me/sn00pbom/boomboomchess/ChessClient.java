package me.sn00pbom.boomboomchess;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
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
        SPLASH, LOGIN_SCREEN, CREDENTIAL_SCREEN, MATCH_SETUP, IN_MATCH
    }

    private Chessmode mode = null;
    private WebDriver driver;
    private Timer tick;
    public Credential cred;

    public ChessClient(Chessmode mode){
        this.driver = new ChromeDriver();
        this.mode = mode;
        driver.get("file:"+ System.getProperty("user.dir")+ "/splash.png");
        driver.manage().window().setPosition(new Point((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-100,0));


    }

    public void startDriver(){
        driver.get("http://chess.com/");
        startTimer();

    }
    public void startDriver(String path){
        driver.get(path);
        startTimer();

    }
    public void stopDriver(){
        try{
            driver.close();
            tick.cancel();
        }catch (Exception e){
            System.out.println("ERROR: Either the timer wasn't started or the driver didn't exist.");
        }

    }
    private void startTimer(){
        //*[@id="vertical-nav"]/div[1]/a[6]/button   login button front page
        //login

        tick = new Timer();
        tick.schedule(new TimerTask(){
            public void run(){
                automateTick();

            }
        },1000,1000); //1 second delay, 1 second tick interval
    }

    /*


    8888888888888888888888888THIS IS WHERE THE MAGIC HAPPENS888888888888888888888888888888888


     */
    private void automateTick(){


    }

}
