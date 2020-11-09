package Crashkurs.Uebung1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainFrame extends JFrame {
    private JButton login;
    private JTextFieldWithPlaceholder username;
    private JTextFieldWithPlaceholder password;
    private JLabel jLabel;

    MainFrame() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        jLabel = new JLabel();
        jLabel.setText("Bitte Benutzername und Passwort eingeben!");
        getContentPane().add(jLabel);

        username = new JTextFieldWithPlaceholder("Benutzername");
        getContentPane().add(username);

        password = new JTextFieldWithPlaceholder("Passwort");
        getContentPane().add(password);

        login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!username.isEmpty()){
                    if(!password.isEmpty()){
                        new Login(new String[]{username.getText(),password.getText()},true);
//                        System.out.println(username.getText()+":"+password.getText());
                    }else{
                        JOptionPane.showMessageDialog(null,"Kein Passwort angegeben!","Fehler", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Kein Benutzername angegeben!","Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getContentPane().add(login);

    }
}
