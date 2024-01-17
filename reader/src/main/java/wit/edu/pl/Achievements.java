package wit.edu.pl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
public class Achievements {
    String title,description,rarity,sql;
    @JsonIgnore
    Boolean flag = false;

    List<Achievements> children;

    @Override
    public String toString() {
        return title;


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

    public List<Achievements> getChildren() {
        return children;
    }

    public void setChildren(List<Achievements> children) {
        this.children = children;
    }
}
