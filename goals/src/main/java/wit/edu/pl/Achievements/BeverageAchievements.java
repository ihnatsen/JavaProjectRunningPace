package wit.edu.pl.Achievements;

import java.util.List;

public interface BeverageAchievements  {

   public String getAttributesString();
   public String getRarity();

   public List<? extends BeverageAchievements> getChildren();

    public Integer getNumNode(Integer zero);
    public Integer getNumNode();
    public Boolean getFlag();
}
