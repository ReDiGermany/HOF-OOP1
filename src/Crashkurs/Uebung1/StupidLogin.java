package Crashkurs.Uebung1;

import javax.swing.*;
import java.awt.*;

/**
 * Kommando zum packen: javac Crashkurs.Uebung1/*.java && jar cfe StupidLogin.jar Crashkurs.Uebung1.StupidLogin Crashkurs.Uebung1\*.class && java -jar StupidLogin.jar
 */
public class StupidLogin extends JFrame {
    public static void main(String[] args){
        if(args.length==2) {
            new Login(args,false);
        }else {
            MainFrame frame = new MainFrame();
            frame.setTitle("Stupid Login");
            frame.setSize(300, 130);
//            frame.setLocation(4000, 1000); // for testing for me
            frame.setResizable(false);

            // Code ripof from stack overflow. could leave it out but its nicer this way https://stackoverflow.com/a/144950
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
            frame.setLocation(x, y);
            frame.setVisible(true);
        }
    }
}
