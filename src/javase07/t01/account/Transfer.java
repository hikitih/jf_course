package javase07.t01.account;

public class Transfer extends Thread {
    Account from;
    Account to;
    int amount;
    int number;
    private boolean run;

    public Transfer(int number, Account from, Account to, int amount){
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.number = number;
        run = true;
    }

    public void stopThread(){
        run = false;
    }

    public String toString(){
        return "Transfer #"+number+": "+amount+" from "+from.number+" to "+to.number;
    }

    public void run(){
        while (run) {
            synchronized (from) {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    System.out.println("Transfer #" + number + ": Withdraw " + amount + " from account " + from.number);
                } else {
                    System.out.println("Transfer #" + number + ": Not enough money on account " + from.number);
                }
            }
            synchronized (to) {
                to.deposit(amount);
                System.out.println("Transfer #" + number + ": Deposit " + amount + " to account " + to.number);
            }
        }
        this.stopThread();
    }
}
