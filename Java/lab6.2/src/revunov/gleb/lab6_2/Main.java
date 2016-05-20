package revunov.gleb.lab6_2;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        if(args.length != 4) {
            System.out.println("usage: java EncodingConverter in.txt out.txt utf8 cp1251");
            System.exit(1);
        }

        String infilename = args[0];
        String outfilename = args[1];
        String inenc = args[2];
        String outenc = args[3];
        
        Charset inCharSet = Charset.forName(inenc);
        Charset outCharSet = Charset.forName(outenc);

        try {
            BufferedReader in = new BufferedReader(new FileReader(infilename));
            FileOutputStream out = new FileOutputStream(outfilename);

            String str;
            while((str = in.readLine()) != null) {
                str += '\n';
                CharBuffer cb = inCharSet.decode(ByteBuffer.wrap(str.getBytes()));
                ByteBuffer bb = outCharSet.encode(cb);

                byte[] outdata = bb.array();
                out.write(outdata);
            }

            in.close();
            out.close();
        } catch (Exception var15) {
            System.out.println(var15.getMessage());
        }

    }
}
