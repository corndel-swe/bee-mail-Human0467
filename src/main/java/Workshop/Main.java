package Workshop;

public class Main {

    public static void main(String[] args) {

        MessengerApp messengerApp = MessengerApp.getAppInstance();

        BasicUser alice = new BasicUser("101", "alice");
        BasicUser bob = new BasicUser("102", "bob");
        BasicUser carol = new BasicUser("932", "carol");

        alice.login(messengerApp);
        bob.login(messengerApp);
        carol.login(messengerApp);

        alice.sendMessage("102", "hello bob");
        carol.sendMessage("102", "hi bob");
        bob.sendMessage("101", "hello alice");

        bob.readMessageAtIndex(0);
        bob.readMessageAtIndex(1);
        alice.readMessageAtIndex(0);
    }
}
