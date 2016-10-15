import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter input filename: ");
        String filename = sc.nextLine();
        System.out.print("Enter key: ");
        int key = sc.nextInt();

        try {
            BufferedReader input = new BufferedReader(new FileReader(new File(filename)));
            BufferedWriter encoded_out = new BufferedWriter(new FileWriter(new File("encoded_" + filename)));

            encode_file(input, encoded_out, key);

            input.close();
            encoded_out.close();

            BufferedReader encoded_in = new BufferedReader(new FileReader(new File("encoded_" + filename)));
            BufferedWriter decoded_out = new BufferedWriter(new FileWriter(new File("decoded_" + filename)));

            decode_file(encoded_in, decoded_out, key);

            encoded_in.close();
            decoded_out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void encode_file(BufferedReader input, BufferedWriter output, int key) {
        input.lines().forEach((str) -> {
             try {
                 output.write(Encoder.encode(str + "\n", key));
             } catch (IOException e) {
                 e.printStackTrace();
                 System.exit(2);
             }
        });
    }

    private static void decode_file(BufferedReader input, BufferedWriter output, int key) {
        input.lines().forEach((str) -> {
            try {
                output.write(Decoder.decode(str, key));
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(2);
            }
        });
    }

    private static void help() {
        System.out.println(
                "java Main" + " MODE KEY STRING\n\n" +
                "Modes: encode, decode\n"
        );
    }
}
