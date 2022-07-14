package Ex03;

import ex02.UsersArrayList;

public class TransactionsLinkedList implements TransactionsList{

    private DataList transactionsList = null;
    int countTrans = 0;

    public class TransactionNotFoundException extends RuntimeException {
        public TransactionNotFoundException(String text) {
            super(text);
        }
    }

    @Override
    public void AddTransaction(Transaction transaction){
        DataList tmp = new DataList(transactionsList, transaction);
        this.transactionsList = tmp;
        this.countTrans++;
    }
    @Override
    public void RemoveTransactionById(String Id) throws TransactionNotFoundException {
        DataList list = this.transactionsList;
        for (int i = 0; i < countTrans; ++i, list = list.getNext()) {
            if(list.getTransaction().getIdentifier().equals(Id)){
                list = list.getNext();
                countTrans--;
                return ;
            }
        }
        throw new TransactionNotFoundException("Transaction not found");
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] array = new Transaction[countTrans];
        DataList tmp = this.transactionsList;
        for (int i = 0; i < countTrans; ++i) {
            array[i] = tmp.transaction;
            tmp = tmp.next;
        }
        return (array);
    }

    public DataList getTransactionsList(){
        return (transactionsList);
    }

    public int getCountTrans() {
        return countTrans;
    }

    class DataList {
        private Transaction transaction;
        private DataList next;

        DataList(DataList next, Transaction transaction) {
            this.transaction = transaction;
            this.next = next;
        }

        public Transaction getTransaction() {
            return transaction;
        }

        public void setTransaction(Transaction transaction) {
            this.transaction = transaction;
        }

        public DataList getNext() {
            return next;
        }

        public void setNext(DataList next) {
            this.next = next;
        }
    }

}

