package ex01;

public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    static int id;
    private UserIdsGenerator(){
        id = 1;
    }
    public static UserIdsGenerator getInstance(){
        if (instance == null) {
            instance = new UserIdsGenerator();
        } else {
            id++;
        }
        return instance;
    }

    public static int generateId() {
        return id;
    }
}
