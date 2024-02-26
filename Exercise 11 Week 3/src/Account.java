public class Account {

    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNeme(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int credit(int amount) {
        if (amount<=this.balance) {
            this.balance-=amount;
            return this.balance;
        }
        else {
            System.out.println("Sorry, Your balance is not enough\nNothing has changed");
        }

        return this.balance;
    }

    public int debit(int amount) {
        this.balance +=amount;
        return this.balance;
    }

    public int transferTo(Account another, int amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            another.setBalance(another.getBalance() + amount);
            System.out.println("Transferring was successful!");
            return amount;
        } else {
            System.out.println("Sorry, the transfer failed due to insufficient funds");
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID='" + getId() + '\'' +
                "\nName='" + getName()+ '\'' +
                "\nBalance=" + getBalance()+
                '}';
    }
}