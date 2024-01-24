package wit.edu.pl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTorDir {

    static String rootProject = System.getProperty("user.dir");
    static String goalDirectory = "achievements";
    static String separator = File.separator;

    static String nameApp = "RunningPace";
    
    public File getPathToAchievements(String nameFile){
        Path pathAchievements = Paths.get(
                rootProject      + separator +
                        nameApp + separator+
                goalDirectory    + separator +
                nameFile         + separator);
        System.out.println(pathAchievements.toString());

        return pathAchievements.toFile();
    }
    
}
