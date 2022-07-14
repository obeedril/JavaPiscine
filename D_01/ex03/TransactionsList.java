package Ex03;

public interface TransactionsList {
    void AddTransaction(Transaction transaction);
    void RemoveTransactionById(String Id);
    Transaction[] toArray();

}