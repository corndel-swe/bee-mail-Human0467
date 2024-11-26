package Workshop;

import java.util.ArrayList;
import java.util.List;

public class App implements Mediator {

    private List<User> users;

    private static App instance;

    private App () {
        this.users = new ArrayList<>();
    }

    public static App getInstance(){
        if(instance == null){
            instance = new App();
        } else {
            System.out.println("instance already exists.");
        }

        return instance;
    }

    @Override
    public User addUser(User user) {
        users.add(user);
    }

    @Override
    public User findUser(String userId) {
        return null;
    }

    @Override
    public Message deliverMessage(String senderId, String recipientId, String content) {
        return null;
    }
}
