package com.bridgelabz;
import java.util.Scanner;

public class StockAccount extends StockPortfolio {
    static Scanner sc = new Scanner(System.in);
    /*  balance     -   cash balance
    *   noOfStocks  -   number of stocks in portfolio
    *   noOfShares  -   shares[i] = number of shares of stock i
    *   symbol      -   stocks[i] = symbol of stock i
    *   sharePrice  -   price of share
    *  */
    private int noOfStocks;
    private static double balance;
    private int[] noOfShares;
    private String[] symbol;
    private double[] sharePrice;
    StockAccount() {
        System.out.println("Enter balance: ");
        balance = sc.nextDouble();
        System.out.println("Enter no. of stocks: ");
        noOfStocks = sc.nextInt();
        noOfShares = new int[noOfStocks];
        symbol = new String[noOfStocks];
        sharePrice = new double[noOfStocks];
        for (int i = 0; i < noOfStocks; i++) {
            System.out.println("Enter symbol: ");
            symbol[i] = sc.next();
            System.out.println("Enter No. of shares of "+symbol[i]);
            noOfShares[i] = sc.nextInt();
            System.out.println("Enter share price of "+symbol[i]);
            sharePrice[i] = sc.nextDouble();
        }
    }
    public void valueOf() {
        double total = 0;
        for (int i = 0; i < noOfStocks; i++) {
            total+=calculateStockValue(noOfShares[i], sharePrice[i]);
        }
        System.out.println("Stock value: "+total);
    }
    public void buy(int amount, String symbol) {
        if (balance-amount >= 0)
            System.out.println("You bought shares of "+symbol+" of amount "+amount+
                    " Rs. and balance remaining is "+(balance-amount));
        else
            System.out.println("You cannot buy. Insufficient balance. The balance in your account is "+balance);
    }
    public void sell(int amount, String symbol) {
        System.out.println(symbol+" is sold.");
        balance += amount;
        System.out.println("Current balance: "+balance);
    }
    public void printReport() {
        double total = balance;
        System.out.println("---------------Report-----------");
        for (int i = 0; i < noOfStocks; i++) {
            int amount = noOfShares[i];
            total += amount * sharePrice[i];
            System.out.println("Share price of Amount: "+amount+" "+symbol[i]+
                    " share is "+sharePrice[i]+" with total value: "+amount*sharePrice[i]);
        }
        System.out.println("Balance: "+ balance);
        System.out.println("Total: "+ total);
        System.out.println("-------------------------------");
    }
    public void menu(){
        int choice;
        do {
            System.out.println("Enter a number to perform action: \n1. Go to Stock Account " +
                    "\n2. Buy share \n3. Sell Share \n4. Get Stock value \n5. Display report \n0. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    new StockAccount();
                    break;
                case 2:
                    buy(12, "MSFT");
                    break;
                case 3:
                    sell(10, "MSFT");
                    break;
                case 4:
                    valueOf();
                    break;
                case 5:
                    printReport();
                    break;
                case 0:
                    System.out.println("Exit!");
                    break;
                default:
                    System.out.println("Invalid option selected.");
                    break;
            }
        }while (choice != 0);
    }
    public static void main(String[] args) {
        StockAccount stockAccount = new StockAccount();
        stockAccount.menu();
    }
}
