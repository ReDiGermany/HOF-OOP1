package extra.Base64;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

class MainFrame extends JFrame {
    private JLabel jLabel;
    private JTextField rawtext, encoded;

    MainFrame() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        jLabel = new JLabel();
        jLabel.setText("Oben Text; Unten Base64!");
        getContentPane().add(jLabel);

        rawtext = new JTextField();
        getContentPane().add(rawtext);
        encoded = new JTextField();
        rawtext.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getModifiersEx()==0) {
                    try {
                        encoded.setText(Base64.encode(rawtext.getText()));
                        jLabel.setText("Oben Text; Unten Base64!");
                    } catch (IOException ex) {
//                        ex.printStackTrace();
                    }
                }
            }
        });
        encoded.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getModifiersEx()==0) {
                    try {
                        rawtext.setText(Base64.decode(encoded.getText()));
                        jLabel.setText("Oben Text; Unten Base64!");
                    } catch (Exception ex) {

                        jLabel.setText("Das ist kein Base64!");
                    }
                }
            }
        });

        getContentPane().add(encoded);

    }
}
