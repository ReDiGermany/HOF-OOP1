package Crashkurs.Uebung1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class JTextFieldWithPlaceholder extends JTextField {
    public boolean isEmpty(){
        return (this.getText().equals(this.placeholder) || this.getText().equals(""));
    }
    public String placeholder;
    public JTextFieldWithPlaceholder(String placeholder){
        super(placeholder);
        this.placeholder = placeholder;
        this.setForeground(Color.GRAY);
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextField t = (JTextField)e.getSource();
                if (t.getText().equals(placeholder)) {
                    t.setText("");
                    t.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                JTextField t = (JTextField)e.getSource();
                if (t.getText().isEmpty()) {
                    t.setForeground(Color.GRAY);
                    t.setText(placeholder);
                }
            }
        });
    }
}
