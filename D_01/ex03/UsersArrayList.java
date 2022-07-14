package Ex03;

public class UsersArrayList implements UsersList {
    private int size = 10;
    private User[] UsersArray = new User[size];
    private int countUsers = 0;

    @Override
    public void AddUser(User user) {

        if (countUsers < size) {
            UsersArray[countUsers] = user;
          //  System.out.println("ID: "+UsersArray[countUsers].getIdentifier()+" Name: "+UsersArray[countUsers].getName()+ " balance "+UsersArray[countUsers].getBalance());
        } else {
            size += size/2;
            User[] tmp = new User[size];
            for (int i = 0; i < countUsers; ++i) {
                tmp[i] = UsersArray[i];
            }
            UsersArray = tmp;
            UsersArray[countUsers] = user;
           // System.out.println("ID: "+UsersArray[countUsers].getIdentifier()+" Name: "+UsersArray[countUsers].getName()+ " balance "+UsersArray[countUsers].getBalance());
        }
        System.out.println("ID: "+UsersArray[countUsers].getIdentifier()+" Name: "+UsersArray[countUsers].getName()+ " balance "+UsersArray[countUsers].getBalance());
        ++countUsers;
    }

    class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    @Override
    public User RetrieveUserById(int Id) throws UserNotFoundException {
        for (int i = 0; i < countUsers; ++i) {
            if (Id == UsersArray[i].getIdentifier())
                return (UsersArray[i]);
        }
        throw new UserNotFoundException("The user with Id "+ Id +" not found");
    }

    @Override
    public User RetrieveUserByIndex(int index) throws UserNotFoundException {
        for (int i = 0; i < countUsers; ++i) {
            if (i == index) {
                return (UsersArray[i]);
            }
        }
        throw new UserNotFoundException("The user with Id "+ index +" not found");
    }

    @Override
    public int RetrieveNumberUsers() {
        return (countUsers);
    }
}

