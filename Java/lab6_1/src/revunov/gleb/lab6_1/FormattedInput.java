package revunov.gleb.lab6_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class FormattedInput {
    public static Object[] scanf(String format) {
        while(true) {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                return doParsing(format, input);
            } catch (NumberFormatException e) {
                System.out.println("Input is invalid, please try again");
            } catch (IOException e) {
                System.out.println("Fatal error");
                System.exit(1);
            }
        }
    }

    public static Object[] sscanf(String format, String in) {
        while(true) {
            try {
                BufferedReader input = new BufferedReader(new StringReader(in));
                return doParsing(format, input);
            } catch(Exception e) {
                System.out.println("Error parsing string");
            }
        }
    }

    private static Object[] doParsing(String format, BufferedReader input) throws IOException, NumberFormatException {
        String[] tokens = format.split(" ");

        int len = 0;
        Object[] objects = new Object[tokens.length];

        int ch;
        String temp = "";
        do {
            ch = input.read();
            if(ch == ' ' || ch == '\n' || ch == -1) {
                objects[len] = parse(temp, tokens[len++]);
                temp = "";
            } else {
                temp += (char) ch;
            }

            if(len >= tokens.length) {
                break;
            }
        } while(ch != -1);

        return objects;
    }

    private static Object parse(String word, String token) throws NumberFormatException {
        if(token.equals("%d")) {
            return Integer.parseInt(word);
        }

        if(token.equals("%f")) {
            return Double.parseDouble(word);
        }

        if(token.equals("%c")) {
            if(word.length() != 1) {
                throw new NumberFormatException();
            }
            return word.charAt(0);
        }

        if(token.equals("%s")) {
            return word;
        }

        return null;
    }
}
