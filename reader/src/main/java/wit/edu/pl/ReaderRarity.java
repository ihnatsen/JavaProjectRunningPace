package wit.edu.pl;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import wit.edu.pl.Rarity.Rarity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public final class ReaderRarity implements ReaderXML {


    @Override
    public Rarity getRarity() {

        XmlMapper xmlMapper =new XmlMapper();

        Rarity rarity = null;
        try {
            Properties properties = new Properties();
            System.out.println(PathToDir.getPathToGlobalConfig());
            properties.load(new FileInputStream(PathToDir.getPathToGlobalConfig()));
            String nameRarity = properties.getProperty("nameRarity");
            rarity = xmlMapper.readValue(new File(PathToDir.getPathToModuleFile("achievements",nameRarity)), Rarity.class);
            return rarity;
        }
        catch (IOException e){
            try {
                rarity = xmlMapper.readValue(new File(PathToDir.getPathToModuleFile("achievements","defaultRarity.xml")), Rarity.class);
                return rarity;
                //Never use 100%
            } catch (IOException ex) {
                return null;
            }

        }
    }
}

