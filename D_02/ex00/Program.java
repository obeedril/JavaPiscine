package ex00;

import com.sun.corba.se.impl.orbutil.HexOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {

        HashMap<String, String> fileSignature = new HashMap<>();
        String str = "";
        String[] words = null;
        try (FileInputStream input = new FileInputStream("/Users/obeedril/Desktop/javaBass/D_02/src/ex00/signatures.txt")) {
            int read = 0;
            while ((read = input.read()) != -1) {
                if ((char) read == '\n') {
                    words = str.split(", ");
                    fileSignature.put(words[1], words[0]);
                    str = "";
                    continue;
                }
                str += (char) read;
//                System.out.println("str: " +str);
            }
            words = str.split(", ");
            fileSignature.put(words[1], words[0]);
            str = "";
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        String path;

        int k = 0;
        StringBuilder sbr;
        while (sc.hasNext()) {
            sbr = new StringBuilder();
            path = sc.next();
            if (path.equals("42")) {
                return;
            }
            int maxcount = -1;
            try (FileInputStream fileInputStream = new FileInputStream(path)) {

                while ((k = fileInputStream.read()) != -1 && maxcount < 8) {
                    maxcount++;
                   // System.out.println("k = "+Integer.toHexString(k));
                    if (Integer.toHexString(k).length() == 1)
                        sbr.append('0');
                    sbr.append(Integer.toHexString(k) + " ");
                    //System.out.println("k = "+Integer.toHexString(k));

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
           // System.out.println("sbr: " +sbr.toString().toUpperCase());
            int flag = 0;
            for (HashMap.Entry<String, String> entry : fileSignature.entrySet()) {
                String key = entry.getKey();
                if (sbr.toString().toUpperCase().startsWith(key)) {
                    flag = 1;
                    try (FileOutputStream fileIn = new FileOutputStream("result.txt", true)) {
                        for (int i = 0; i < entry.getValue().length(); i++) {
                            fileIn.write(entry.getValue().charAt(i));
                        }
                        fileIn.write('\n');
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("PROCESSED");
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("UNDEFINED");
            }
        }
    }
}
