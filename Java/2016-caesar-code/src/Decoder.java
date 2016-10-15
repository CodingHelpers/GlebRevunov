public class Decoder {
    public static String decode(String input, int key) {
        key = 256 - key;
        return Encoder.encode(input, key);
    }
}
