package wit.edu.pl;

import java.util.ArrayList;
import java.util.HashMap;

public class Rarity {
    HashMap<String,String> colors;

    @Override
    public String toString() {
        return "Rarity{" +
                "colors=" + colors +
                '}';
    }

    public HashMap<String, String> getColors() {
        return colors;
    }

    public void setColors(HashMap<String, String> colors) {
        this.colors = colors;
    }
}

