package Crashkurs.Uebung1;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

class Login {
    private Map<String,String> users = new HashMap<>();
    private void log(String text){
        if(this.noLogging) this.logs.add(text);
        else System.out.println(text);
    }
    private List logs = new List();
    private void sendLogs(){
        if(this.noLogging){
            String out = "";
            for(int i=0;i<logs.getItemCount();i++){
                out += logs.getItem(i)+"\n";
            }
            JOptionPane.showMessageDialog(null,out,"Stupid Login", JOptionPane.PLAIN_MESSAGE);
//            System.out.println(out);
        }
    }
    private boolean noLogging = false;
    public Login(String[] args,boolean noLogging){
        this.noLogging = noLogging;
        if(args.length!=2){
            log("Bitte geben Sie 2 Argumente an <user> <password>");
            return;
        }
        try {
            String content = Files.readString(Paths.get("userdata.txt"), StandardCharsets.UTF_8).
                    replaceAll("\\r","");
            String[] contentArray = content.split("\\n");
            for (String s : contentArray) {
                users.put(
                    s.split(":")[0],  // username
                    s.split(":")[1]   // password
                );
            }
            if(users.containsKey(args[0])){
                log("Benutzer "+args[0]+" gefunden.");
                if(users.get(args[0]).equals(args[1])){
                    log("Passwort korrekt!");
                }else{
                    log("Passwort falsch!");
                }
            }else{
                log("Der Benutzer "+args[0]+" existiert nicht.");
            }

        } catch (IOException e) {
            log("Fehler in der Benutzerdatenbank!");
        }
        sendLogs();
    }
}
