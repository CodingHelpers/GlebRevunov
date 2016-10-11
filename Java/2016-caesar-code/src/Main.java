import java.util.ArrayList;

public class Main {
    public static ArrayList<Character> ALPHABET = new ArrayList<>();

    public static void main(String[] args) {
        // Подготовка листа с алфавитом
        for(char c : "абвгдеёжзиклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray()) {
            ALPHABET.add(c);
        }

        String mode;
        int key;
        String input;

        // Извлечение аргументов
        try {
            mode = args[0];
            key = Integer.parseInt(args[1]);
            input = args[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            help();
            return;
        }

        // Выбор действия или вывод помощи
        if(mode.equals("e") || mode.equals("encode")) {
            System.out.println(encode(input, key));
        } else if(mode.equals("d") || mode.equals("decode")) {
            System.out.println(decode(input, key));
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

    private static String encode(String inputStr, int key) {
        char[] input = inputStr.toCharArray();
        StringBuilder output = new StringBuilder();

        for (char c : input) {
            output.append(rotate(c, key));
        }

        return output.toString();
    }

    private static String decode(String input, int key) {
        key = ALPHABET.size() - key;
        return encode(input, key);
    }

    private static Character rotate(char c, int key) {
        int originalIndex = ALPHABET.indexOf(c);

        if(originalIndex == -1) {
            return c;
        }

        int rotatedIndex = (originalIndex + key) % ALPHABET.size();
        return ALPHABET.get(rotatedIndex);
    }
}
