package Ex03;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Ivan", 5000);
        User user2 = new User("Mihail", 7000);
        User user3 = new User("Sasha", 2000);

        Transaction trans1 = new Transaction(user1, user2, 100);
        Transaction trans2 = new Transaction(user2, user3, 200);
        Transaction trans3 = new Transaction(user1, user2, 300);

        TransactionsLinkedList linkedList = new TransactionsLinkedList();
        linkedList.AddTransaction(trans1);
        linkedList.AddTransaction(trans2);
        linkedList.AddTransaction(trans3);

        user1.setList(linkedList);

        for (int i = 0; i < linkedList.countTrans; ++i) {
            System.out.println(user1.getList().toArray()[i].getIdentifier());
            System.out.println(user1.getList().toArray()[i].getRecipient().getName());
            System.out.println(user1.getList().toArray()[i].getSender().getName());
        }

        System.out.println("Id trans1 = " + trans1.getIdentifier());
        user1.getList().RemoveTransactionById(trans1.getIdentifier());

        for (int i = 0; i < linkedList.countTrans; ++i) {
            System.out.println(user1.getList().toArray()[i].getIdentifier());
            System.out.println(user1.getList().toArray()[i].getRecipient().getName());
            System.out.println(user1.getList().toArray()[i].getSender().getName());
        }

    }
}
