package Ex03;

public interface UsersList {
   void AddUser(User user);
   User RetrieveUserById(int Id);
   User RetrieveUserByIndex(int index);
   int RetrieveNumberUsers();
}
