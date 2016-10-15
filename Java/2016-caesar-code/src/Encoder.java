public class Encoder {
    public static String encode(String inputStr, int key) {
        char[] input = inputStr.toCharArray();
        StringBuilder output = new StringBuilder();

        for (char c : input) {
            output.append(rotate(c, key));
        }

        return output.toString();
    }

    private static Character rotate(char c, int key) {
        return (char) ((c + key) % 256);
    }
}
