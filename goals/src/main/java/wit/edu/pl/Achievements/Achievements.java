package wit.edu.pl.Achievements;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Achievements implements BeverageAchievements {
    public static int Att = 1;
    private String title,description,rarity,sql;

    @Override
    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @JsonIgnore
    private Boolean flag = false;

    public ArrayList<Achievements> children;



    @Override
    public String toString() {
        return switch (Achievements.Att) {
            case 2 -> description;
            case 3 -> rarity;
            case 4 -> sql;
            default -> title;
        };


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }



    public Integer getNumNode(){

        return this.getNumNode(0);
    }



    @Override
    public String getAttributesString() {
        return this.toString();
    }


    public List<Achievements> getChildren() {
        return this.children;
    }


    @Override
    public Integer getNumNode(Integer zero){

        if(children.isEmpty()){
            return ++zero;
        }else{
            for(Achievements none: this.children){
                zero = none.getNumNode(zero);
            }
        }
        return ++zero;
    }

}
