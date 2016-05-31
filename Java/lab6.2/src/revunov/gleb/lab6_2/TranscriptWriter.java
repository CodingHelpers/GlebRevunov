package revunov.gleb.lab6_2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TranscriptWriter {
    public TranscriptWriter(String filename) throws FileNotFoundException {
        out = new FileOutputStream(filename);
    }

    public void write(String a) throws IOException {
        for(int i = 0; i < a.length(); i++) {
            write(a.charAt(i));
        }
    }

    public void write(char a) throws IOException {
        String t = "";
        switch (a) {
            case 'а': t = "a";  break;
            case 'б': t = "b";  break;
            case 'в': t = "v";  break;
            case 'г': t = "g";  break;
            case 'д': t = "d";  break;
            case 'е': t = "e";  break;
            case 'ё': t = "yo"; break;
            case 'ж': t = "zh"; break;
            case 'з': t = "z";  break;
            case 'и': t = "i";  break;
            case 'й': t = "j";  break;
            case 'к': t = "k";  break;
            case 'л': t = "l";  break;
            case 'м': t = "m";  break;
            case 'н': t = "n";  break;
            case 'о': t = "o";  break;
            case 'п': t = "p";  break;
            case 'р': t = "r";  break;
            case 'с': t = "s";  break;
            case 'т': t = "t";  break;
            case 'у': t = "u";  break;
            case 'ф': t = "f";  break;
            case 'х': t = "h";  break;
            case 'ц': t = "c";  break;
            case 'ч': t = "ch"; break;
            case 'ш': t = "sh"; break;
            case 'щ': t = "sh"; break;
            case 'ъ': t = "";   break;
            case 'ы': t = "i";  break;
            case 'ь': t = "";   break;
            case 'э': t = "a";  break;
            case 'ю': t = "y";  break;
            case 'я': t = "ya"; break;
            case 'А': t = "A";  break;
            case 'Б': t = "B";  break;
            case 'В': t = "V";  break;
            case 'Г': t = "G";  break;
            case 'Д': t = "D";  break;
            case 'Е': t = "E";  break;
            case 'Ё': t = "Yo"; break;
            case 'Ж': t = "Zh"; break;
            case 'З': t = "Z";  break;
            case 'И': t = "I";  break;
            case 'Й': t = "J";  break;
            case 'К': t = "K";  break;
            case 'Л': t = "L";  break;
            case 'М': t = "M";  break;
            case 'Н': t = "N";  break;
            case 'О': t = "O";  break;
            case 'П': t = "P";  break;
            case 'Р': t = "R";  break;
            case 'С': t = "S";  break;
            case 'Т': t = "T";  break;
            case 'У': t = "U";  break;
            case 'Ф': t = "F";  break;
            case 'Х': t = "H";  break;
            case 'Ц': t = "C";  break;
            case 'Ч': t = "Ch"; break;
            case 'Ш': t = "Sh"; break;
            case 'Щ': t = "Sh"; break;
            case 'Ъ': t = "";   break;
            case 'Ы': t = "I";  break;
            case 'Ь': t = "";   break;
            case 'Э': t = "A";  break;
            case 'Ю': t = "Y";  break;
            case 'Я': t = "Ya"; break;
            default: t += a;
        }
        out.write(t.getBytes());
    }

    private FileOutputStream out;
}
