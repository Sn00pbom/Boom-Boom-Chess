package me.sn00pbom.boomboomchess;

import java.util.Timer;
import java.util.TimerTask;

public class ClientController {
    private static Timer tick;
    public static void startTimer(){
        //*[@id="vertical-nav"]/div[1]/a[6]/button   login button front page
        //login
        //TODO
        tick = new Timer();
        tick.schedule(new TimerTask(){
            public void run(){
                //System.out.println("db");
                for(ChessClient chessClient : AccountController.chessClients){
                    if(chessClient.isActive()){
                        chessClient.automateTick();
                    }
                }

            }
        },1000,1000); //1 second delay, 1 second tick interval
    }
    public static void stopTimer(){
        tick.cancel();
    }
}
