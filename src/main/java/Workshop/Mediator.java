package Workshop;

public interface Mediator {

    public User addUser(User user);
    public User findUser(String userId);
    public Message deliverMessage(String senderId, String recipientId, String content);
}
