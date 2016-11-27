public class Messager {
    private final String name;

    public Messager(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public synchronized void sendMessage(Messager source) {
        System.out.println(getName() + ": Got message from " + source.getName());
        source.echoMessage(this);
    }
    public synchronized void echoMessage(Messager source) {
        System.out.println(getName() + ": " + source.getName() + " echoed message back");
    }
}
