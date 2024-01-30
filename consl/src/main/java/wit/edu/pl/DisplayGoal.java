package wit.edu.pl;

import wit.edu.pl.Achievements.BeverageAchievements;

import static java.util.Arrays.fill;

class DisplayGoal implements Observer,Display {

    CondimentDecoratorAchievements goal;



    public DisplayGoal(CondimentDecoratorAchievements goal) {

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
    @Override
    public void display() {
        Integer nv = this.goal.getNumNode();

        boolean[] flag = new boolean[nv];
        fill(flag, true);

        printNTree(goal, flag, 0, false);
        System.out.println();
    }

    @Override
    public void update() {
        this.display();
    }
}


