package ex00;

public class User {
    private int Identifier;
    private String Name;
    private long Balance;

    User(String Name, long Balance) {
        this.Name = Name;
        if (Balance < 0) {
            System.err.println("A balance can't be low than zero!");
            System.exit(-1);
        }
        this.Balance = Balance;

    }
    public String getName() {
        return (Name);
    }
    public void setName (String Name) {
        this.Name = Name;
    }
    public long getBalance() {
        return (Balance);
    }
    public void setBalance(long Balance) {
        this.Balance = Balance;
    }
    public int getIdentifier() {
        return(Identifier);
    }
}
