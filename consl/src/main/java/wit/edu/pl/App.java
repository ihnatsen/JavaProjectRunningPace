package wit.edu.pl;

import wit.edu.pl.Achievements.BeverageAchievements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App implements Subject {
    static Scanner input = new Scanner(System.in);
    List<Observer> observers = new ArrayList<>();

    static BeverageAchievements goal;
    static Observer dis1,dis2,dis3,dis4;


    @Override
    public void registerObserver(Observer ... observers) {
        this.observers.addAll(Arrays.asList(observers));

    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);

    }
    @Override
    public void notifyObserver(Integer com) {
        observers.get(com).update();

    }


    public static void main(String[] args) {

        App.goal = getGoal(new Goal(new ReaderAchievements().getRootAchievements(),
                new ReaderRarity().getRarity()));

        dis1 = new DisplayGoal((CondimentDecoratorAchievements) goal);
        dis2 = new DisplayRanting();
        dis3 = new DisplayDataSet();
        dis4 = new DisplayWriteData();


        NotificationFulfillment nf = new NotificationFulfillment((CondimentDecoratorAchievements) goal);
        DisplayWriteData displayWriteData = (DisplayWriteData) dis4;
        displayWriteData.registerObserver(nf);

        App runningPace = new App();

        //Registration obs______________________
        runningPace.registerObserver(dis1,dis2,dis3,dis4);

        System.out.println("Running Pace");
        System.out.println("\033[38;2;173;229;92m*JAVA Edition*\u001b[0m");
        while (true){
            System.out.println("1.Achievements");
            System.out.println("2.Ranting");
            System.out.println("3.Records");
            System.out.println("4.WriteData");
            System.out.println("5.Exit");
            System.out.println();
            System.out.println("Enter command:");
            int com = input.nextInt()-1;
            if(com==4){
                SaveProgress.save(goal);
                break;
            }
            System.out.println();
            runningPace.notifyObserver(com);

        }

    }

    public static BeverageAchievements getGoal(BeverageAchievements goal) {
        try {
            BeverageAchievements res = (BeverageAchievements) LoadingProgress.loadingProgress();
            return res;
        } catch (IOException e) {
            return goal;
        }

    }



    }
