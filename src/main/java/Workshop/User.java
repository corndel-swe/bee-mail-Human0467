package Workshop;

public abstract class User {
    private String id;
    private String username;
    private Message[] inbox;
    private App app;

    private User(String id, String username){
        this.id = id;
        this.username = username;
    }

    void login(App app){
        this.app = app;
    };

    Message sendMessage(String recipientId, String content){};

    Message[] receiveMessage(Message message){};

    Message[] readMessage(int idx){};

}
