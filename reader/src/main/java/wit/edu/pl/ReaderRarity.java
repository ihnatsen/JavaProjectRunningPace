package wit.edu.pl;

import java.io.IOException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public final class ReaderRarity implements ReaderXML {

    static PathTorDir torDir = new PathTorDir();

    @Override
    public Rarity getRarity(String nameRarity) {

        XmlMapper xmlMapper =new XmlMapper();

        Rarity rarity = null;
        try {
            rarity = xmlMapper.readValue(torDir.getPathToAchievements(nameRarity), Rarity.class);
            return rarity;
        }
        catch (IOException e){
            try {
                rarity = xmlMapper.readValue(torDir.getPathToAchievements("defaultRarity.xml"), Rarity.class);
                return rarity;
                //Never use 100%
            } catch (IOException ex) {
                return null;
            }

        }
    }
}

