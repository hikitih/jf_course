package javase07.t01;

import javase07.t01.account.Account;
import javase07.t01.account.Transfer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class AccountsAndTransactions {
    HashMap<Integer, Account> accounts;
    HashSet<Transfer> transfers;

    public AccountsAndTransactions(){
        accounts = new HashMap<>();
        transfers = new HashSet<>();
    }

    public void readDataFromFile(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            int transferCounter = 1;
            Scanner lineScanner = new Scanner(br);
            while (lineScanner.hasNextLine()){
                Scanner scanner = new Scanner(lineScanner.nextLine());
                while (scanner.hasNext()){
                    String s = scanner.next("\\w");
                    if (s.equals("A")){
                        int number = Integer.parseInt(scanner.next("\\w+"));
                        int balance = Integer.parseInt(scanner.next("\\d+"));
                        System.out.println("Account "+number+" with balance "+balance+" created");
                        Account account = new Account(number, balance);
                        accounts.put(number, account);
                    }
                    if (s.equals("T")){
                        int num1 = Integer.parseInt(scanner.next("\\d+"));
                        int num2 = Integer.parseInt(scanner.next("\\d+"));
                        int balance = Integer.parseInt(scanner.next("\\d+"));
                        if (accounts.get(num1)!=null && accounts.get(num2)!=null) {
                            Transfer transfer = new Transfer(transferCounter, accounts.get(num1), accounts.get(num2), balance);
                            System.out.println(transfer+" created");
                            transferCounter++;
                            transfers.add(transfer);
                        }
                    }
                }
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
