package com.bridgelabz;

import java.util.Scanner;

public class StockPortfolio {
    static Scanner sc = new Scanner(System.in);
    public static void getStockDetails(){
        System.out.println("Enter number of stocks: ");
        int n = sc.nextInt();
        String shareName;
        int noOfShares;
        double sharePrice = 0.0, stockValue = 0.0, totalStockValue = 0.0;
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter Share Name: ");
            shareName = sc.next();
            System.out.println("Enter number of Shares: ");
            noOfShares = sc.nextInt();
            System.out.println("Enter Share Price: ");
            sharePrice = sc.nextDouble();
            stockValue = calculateStockValue(noOfShares, sharePrice);
            System.out.println("Stock value for Share"+i+", "+shareName+" is "+stockValue);
            totalStockValue += stockValue;
        }
        System.out.println("Total stock value is "+totalStockValue);
    }
    public static double calculateStockValue(int noOfShares, double sharePrice){
        return noOfShares*sharePrice;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Stock Management System!");
        getStockDetails();
    }
}
