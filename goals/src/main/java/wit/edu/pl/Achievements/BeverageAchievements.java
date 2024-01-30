package wit.edu.pl.Achievements;

import java.io.Serializable;
import java.util.List;

public interface BeverageAchievements extends Serializable {

   public String getAttributesString();
   public String getRarity();

   public List<? extends BeverageAchievements> getChildren();

    public Integer getNumNode(Integer zero);
    public Integer getNumNode();
    public Boolean getFlag();
    public String getSql();


}
