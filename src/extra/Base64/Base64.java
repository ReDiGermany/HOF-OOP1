package extra.Base64;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Base64 extends JFrame {
    public static void main(String[] args) throws IOException {

        MainFrame frame = new MainFrame();
        frame.setTitle("BASE64");
        frame.setSize(300, 130);
//        frame.setLocation(4000, 1000); // for testing for me
//        frame.setResizable(false);

        // Code ripof from stack overflow. could leave it out but its nicer this way https://stackoverflow.com/a/144950
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setVisible(true);
//        encode("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
//        encode("Hallo und hallo.");
//        encode("Übung");
//
//        decode("3GJ1bmc="); // Übung
//        decode("SGFsbG8gdW5kIGhhbGxvLg=="); // Hallo und hallo.
//        decode("TG9yZW0gaXBzdW0gZG9sb3Igc2l0IGFtZXQsIGNvbnNldGV0dXIgc2FkaXBzY2luZyBlbGl0ciwgc2VkIGRpYW0gbm9udW15IGVpcm1vZCB0ZW1wb3IgaW52aWR1bnQgdXQgbGFib3JlIGV0IGRvbG9yZSBtYWduYSBhbGlxdXlhbSBlcmF0LCBzZWQgZGlhbSB2b2x1cHR1YS4gQXQgdmVybyBlb3MgZXQgYWNjdXNhbSBldCBqdXN0byBkdW8gZG9sb3JlcyBldCBlYSByZWJ1bS4gU3RldCBjbGl0YSBrYXNkIGd1YmVyZ3Jlbiwgbm8gc2VhIHRha2ltYXRhIHNhbmN0dXMgZXN0IExvcmVtIGlwc3VtIGRvbG9yIHNpdCBhbWV0LiBMb3JlbSBpcHN1bSBkb2xvciBzaXQgYW1ldCwgY29uc2V0ZXR1ciBzYWRpcHNjaW5nIGVsaXRyLCBzZWQgZGlhbSBub251bXkgZWlybW9kIHRlbXBvciBpbnZpZHVudCB1dCBsYWJvcmUgZXQgZG9sb3JlIG1hZ25hIGFsaXF1eWFtIGVyYXQsIHNlZCBkaWFtIHZvbHVwdHVhLiBBdCB2ZXJvIGVvcyBldCBhY2N1c2FtIGV0IGp1c3RvIGR1byBkb2xvcmVzIGV0IGVhIHJlYnVtLiBTdGV0IGNsaXRhIGthc2QgZ3ViZXJncmVuLCBubyBzZWEgdGFraW1hdGEgc2FuY3R1cyBlc3QgTG9yZW0gaXBzdW0gZG9sb3Igc2l0IGFtZXQu"); // lorem ipsum
    }
    public static Map<String,String> loadList() throws IOException {
        return loadList(false);
    }
    public static Map<String,String> loadList(boolean reverse) throws IOException {
        String content = Files.readString(Paths.get("Table.Base64.txt"), StandardCharsets.UTF_8).replaceAll("\\r","");
        String[] contentArray = content.split("\\n");
        Map<String,String> data = new HashMap<>();
        for (String s : contentArray) {
            data.put(
                s.split(",")[reverse?1:0],  // bitsis
                s.split(",")[reverse?0:1]   // char
            );
        }
        return data;
    }
    public static String getBinary(char c){
        String ret = Integer.toBinaryString(c);
        while(ret.length()!=8){
            ret = "0"+ret;
        }
        return ret;
    }
    public static char getChar(String bits){
        return (char)Integer.parseInt(bits,2);
    }
    public static String encode(String input) throws IOException {
        Map<String, String> data = loadList();
        String binary = "";
        for(char c:input.toCharArray()){
            binary += getBinary(c);
        }
        int fills = 0;
        System.out.println(binary);
        while(binary.length() % 3 != 0){
            binary += "00000000";
            fills++;
        }
        char[] encoded = new char[binary.length()/6];
//        System.out.println(binary);
        String test = "";
        int counter = 0;
        for(int i=0;i<binary.length();i++){
            test += binary.charAt(i)+"";
            if(test.length()==6){
                encoded[counter]=data.get(test).charAt(0);
                counter++;
                test = "";
            }
        }
        for(int i=encoded.length-1;i>0;i--){
            if(fills>0){
                fills--;
                encoded[i]='=';
            }
        }
        System.out.println("> "+input+" \n< "+new String(encoded));
        return new String(encoded);
    }
    public static String decode(String input) throws IOException {
        Map<String, String> data = loadList(true);
        char[] chars = input.toCharArray();
        String bits = "";
        int fills = 0;
        for(int i=0;i<chars.length;i++) {
//            System.out.println(chars[i] + " | " + data.get(String.valueOf(chars[i])));
            if (chars[i] == '=') {
                bits += "000000";
                fills++;
            } else {
                bits += data.get(String.valueOf(chars[i]));
            }
        }
        for(int i=0;i<fills;i++){
            bits = bits.substring(0,bits.length()-8);
        }
//        System.out.println(bits);
        String[] strings = new String[bits.length()/8];
        int counter = -1;
        for(int i=0;i<bits.length();i++){
            if(i%8==0) counter++;
            if(strings[counter]==null) strings[counter]="";
            strings[counter] += String.valueOf(bits.charAt(i));
        }
        String out = "";
        for(int i=0;i<strings.length;i++){
            out += getChar(strings[i]);
        }
        System.out.println("> "+input+" \n< "+out);
        return out;
    }
}
