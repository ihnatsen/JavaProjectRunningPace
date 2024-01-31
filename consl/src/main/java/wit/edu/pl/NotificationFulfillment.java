package wit.edu.pl;

import wit.edu.pl.Achievements.BeverageAchievements;

import java.math.BigDecimal;

public class NotificationFulfillment implements Observer {

    CondimentDecoratorAchievements goals;

    public NotificationFulfillment(CondimentDecoratorAchievements goals) {
        this.goals = goals;
    }

    @Override
    public void update() {

        this.foo(this.goals);
    }

    public void foo(CondimentDecoratorAchievements goals) {


        if (!!!goals.getFlag()) {

            Iterator<Object> flagIt = CRUDUtiels.writeSelect(goals.getSql());
            goals.setFlag(((BigDecimal) flagIt.next()).intValue() == 1);


            if (goals.getFlag()) {
                System.out.println("Congratulations,you have achieved:");
                System.out.println(goals.getTitle());
                System.out.println(goals.getDescription());
                System.out.println();
                for (BeverageAchievements ach : goals.getChildren()) {
                    foo(goals.createNewDecorator(ach));
                }
            }
        } else {
            for (BeverageAchievements ach : goals.getChildren()) {
                foo(goals.createNewDecorator(ach));
            }
        }

    }

}
