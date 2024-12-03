package Workshop;

import java.time.ZonedDateTime;
import java.util.Optional;

public interface Mediator {

    public void addUser(User user);
    public Optional<User> findUser(String userId);



    public Optional<Message> createMessage(String id, ZonedDateTime creationTime, String content, User from, User to);
    public boolean deliverMessage(User sender, String recipientId, String content);
    public String getUserId();
    public String getMessageId();
}
