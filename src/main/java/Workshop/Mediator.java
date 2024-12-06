package Workshop;

import java.util.Optional;

public interface Mediator {

    void addToLoggedInUsers(User user);
    Optional<User> findUserById(String userId);

    Optional<Message> createMessage(String content, User from, User to);
    void deliverMessage(User sender, String recipientId, String content);
}
