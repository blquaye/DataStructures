package GreedyAlgo;

import java.util.Arrays;

public class MinimumCoin {
    public static void coinchange(int [] coins, int totalAmount){
//        Sort coins
        Arrays.sort(coins);
        int index = coins.length-1;
        while (true){
            int coinValue = coins[index];
            index--;
            int maximum = (totalAmount/coinValue)*coinValue;
            if(maximum > 0){
                System.out.println("Coin Value: " + coinValue + " taken count." + (totalAmount/coinValue));
                totalAmount =  totalAmount -maximum;
            }
            if (totalAmount == 0)break;
        }
    }

    public static void main(String[] args) {
        int [] coinsDenomination = {25,10,5};
        int total = 50;
        System.out.println("Coins Availble: " +  Arrays.toString(coinsDenomination));
        System.out.println("Target Anount: " + total);
        MinimumCoin.coinchange(coinsDenomination,total);
    }
}
