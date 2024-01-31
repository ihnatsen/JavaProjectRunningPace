package wit.edu.pl;

import wit.edu.pl.Achievements.BeverageAchievements;
import wit.edu.pl.Rarity.Rarity;

import java.io.Serializable;
import java.util.List;

public abstract class CondimentDecoratorAchievements implements BeverageAchievements, Serializable {

    public BeverageAchievements beverageAchievements;
    public Rarity rarity;
    List<? extends BeverageAchievements> children;


    public abstract String getAttributesString();


    public abstract List<?extends BeverageAchievements> getChildren();

    public abstract Integer getNumNode(Integer zero);
    public abstract Integer getNumNode();

    public abstract CondimentDecoratorAchievements createNewDecorator(BeverageAchievements beverageAchievements);

    public abstract Boolean getFlag();

    public abstract String getSql();

    public abstract void  setFlag(Boolean flag);

    public abstract String getTitle();

    public abstract String getDescription();

}
