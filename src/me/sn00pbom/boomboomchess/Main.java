package me.sn00pbom.boomboomchess;

import me.sn00pbom.boomboomchess.util.Inputs;
import me.sn00pbom.boomboomchess.util.Numbers;
//import me.sn00pbom.boomboomchess.ChessClient.*;

import java.util.Scanner;

public class Main {

    private static final int numBots = 1;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        System.out.println(Numbers.rngInt(10000000,99999999));

        

        AccountController accountController = new AccountController();
        accountController.populateBots(Inputs.getInt("Enter number of bots: "));

        Scanner in = new Scanner(System.in);
        String input;
        while(true){
            System.out.println("startall, stopall");
            input = in.nextLine();
            if(input.equals("startall")){
                accountController.startAll();
            }else if(input.equals("stopall")){
                accountController.stopAll();
            }else if(input.equals("quit")){
                //System.exit(0);
            }else{
                System.out.println("Not a command");
            }
        }



    }

}

