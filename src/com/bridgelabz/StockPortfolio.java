package com.bridgelabz;

import java.util.Scanner;

public class StockPortfolio {
    static Scanner sc = new Scanner(System.in);
    public static void getStockDetails(){
        System.out.println("Enter number of stocks: ");
        int n = sc.nextInt();
        String shareName[] = new String[n];
        int noOfShares[] = new int[n];
        double sharePrice[] = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Share Name: ");
            shareName[i] = sc.next();
            System.out.println("Enter number of Shares: ");
            noOfShares[i] = sc.nextInt();
            System.out.println("Enter Share Price: ");
            sharePrice[i] = sc.nextDouble();
        }
        createStockReports(n, shareName, noOfShares, sharePrice);
    }
    public static void createStockReports(int noOfStocks, String[] shareName, int[] noOfShares, double[] sharePrice){
        System.out.println("-------------STOCKS REPORT-------------");
        System.out.println("StockNo. ShareName NoOfShares SharePrice StockValue");
        double stockValue, totalStockValue = 0.0;
        for (int i = 0; i < noOfStocks; i++) {
            stockValue = calculateStockValue(noOfShares[i], sharePrice[i]);
            System.out.println(" "+(i+1)+".\t\t"+shareName[i]+"\t\t"+noOfShares[i]+"\t\t"+sharePrice[i]+"\t\t"+stockValue);
            totalStockValue += stockValue;
        }
        System.out.println("\nTotal Stock Value is "+totalStockValue);
    }
    public static double calculateStockValue(int noOfShares, double sharePrice){
        return noOfShares*sharePrice;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Stock Management System!");
        getStockDetails();
    }
}
