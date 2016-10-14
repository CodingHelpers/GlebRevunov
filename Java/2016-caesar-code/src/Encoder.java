import java.util.ArrayList;

public class Encoder {
    public static ArrayList<Character> ALPHABET = new ArrayList<>();

    static {
        for(char c : "абвгдеёжзиклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray()) {
            ALPHABET.add(c);
        }
    }

    public static String encode(String inputStr, int key) {
        char[] input = inputStr.toCharArray();
        StringBuilder output = new StringBuilder();

        for (char c : input) {
            output.append(rotate(c, key));
        }

        return output.toString();
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
