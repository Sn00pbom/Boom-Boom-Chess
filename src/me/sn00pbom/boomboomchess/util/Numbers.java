package me.sn00pbom.boomboomchess.util;

import java.util.ArrayList;
import java.util.Random;

public class Numbers {
    public static int rngInt(int min, int max){
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    @Deprecated
    public static double rngDouble(double min, double max){
        Random random = new Random();
        //double r = rand.nextDouble();
        //return rand.nextDouble((long)(max - min) + 1) + min;
        //return r;
        return random.nextDouble() * (max - min) + max;
    }
    public static boolean isPrime(double num){
        ArrayList<Double> factors = new ArrayList<Double>();
        for(double factor = 1; factor <= num; factor ++ ){
            double out = num / factor;

            if(isWholeNumber(out) == true && out != 1 && out != num){
                factors.add(factor);
                break;
            }
        }
        if(factors.size() == 0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isWholeNumber(double num){
        String snum = "" + num;
        int periodLoc = -1;
        int length = snum.length();
        for( int i  = 0; i<length; i++){
            if(snum.charAt(i) == '.'){
                periodLoc = i;
            }
        }
        if(periodLoc == -1){
            return true;
        }
        for(int j = periodLoc+1; j<length;j++){
            if(snum.charAt(j) != '0'){
                return false;
            }
        }
        return true;

    }
}