package ex00;

public class Program {
    public static void main(String[] args) {

        User user1 = new User("Ivan", 5000);
        System.out.println("ID: "+ user1.getIdentifier() + ", name: "+ user1.getName() + ", balance: " + user1.getBalance());

        User user2 = new User ("Sergey", 7000);
        System.out.println("ID: "+ user2.getIdentifier() + ", name: "+ user2.getName() + ", balance: " + user2.getBalance());

        User user3 = new User ("Mihail", 12000);
        System.out.println("ID: "+ user3.getIdentifier() + ", name: "+ user3.getName() + ", balance: " + user3.getBalance());

        Transaction trans1 = new Transaction(user1, user2, -1000);
        System.out.println("Transaction ID = "+trans1.getIdentifier());
        System.out.println("ID: "+ user1.getIdentifier() + ", name: "+ user1.getName() + ", balance: " + user1.getBalance());
        System.out.println("ID: "+ user2.getIdentifier() + ", name: "+ user2.getName() + ", balance: " + user2.getBalance());

    }

}
