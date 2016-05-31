package revunov.gleb.lab6_2;

public class Main {
    public static void main(String[] args) {
        if(args.length != 4) {
            System.out.println("usage: java EncodingConverter in.txt out.txt utf8 cp1251");
            System.exit(1);
        }

        String russian_text = "Русский текст, который будет транскрибирован\n";
        String english_text = "English text, nothing will be changed\n";

        try {
            TranscriptWriter writer = new TranscriptWriter("out.txt");
            writer.write(russian_text);
            writer.write(english_text);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
