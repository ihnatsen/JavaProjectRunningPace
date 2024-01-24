package wit.edu.pl;

import wit.edu.pl.Achievements.Achievements;
import wit.edu.pl.Achievements.BeverageAchievements;
import wit.edu.pl.Rarity.Rarity;

import static java.util.Arrays.fill;

class Display {

    CondimentDecoratorAchievements goal;



    public Display(CondimentDecoratorAchievements goal) {

        this.goal = goal;
    }

    void printNTree(CondimentDecoratorAchievements goal,
                    boolean[] flag,
                    int depth, boolean isLast) {

        if (goal == null)
            return;

        for (int i = 1; i < depth; ++i) {

            if (flag[i] == true) {
                System.out.print("| "
                        + " "
                        + " "
                        + " ");
            }


            else {
                System.out.print(" "
                        + " "
                        + " "
                        + " ");
            }
        }


        if (depth == 0)
            System.out.println(goal.getAttributesString());


        else if (isLast) {
            System.out.print("+--- " + goal.getAttributesString() + '\n');


            flag[depth] = false;
        } else {
            System.out.print("+--- " +goal.getAttributesString() + '\n');
        }

        int it = 0;
        for (BeverageAchievements i : goal.getChildren()) {
            ++it;

            printNTree(goal.createNewDecorator(i), flag, depth + 1,
                    it == (goal.getChildren().size()) - 1);
        }
        flag[depth] = true;
    }

    void formAndPrintTree() {
        Integer nv = this.goal.getNumNode();

        boolean[] flag = new boolean[nv];
        fill(flag, true);

        printNTree(goal, flag, 0, false);
    }

    public static void main(String[] args) {
        Achievements achievements1 = new ReaderAchievements().getRootAchievements("Default.json");
        Rarity rarity = new ReaderRarity().getRarity("Default.xml");
        CondimentDecoratorAchievements decoratorAchievements = new Goal(achievements1,rarity);
        Display display = new Display(decoratorAchievements);
        display.formAndPrintTree();
    }
}


