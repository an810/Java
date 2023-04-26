package Lesson4;

public class BankAccount {
    private String name;
    private double balance;

    public void withdraw(double amount) {
        if (amount > 0 && balance > amount) {
            balance -= amount;
        }
    }
    public void setName(String name) {
        this.name = name;
    }


}
