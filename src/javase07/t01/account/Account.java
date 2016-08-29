package javase07.t01.account;

public class Account {
    int number;
    int balance;

    public Account(int number, int money){
        this.number = number;
        setBalance(money);
    }

    public String toString(){
        return "Account "+number+" : "+balance;
    }

    public synchronized void setBalance(int money){
        balance = money;
    }

    public synchronized void deposit(int money) {
        if (money > 0) {
            balance += money;
        }
    }

    public synchronized void withdraw(int money) {
        if (money > 0) {
            balance -= money;
        }
    }

    public synchronized int getBalance(){
        return balance;
    }
}
