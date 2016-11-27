public class Main {
    public static void main(String[] args) {
	    Messager first = new Messager("First");
        Messager second = new Messager("Second");

        new Thread(() -> first.sendMessage(second)).start();
        new Thread(() -> second.sendMessage(first)).start();
    }
}
