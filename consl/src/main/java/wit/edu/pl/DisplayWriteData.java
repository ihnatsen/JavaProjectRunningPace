package wit.edu.pl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class DisplayWriteData implements Display,Observer,Subject {

    ArrayList<Observer> observers = new ArrayList<>();
    static Scanner INPUT = new Scanner(System.in);

    @Override
    public void display() {
        ArrayList<String> attributes = new ArrayList<>();
        String[] nameAttributes ={"trainingTimes","PACE","calories","Distance","temperature","Music",
                "trainingLocation","water","WARM_UP","CAT","SLEEP"};
        for(int i =0; i< nameAttributes.length; ++i){
            if(i == 1) {
                attributes.add(null);
                continue;}
            System.out.printf("Write value attribute: %s\n",nameAttributes[i]);
            attributes.add(INPUT.next());
        }

        String[] hourMinSec = attributes.get(0).split(":");
        Integer hour   = Integer.parseInt(hourMinSec[0])*60;
        Integer min     = Integer.parseInt(hourMinSec[1]);
        Integer sec     = Integer.parseInt(hourMinSec[0])/60;
        Integer timeMIN = hour + min + sec;
        Double distance = Double.parseDouble(attributes.get(3));

        String pace = String.format("%2f",((double) timeMIN / distance)).replace(',','.');
        attributes.set(1,pace);
        try {
            CRUDUtiels.writeData((attributes));
            notifyObserver(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update() {
        display();
    }

    @Override
    public void registerObserver(Observer... observer) {
        this.observers.addAll(Arrays.asList(observer));
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);

    }

    @Override
    public void notifyObserver(Integer com) {
        this.observers.get(com).update();
    }
}
