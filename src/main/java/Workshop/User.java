package Workshop;

public abstract class User {
    protected String id;
    protected String username;
    private Message[] inbox;
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
        app.createMessage();
        app.deliverMessage(this.id, recipientId, content);
    };

    Message[] receiveMessage(Message message){};

    Message[] readMessage(int idx){};

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
