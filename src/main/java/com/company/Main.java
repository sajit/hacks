package com.company;

import dp.Fibonacci;
import dp.LongestPalindrome;
import dp.MakeChangeCount;
import dp.MaxSumSequence;
import recursion.KPNoR;
import recursion.KPWitR;
import recursion.MakeChange;
import recursion.MinMakeChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
	// write your code here
        int[] arr = {-5,-4,3,6,1};
        LOGGER.info("Max sum = " + MaxSumSequence.maxSum(arr));
        Fibonacci.reverse(6,5,8);

        LOGGER.info("KnapSack Integer and Non Repeating " + KPNoR.maxVal(2, 8));
        LOGGER.info("KnapSack Integer and Non Repeating DP" + dp.KPNoR.maxVal(8,2));
        LOGGER.info("KnapSack Integer and Repeating " + KPWitR.maxVal(2,8));
        LOGGER.info("KnapSack Integer and Repeating DP " + dp.KPWitR.maxVal(8));

        LOGGER.info("Max length palindrome " + LongestPalindrome.longestPalLength("abbba"));

        LOGGER.info(" Make Change " + MakeChange.numWays(3,15));

        LOGGER.info("Minimum Make Change " + MinMakeChange.numCoins(3,25));

        LOGGER.info("DP Make Change " + MakeChangeCount.countWays(15));
    }


}
