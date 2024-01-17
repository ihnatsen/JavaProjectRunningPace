package wit.edu.pl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTorDir {
    static String nameProject = "RunningPace";
    static String rootProject = System.getProperty("user.dir");
    static String goalDirectory = "achievements";
    static String separator = File.separator;
    
    public File getPathToAchievements(String nameFile){
        Path pathAchievements = Paths.get(rootProject      + separator +
                nameProject      + separator +
                goalDirectory    + separator +
                nameFile         + separator);
        return pathAchievements.toFile();
    }
    
}
