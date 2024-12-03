package Workshop;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String id;
    protected String username;
    private List<Message> inbox = new ArrayList<>();
    private App app;

    public User(String id, String username){
        this.id = id;
        this.username = username;
    }

    void login(App app){
        app.addUser(this);
        this.app = app;
    };

    void sendMessage(String recipientId, String content){
        app.deliverMessage(this, recipientId, content);
    };

    void receiveMessage(Message message){
        inbox.add(message);
    };

    void readMessage(int idx){
        if(idx < inbox.size() && idx > - 1) {
            Message message = inbox.get(idx);
            System.out.println(message.toString());
        } else {
            System.out.println("Invalid message id.");
        }

    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
