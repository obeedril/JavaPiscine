package Ex03;


public class User {
    private int Identifier;
    private String Name;
    private long Balance;
    private TransactionsList list;

    User(String _Name, long _Balance) {
        Name = _Name;
        if (_Balance < 0) {
            System.err.println("A balance can't be low than zero!");
            System.exit(-1);
        }
        Balance = _Balance;
        Identifier = UserIdsGenerator.getInstance().generateId();

    }
    public String getName() {
        return (Name);
    }
    public void setName (String _Name) {
        Name = _Name;
    }
    public long getBalance() {
        return (Balance);
    }
    public void setBalance(long _Balance) {
        Balance = _Balance;
    }
    public int getIdentifier() {
        return(Identifier);
    }

    public TransactionsList getList(){
        return(list);
    }

    public void setList(TransactionsList list) {
        this.list = list;
    }
}
