package Workshop;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App implements Mediator {

    private final List<User> users;

    private static App instance;

    private int lastUserId = 0;
    private int lastMessageId = 0;

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
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public Optional<User> findUser(String userId) {
        return users.stream().filter(p -> p.getId().equals(userId)).findFirst();
    }

    @Override
    public boolean deliverMessage(User sender, String recipientId, String content) {
        User recipient = findUser(recipientId).orElse(null);
        Message message = null;

        if(sender != null && recipient != null){
            message = new Message(content, sender, recipient);
            recipient.receiveMessage(message);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public Optional<Message> createMessage(String id, ZonedDateTime creationTime,
                                           String content, User from, User to) {
        return Optional.of(new Message(content, from, to));
    }

    @Override
    public String getUserId() {
        lastUserId++;
        return String.valueOf(lastUserId);
    }

    @Override
    public String getMessageId() {
        lastMessageId++;
        return String.valueOf(lastMessageId);
    }


}

