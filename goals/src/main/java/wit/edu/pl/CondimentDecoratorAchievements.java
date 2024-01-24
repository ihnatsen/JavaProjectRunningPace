package wit.edu.pl;

import wit.edu.pl.Achievements.BeverageAchievements;
import wit.edu.pl.Rarity.Rarity;

import java.util.List;

public abstract class CondimentDecoratorAchievements implements BeverageAchievements {

    public BeverageAchievements beverageAchievements;
    public Rarity rarity;
    List<? extends BeverageAchievements> children;


    public abstract String getAttributesString();


    public abstract List<?extends BeverageAchievements> getChildren();

    public abstract Integer getNumNode(Integer zero);
    public abstract Integer getNumNode();

    public abstract CondimentDecoratorAchievements createNewDecorator(BeverageAchievements beverageAchievements);

    public abstract Boolean getFlag();

}
