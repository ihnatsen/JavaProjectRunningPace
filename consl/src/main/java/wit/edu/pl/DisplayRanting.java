package wit.edu.pl;

import java.util.HashMap;

public class DisplayRanting implements Observer, Display {

    static String NoneANSI = "\u001b[0m";
    static String ANSIMinus = "\033[38;2;255;3;62m";
    static String ANSIPlus = "\033[38;2;0;191;255m";
    HashMap<String, Integer> ranting;

    public DisplayRanting(HashMap<String, Integer> ranting) {
        this.ranting = ranting;
    }

    public void display() {

        int maxSpace = 0;
        for (String att : ranting.keySet()){
            maxSpace = (att + ranting.get(att)).length()+1;
        }

        for(String att: ranting.keySet()){
            int numSpace = maxSpace-(att+ ranting.get(att)).length();
            String space = " ".repeat(Math.max(0, numSpace)) + " |";
            StringBuilder stick = new StringBuilder();
            String fillChar  = ranting.get(att)>0 ? "+" : "-";
            stick.append(fillChar.repeat(Math.max(0, Math.abs(ranting.get(att)))));

            String ANSI = ranting.get(att)>0 ? ANSIPlus: ANSIMinus;

            String answer = ANSI + att + " " + ranting.get(att) + space + stick + NoneANSI ;
            System.out.println(answer);
        }
    }

    @Override
    public void update() {
        display();
    }
}
