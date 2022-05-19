package com.bridgelabz;

import java.util.Scanner;

public class Account {
    public static void debit(double amount){
        double balance = 5000;
        if (balance-amount >= 0)
            System.out.println("You have withdraw "+amount+" and balance in your account is "+(balance-amount));
        else
            System.out.println("Insufficient balance. The balance in your account is "+balance);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to withdraw: ");
        double amountToWithdraw = sc.nextDouble();
        debit(amountToWithdraw);
    }
}
