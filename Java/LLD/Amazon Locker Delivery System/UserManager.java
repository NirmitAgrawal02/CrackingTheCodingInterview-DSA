package LLD.Amazon

import java.util.*;


class UserManager {
    static int uid;
    List<User> users;
    private static UserManager instance;
    UserManager()
    {
        uid = 1;
        users = new ArrayList<>();
    }
    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
    public void addUser(String name, String address, String phoneNumber) {
        User user = new User(uid ++, name, address, phoneNumber);
        users.add(user);
    }
    public void removeUser(int uuid) {
        User user = users.get(uuid);
        users.remove(user);
    }

    public List getUsers() {
        return users;
    }

    public void setUsers(List users) {
        this.users = users;
    }
}