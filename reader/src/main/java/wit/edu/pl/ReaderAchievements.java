package wit.edu.pl;

import com.fasterxml.jackson.databind.ObjectMapper;
import wit.edu.pl.Achievements.Achievements;

import java.io.IOException;


 public class ReaderAchievements implements ReaderJson {

     static private final PathTorDir torDir = new PathTorDir();

     @Override
     public Achievements getRootAchievements(String nameAchievements) {

         ObjectMapper objectMapper = new ObjectMapper();

         Achievements root = null;
         try {
             root = objectMapper.readValue(torDir.getPathToAchievements(nameAchievements), Achievements.class);
             return root;
         }
        catch (IOException e){
            try {
                root = (objectMapper.readValue(torDir.getPathToAchievements("defaultAchievements.json"), Achievements.class));
                return root;
                //Never use 100%
            } catch (IOException ex) {
                return null;
                }

            }
        }

     }
