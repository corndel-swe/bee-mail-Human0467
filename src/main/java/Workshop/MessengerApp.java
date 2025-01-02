package Workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessengerApp implements Mediator {

    public static MessengerApp appInstance = new MessengerApp();
    private final List<User> loggedInUsers = new ArrayList<>();

    private MessengerApp() {}

    public static MessengerApp getAppInstance(){
//        if(appInstance == null){
//            appInstance = new MessengerApp();
//        } else {
//            System.out.println("instance already exists.");
//        }
        return appInstance;
    }

    @Override
    public void addToLoggedInUsers(User user) {
        loggedInUsers.add(user);
    }

    @Override
    public Optional<User> findUserById(String userId) {
        return loggedInUsers.stream().filter(p -> p.getId().equals(userId)).findFirst();
    }

    @Override
    public void deliverMessage(User sender, String recipientId, String content) {
        User recipient = this.findUserById(recipientId).orElse(null);

        if(sender != null && recipient != null) {
            BasicMessage message = createMessage(content, sender, recipient).get();
            recipient.receiveMessage(message);
            message.markDelivered();
        }
    }

    @Override
    public Optional<BasicMessage> createMessage(String content, User from, User to) {
        return Optional.of(new BasicMessage(content, from, to));
    }

}

