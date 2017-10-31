package me.sn00pbom.boomboomchess;

import org.openqa.selenium.WebDriver;

import java.util.*;

public class AccountController {
    //instantiated class to take id inputs from bots, confirm emails from chess.com, create accounts on chess.com, write files containing bot info

    public static WebDriver driver;
    //TODO
    public static HashMap<String,Boolean> accounts = new HashMap<String,Boolean>();
    public static ArrayList<ChessClient> chessClients = new ArrayList<>();
    private final String pass = "1234567890qwerty";


//    public AccountController(){
//
//
//
//    }

    public void getAccounts(String filePath){
        //loop through file and add strings to accounts list
    }

    public static boolean accountStatus(String acct){
        if(accounts.containsKey(acct)){
            return accounts.get(acct);
        }else{
            return false;

        }
    }

    public static void populateBots(int number){
        //int current = 0;
        Timer tick = new Timer();
        for(int i = 0; i<number; i++){
            chessClients.add(new ChessClient(ChessClient.Chessmode.PRIVATE));
        }
//        tick.schedule(new TimerTask(){
//            public void run(){
//                chessClients.add(new ChessClient(ChessClient.Chessmode.PRIVATE));
//
//
//
//
//            }
//        },1000); //1 second delay, 1 second tick interval
    }
    public static void startAll(){
        ClientController.startTimer();
        for(ChessClient client : chessClients){
            client.startDriver();
        }
    }
    public static void stopAll(){
        ClientController.stopTimer();
        for(ChessClient client : chessClients){
            client.stopDriver();
        }
    }

}
