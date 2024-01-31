package wit.edu.pl;

import wit.edu.pl.Achievements.BeverageAchievements;
import wit.edu.pl.Rarity.Rarity;

import java.util.HashMap;
import java.util.List;

public class Goal extends CondimentDecoratorAchievements{

    static String NoneANSI = "\u001b[0m";
    BeverageAchievements achievements;

    Rarity rarity;

    public Goal(BeverageAchievements achievements,Rarity rarity) {
        this.achievements = achievements;
        this.rarity = rarity;

    }

    @Override
    public String getAttributesString() {

        String res = decorate(achievements.getAttributesString());

        if(getFlag()){
            res = "\033[9m" + res+ NoneANSI;
        }
        return res;

    }


    @Override
    public String getRarity() {
        return achievements.getRarity();
    }


    @Override
    public List<? extends BeverageAchievements> getChildren() {

        return this.achievements.getChildren();
    }


    @Override
    public Integer getNumNode(Integer zero) {
        return achievements.getNumNode(zero);
    }

    @Override
    public Integer getNumNode() {
        return achievements.getNumNode();
    }

    @Override
    public CondimentDecoratorAchievements createNewDecorator(BeverageAchievements beverageAchievements) {
        return new Goal(beverageAchievements, this.rarity);
    }

    @Override
    public Boolean getFlag() {
        return achievements.getFlag();
    }

    @Override
    public String getSql() {
        return achievements.getSql();
    }

    public void  setFlag(Boolean flag){
        this.achievements.setFlag(flag);
    }

    @Override
    public String getTitle() {

        return decorate(achievements.getTitle());
    }

    @Override
    public String getDescription() {
        return decorate(achievements.getDescription());
    }

    private String decorate(String aGet){
        String NoneANSI = "\u001b[0m";

        HashMap<String,String> theColors = new HashMap<>();

        theColors.put("WHITE","\033[38;2;178;195;217m");
        theColors.put("BLUE","\u001b[38;94;152;217m");
        theColors.put("CYAN","\033[38;2;75;105;255m");
        theColors.put("PURPLE","\33[38;2;211;44;230m");
        theColors.put("YELLOW","\33[38;2;255;165;0m");
        theColors.put("GREEN","\033[38;2;173;229;92m");
        theColors.put("RED","\033[38;2;255;3;62m");

        return  theColors.get(rarity.getTheColor(achievements.getRarity())) + aGet +NoneANSI;
    }


}



