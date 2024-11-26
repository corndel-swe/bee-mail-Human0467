package Workshop;

public class Main {

    public static void main(String[] args) {

        App app = App.getInstance();

        BasicUser alice = new BasicUser("101", "alice");
        BasicUser bob = new BasicUser("102", "bob");

        alice.login(app);
        bob.login(app);


        alice.sendMessage("102", "hello bob");
    }
}
