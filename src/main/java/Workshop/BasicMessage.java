package Workshop;

import java.time.ZonedDateTime;
import java.util.UUID;

public class BasicMessage implements Message {
    private final String id;
    private final ZonedDateTime creationTime;
    private final String content;
    private final User from;
    private final User to;
    private Boolean hasBeenDelivered = false;
    private Boolean hasBeenRead = false;

    public BasicMessage(String content, User from, User to) {
        this.id = UUID.randomUUID().toString();
        this.creationTime = ZonedDateTime.now();
        this.content = content;
        this.from = from;
        this.to = to;
    }

    @Override
    public String log() {
        return "Message{" +
                "id='" + id + '\'' +
                ", creationTime=" + creationTime +
                ", content='" + content + '\'' +
                ", from=" + from +
                ", to=" + to +
                ", hasBeenDelivered=" + hasBeenDelivered +
                ", hasBeenRead=" + hasBeenRead +
                '}';
    }

    @Override
    public Boolean markDelivered(){
        if(!hasBeenDelivered) {
            hasBeenDelivered = true;
        } else {
            System.out.println("message already marked as hasBeenDelivered");
        }
        return hasBeenDelivered;
    }

    @Override
    public Boolean markAsRead(){
        if(!hasBeenRead) {
            hasBeenRead = true;
        } else {
            System.out.println("message already marked as read");
        }
        return hasBeenRead;
    }

}
