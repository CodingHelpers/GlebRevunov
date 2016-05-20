package revunov.gleb.lab6_1;

import static revunov.gleb.lab6_1.FormattedInput.scanf;
import static revunov.gleb.lab6_1.FormattedInput.sscanf;

public class Main {

    public static void main(String[] args) {
	    Object[] in  = scanf("%d %f %c %s");
        for (Object o : in) {
            System.out.print(o + " ");
        }
        System.out.println();

        Object[] ins  = sscanf("%f %d %c", "5.9 3 R");
        for (Object o : ins) {
            System.out.print(o + " ");
        }
        System.out.println();

    }

    public static void usage() {
        System.out.println("java lab6_1 \"%d %f %s %c\"");
    }
}
