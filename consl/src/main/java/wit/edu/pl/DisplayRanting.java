package wit.edu.pl;

import java.util.Map;

public class DisplayRanting implements Observer, Display {

    static String NoneANSI = "\u001b[0m";
    static String ANSIMinus = "\033[38;2;255;3;62m";
    static String ANSIPlus = "\033[38;2;0;191;255m";

    static MathModule<Integer> corrKid = new CorrelationKid();
     Map<String,Integer> ranting = corrKid.getRanting();


    public void display() {

        if(ranting.isEmpty()){
            System.out.println("You must have at least 5 records for rating. :(");
        }

        int maxSpace = 0;
        for (String att : ranting.keySet()){
            maxSpace = (att + ranting.get(att)).length() + ranting.get(att).toString().length();
        }

        for(String att: ranting.keySet()){
            int numSpace = maxSpace-(att+ ranting.get(att)).length()+ranting.get(att).toString().length();

            String space = " ".repeat(Math.max(0, numSpace)) + " |";
            StringBuilder stick = new StringBuilder();
            String fillChar  = ranting.get(att)>0 ? "+" : "-";
            stick.append(fillChar.repeat(Math.max(0, Math.abs(ranting.get(att)))));

            String ANSI = ranting.get(att)>0 ? ANSIPlus: ANSIMinus;

            String number = ranting.get(att) > 0 ? "+": "";
            number+= ranting.get(att);

            String answer = ANSI + att + " " + number + space + stick + NoneANSI ;
            System.out.println(answer);
        }
        System.out.println();
    }

    @Override
    public void update() {
        display();
    }


}
