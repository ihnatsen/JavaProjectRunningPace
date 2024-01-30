package wit.edu.pl;

import wit.edu.pl.Achievements.BeverageAchievements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App implements Subject {
    static Scanner input = new Scanner(System.in);
    List<Observer> observers = new  ArrayList<>();
    static Integer flag;
    static BeverageAchievements goal;
    static Observer dis1,dis2,dis3,dis4;




    @Override
    public void registerObserver(Observer ... observers) {
        for(Observer obs: observers){this.observers.add(obs);}

    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);

    }

    @Override
    public void notifyObserver(Integer com) {
        observers.get(com).update();

    }

    private static Integer getFlag() {
        File file = new File(PathToDir.getPathToResourcesFile("reader", "flag.txt"));
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader reader = new BufferedReader(fileReader);
            String flag = null;
            while ((flag = reader.readLine()) != null) {
                return Integer.parseInt(flag);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static void main(String[] args) {

        App.goal = getGoal(new Goal(new ReaderAchievements().getRootAchievements(),
                new ReaderRarity().getRarity()));




        App.flag = getFlag();
        dis1 = new DisplayGoal((CondimentDecoratorAchievements) goal);
        dis2 = new DisplayRanting();
        dis3 = new DisplayDataSet();
        dis4 = new DisplayWriteData();

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
                SaveProgress.save(1);
                SaveProgress.save(goal);
                break;
            }
            System.out.println();
            runningPace.notifyObserver(com);

        }

    }

    public static BeverageAchievements getGoal(BeverageAchievements goal) {
        return getFlag()>0 ? (BeverageAchievements) LoadingProgress.loadingProgress():
                goal;

    }



    }
