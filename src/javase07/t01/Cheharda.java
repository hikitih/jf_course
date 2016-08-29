package javase07.t01;

import javase07.t01.account.Account;
import javase07.t01.account.Transfer;

public class Cheharda {
    public static void main(String[] args) {
        AccountsAndTransactions accountsAndTransactions = new AccountsAndTransactions();
        accountsAndTransactions.readDataFromFile("./src/javase07/t01/data/data.txt");
        try {
            for (Transfer transfer : accountsAndTransactions.transfers) {
                transfer.start();
            }
            //Thread.sleep(1);
            for (Transfer transfer : accountsAndTransactions.transfers) {
                transfer.stopThread();
                transfer.join();
            }
        } catch (InterruptedException e){
            System.out.println("Кто осмелился прервать главный поток?");
        }
        System.out.println("\nTransactions closed. Current balances are: ");
        for (Integer key: accountsAndTransactions.accounts.keySet()){
            Account account = accountsAndTransactions.accounts.get(key);
            System.out.println(account);
        }
    }
}
