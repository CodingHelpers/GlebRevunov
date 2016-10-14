import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message: ");
        String input = sc.nextLine();

        System.out.print("Enter mode[d/e]: ");
        String mode = sc.next();

        System.out.print("Enter key[N]: ");
        int key = sc.nextInt();

        // Выбор действия или вывод помощи
        if(mode.equals("e") || mode.equals("encode")) {
            System.out.println(Encoder.encode(input, key));
        } else if(mode.equals("d") || mode.equals("decode")) {
            System.out.println(Decoder.decode(input, key));
        } else {
            help();
        }
    }

    private static void help() {
        System.out.println(
                "java Main" + " MODE KEY STRING\n\n" +
                "Modes: encode, decode\n"
        );
    }
}
