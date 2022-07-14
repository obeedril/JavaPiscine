package ex02;

public class Program {

    public static void main(String[] args) {
        User user1 = new User("Ivan", 5000);
        User user2 = new User("Mihail", 7000);
        User user3 = new User("Sasha", 2000);
        User user4 = new User("Vasili", 20000);
        User user5 = new User("Masha", 8000);
        User user6 = new User("Sveta", 19000);
        User user7 = new User("Tania", 9000);
        User user8 = new User("Olga", 11000);
        User user9 = new User("Oksana", 15000);
        User user10 = new User("Tolia", 7000);
        User user11 = new User("Pavel", 1000);

        UsersList list1 = new UsersArrayList();
        list1.AddUser(user2);
        list1.AddUser(user1);
        list1.AddUser(user3);
        list1.AddUser(user4);
        list1.AddUser(user5);
        list1.AddUser(user6);
        list1.AddUser(user7);
        list1.AddUser(user8);
        list1.AddUser(user9);
        list1.AddUser(user10);
        list1.AddUser(user11);


        System.out.println("User name: "+list1.RetrieveUserById(1).getName());
        System.out.println("User name: "+list1.RetrieveUserById(3).getName());
        System.out.println("User name: "+list1.RetrieveUserByIndex(3).getName());
        System.out.println("count users = "+list1.RetrieveNumberUsers());
    }

}
