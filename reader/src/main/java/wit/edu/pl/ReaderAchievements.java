package wit.edu.pl;

import com.fasterxml.jackson.databind.ObjectMapper;
import wit.edu.pl.Achievements.Achievements;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReaderAchievements implements ReaderJson {



     @Override
     public Achievements getRootAchievements() {

         ObjectMapper objectMapper = new ObjectMapper();

         Achievements root = null;
         try {
             Properties properties = new Properties();
             System.out.println(PathToDir.getPathToGlobalConfig());
             properties.load(new FileInputStream(PathToDir.getPathToGlobalConfig()));
             String nameAchievements = properties.getProperty("nameAchievements");
             nameAchievements = nameAchievements.substring(1,nameAchievements.length()-1);
             root = objectMapper.readValue(new File(PathToDir.getPathToModuleFile("achievements",nameAchievements)), Achievements.class);
             return root;
         }
        catch (IOException e){
            try {
                root = (objectMapper.readValue(new File(PathToDir.getPathToModuleFile("achievements","defaultAchievements.json")), Achievements.class));
                return root;
                //Never use 100%
            } catch (IOException ex) {
                return root;
                }

            }
        }

     }
