public class Decoder {
    public static String decode(String input, int key) {
        key = Encoder.ALPHABET.size() - key;
        return Encoder.encode(input, key);
    }
}
