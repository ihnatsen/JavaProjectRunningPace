package wit.edu.pl.Rarity;

import java.util.HashMap;

public class Rarity{
    HashMap<String,String> colors;

    @Override
    public String toString() {
        return "Rarity{" +
                "colors=" + colors +
                '}';
    }

    public String getTheColor(String key){
        return this.colors.get(key);
    }

    public HashMap<String, String> getColors() {
        return colors;
    }

    public void setColors(HashMap<String, String> colors) {
        this.colors = colors;
    }
}

