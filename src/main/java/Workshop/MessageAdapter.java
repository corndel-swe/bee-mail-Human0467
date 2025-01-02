package Workshop;

public class MessageAdapter implements Message {
    private ExternalMessage externalMessage;
    private Boolean hasBeenDelivered = false;

    @Override
    public String log() {
        return externalMessage.getBody();
    }

    @Override
    public Boolean markDelivered() {
        if(!hasBeenDelivered) {
            hasBeenDelivered = true;
        } else {
            System.out.println("message already marked as hasBeenDelivered");
        }
        return hasBeenDelivered;
    }

    @Override
    public Boolean markAsRead() {
        if(externalMessage.isRead()){
            return true;
        } else {
            externalMessage.toggleRead();
            return true;
        }
    }
}
