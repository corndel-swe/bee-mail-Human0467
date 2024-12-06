package Workshop;

import java.util.ArrayList;
import java.util.List;

public abstract class User {

    private String id;
    private String username;
    private List<Message> inbox = new ArrayList<>();
    private MessengerApp messengerApp;

    public User(String id, String username){
        this.id = id;
        this.username = username;
    }

    void login(MessengerApp messengerApp){
        messengerApp.addToLoggedInUsers(this);
        this.messengerApp = messengerApp;
    };

    void sendMessage(String recipientId, String content){
        messengerApp.deliverMessage(this, recipientId, content);
    };

    void receiveMessage(Message message){
        inbox.add(message);
    };

    void readMessageAtIndex(int idx){
        try {
            Message message = inbox.get(idx);
            System.out.println(message.log());
            message.markAsRead();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid message id.");
        }

    };

    public String getId() {
        return id;
    }

}
